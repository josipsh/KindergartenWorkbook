package hr.kindergartenworkbook.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import hr.kindergartenworkbook.data.IRepository
import hr.kindergartenworkbook.databinding.FragmentObservationBinding
import hr.kindergartenworkbook.model.Activity
import hr.kindergartenworkbook.model.User
import java.text.SimpleDateFormat
import java.util.*

class ObservationFragment(private val repo: IRepository) : Fragment() {

    private lateinit var binding: FragmentObservationBinding
    private lateinit var activities: List<Activity>
    private lateinit var user: User
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

        user = repo.getUser()
        activities = repo.getActivities(user.groupId, "")

        setGroupName()
        initTodayDate()
        initViewPager()
        initTabLayout()
    }

    private fun setGroupName() {
        binding.etGroupName.text = user.groupName
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
}