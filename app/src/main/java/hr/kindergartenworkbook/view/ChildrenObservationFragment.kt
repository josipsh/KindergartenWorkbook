package hr.kindergartenworkbook.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import hr.kindergartenworkbook.R
import hr.kindergartenworkbook.data.IRepository
import hr.kindergartenworkbook.databinding.AlertEditTextBinding
import hr.kindergartenworkbook.databinding.FragmentChildrenObservationBinding
import hr.kindergartenworkbook.model.Activity
import hr.kindergartenworkbook.model.Child
import hr.kindergartenworkbook.utils.showShortToast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChildrenObservationFragment(private val repo: IRepository, private val activity: Activity) :
    Fragment() {

    private lateinit var binding: FragmentChildrenObservationBinding
    private lateinit var children: List<Child>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChildrenObservationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                try {
                    children = repo.getChildren(1, activity.id)

                    withContext(Dispatchers.Main) {
                        binding.recycleView.adapter =
                            ChildrenObservableRecyclerViewAdapter(children) {
                                handleInputAlert(it)
                            }
                        binding.recycleView.layoutManager = LinearLayoutManager(requireContext())
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        this@ChildrenObservationFragment.requireContext()
                            .showShortToast(e.message ?: "Unknown error occurred")
                    }
                }
            }
        }

        binding.btnSave.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    try {
                        if (repo.saveObservation(children)) {
                            withContext(Dispatchers.Main) {
                                handleAlert("Saved", "Changes are successfully saved")
                            }
                        } else {
                            withContext(Dispatchers.Main) {
                                handleAlert("Not saved", "Unexpected error occurred")
                            }
                        }
                    } catch (e: Exception) {
                        withContext(Dispatchers.Main) {
                            this@ChildrenObservationFragment.requireContext()
                                .showShortToast(e.message ?: "Unknown error occurred")
                        }
                    }
                }
            }
        }
    }

    private fun handleInputAlert(child: Child) {
        val inflater = requireActivity().layoutInflater
        val editTextBinding = AlertEditTextBinding.inflate(inflater)
        editTextBinding.etNote.editText?.setText(child.note)

        AlertDialog.Builder(this.requireContext(), R.style.AppTheme_InputDialog).apply {
            setTitle("Enter note for $child")
            setView(editTextBinding.root)
            setPositiveButton(getString(R.string.ok)) { _, _ ->
                child.note = editTextBinding.etNote.editText?.text.toString()
            }
            setNegativeButton(getString(R.string.cancel), null)
            setCancelable(false)
            create()
            show()
        }
    }

    private fun handleAlert(title: String, message: String) {
        AlertDialog.Builder(this.requireContext(), R.style.AppTheme_InputDialog).apply {
            setTitle(title)
            setMessage(message)
            setPositiveButton(getString(R.string.ok), null)
            setCancelable(false)
            create()
            show()
        }
    }
}