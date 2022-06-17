package hr.kindergartenworkbook.view

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import hr.kindergartenworkbook.data.IRepository
import hr.kindergartenworkbook.model.Activity

class ChildrenObservationViewPagerAdapter(
    fragment: Fragment,
    private val activities: List<Activity>,
    private val repo: IRepository)
    : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return activities.count()
    }

    override fun createFragment(position: Int): Fragment {
        return  ChildrenObservationFragment(repo, activities[position])
    }
}