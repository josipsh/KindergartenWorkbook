package hr.kindergartenworkbook.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import hr.kindergartenworkbook.R
import hr.kindergartenworkbook.data.IRepository
import hr.kindergartenworkbook.databinding.AlertEditTextBinding
import hr.kindergartenworkbook.databinding.FragmentChildrenObservationBinding
import hr.kindergartenworkbook.model.Activity
import hr.kindergartenworkbook.model.Child

class ChildrenObservationFragment(private val repo: IRepository, private val activity: Activity) : Fragment() {

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
        children = repo.getChildren(0, activity.id)

        binding.recycleView.adapter = ChildrenObservableRecyclerViewAdapter(children){
            handleInputAlert(it)
        }
        binding.recycleView.layoutManager = LinearLayoutManager(requireContext())

        binding.btnSave.setOnClickListener {
            if (repo.saveObservation(children)){
                handleAlert("Saved", "Changes are successfully saved")
            }else{
                handleAlert("Error", "Unknown error occurred!")
            }
        }
    }

    private fun handleInputAlert(child: Child){
        val inflater = requireActivity().layoutInflater
        val editTextBinding = AlertEditTextBinding.inflate(inflater)
        editTextBinding.etNote.editText?.setText(child.note)

        AlertDialog.Builder(this.requireContext(), R.style.AppTheme_InputDialog).apply {
            setTitle("Enter note for $child")
            setView(editTextBinding.root)
            setPositiveButton(getString(R.string.ok)) {_,_ ->
                child.note = editTextBinding.etNote.editText?.text.toString()
            }
            setNegativeButton(getString(R.string.cancel), null)
            setCancelable(false)
            create()
            show()
        }
    }

    private fun handleAlert(title: String, message: String){
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