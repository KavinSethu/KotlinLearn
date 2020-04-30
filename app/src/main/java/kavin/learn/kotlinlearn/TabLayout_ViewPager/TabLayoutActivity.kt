package kavin.learn.kotlinlearn.TabLayout_ViewPager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import kavin.learn.kotlinlearn.R;
import kavin.learn.kotlinlearn.TabLayout_ViewPager.Adapter.TabsAdapter

public class TabLayoutActivity : AppCompatActivity() {

    var tabLayout:TabLayout?=null
    var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)

        initView()

        tabLayout!!.addTab(tabLayout!!.newTab().setText("Home"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Sport"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Movie"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = TabsAdapter(this, supportFragmentManager, tabLayout!!.tabCount)
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

    }

    private fun initView() {
        tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager = findViewById<ViewPager>(R.id.viewPager)
    }
}
