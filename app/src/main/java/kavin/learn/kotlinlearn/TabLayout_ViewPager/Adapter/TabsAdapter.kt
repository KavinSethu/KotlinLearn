package kavin.learn.kotlinlearn.TabLayout_ViewPager.Adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import kavin.learn.kotlinlearn.TabLayout_ViewPager.Fragments.TabFragment1
import kavin.learn.kotlinlearn.TabLayout_ViewPager.Fragments.TabFragment2
import kavin.learn.kotlinlearn.TabLayout_ViewPager.Fragments.TabFragment3

/**
 * Created by Kavin on 10/9/2019.
 */
class TabsAdapter(private val myContext: Context, fm: FragmentManager, internal var totalTabs: Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> {
                return TabFragment1()
            }
            1 -> {
                return TabFragment2()
            }
            2 -> {
                return TabFragment3()
            }
            else -> return null
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}