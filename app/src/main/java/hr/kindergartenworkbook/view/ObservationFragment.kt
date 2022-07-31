package hr.kindergartenworkbook.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.tabs.TabLayoutMediator
import hr.kindergartenworkbook.data.IRepository
import hr.kindergartenworkbook.databinding.FragmentObservationBinding
import hr.kindergartenworkbook.model.Activity
import hr.kindergartenworkbook.model.User
import hr.kindergartenworkbook.utils.showShortToast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                try {
                    user = repo.getUser()
                    activities = repo.getActivities(user.groupId, "")
                    withContext(Dispatchers.Main) {
                        setGroupName()
                        initTodayDate()
                        initViewPager()
                        initTabLayout()
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        this@ObservationFragment.requireContext()
                            .showShortToast(e.message ?: "Unknown error occurred")
                    }
                }
            }
        }
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