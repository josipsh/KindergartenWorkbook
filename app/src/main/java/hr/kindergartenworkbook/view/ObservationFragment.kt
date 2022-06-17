package hr.kindergartenworkbook.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import hr.kindergartenworkbook.R
import hr.kindergartenworkbook.data.IRepository
import hr.kindergartenworkbook.databinding.FragmentObservationBinding
import hr.kindergartenworkbook.model.Activity
import hr.kindergartenworkbook.model.Category
import java.text.SimpleDateFormat
import java.util.*

class ObservationFragment(private val repo: IRepository) : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: FragmentObservationBinding
    private lateinit var categories: List<Category>
    private lateinit var activities: List<Activity>
    private lateinit var selectedCategory: Category
    private var todayDate: Date = Date()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentObservationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categories = repo.getCategories()
        activities = repo.getActivities(1, "")

        initSpinner()
        initTodayDate()
        initViewPager()
        initTabLayout()
    }

    private fun initSpinner() {
        ArrayAdapter(
            this.requireContext(),
            R.layout.category_spinner_item,
            categories
        ).apply {
            this.setDropDownViewResource(R.layout.category_spinner_item)
            binding.categorySpinner.adapter = this
            binding.categorySpinner.onItemSelectedListener = this@ObservationFragment
        }
    }

    private fun initTodayDate() {
        val sdf = SimpleDateFormat.getDateInstance()
        binding.etDate.text = sdf.format(todayDate)
    }

    private fun initViewPager() {
        binding.viewPager.adapter = ChildrenObservationViewPagerAdapter(this, activities, repo)
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            val currentActivity = activities[position]
            tab.text = currentActivity.name
        }.attach()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        selectedCategory = categories[position]
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}