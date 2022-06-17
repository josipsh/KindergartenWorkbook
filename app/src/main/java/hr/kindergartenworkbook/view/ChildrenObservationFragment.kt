package hr.kindergartenworkbook.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import hr.kindergartenworkbook.R
import hr.kindergartenworkbook.data.IRepository
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

        binding.recycleView.adapter = ChildrenObservableRecyclerViewAdapter(children)
        binding.recycleView.layoutManager = LinearLayoutManager(requireContext())
    }
}