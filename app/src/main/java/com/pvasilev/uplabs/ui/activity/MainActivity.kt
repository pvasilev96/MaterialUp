package com.pvasilev.uplabs.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.pvasilev.uplabs.R
import com.pvasilev.uplabs.ui.base.BaseTabFragment
import com.pvasilev.uplabs.ui.fragment.NotificationTabFragment
import com.pvasilev.uplabs.ui.fragment.PostTabFragment
import com.pvasilev.uplabs.ui.fragment.ProfileTabFragment
import com.pvasilev.uplabs.ui.fragment.SearchTabFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val tabs: MutableList<BaseTabFragment> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            createTabs()
            attachTabs()
        }
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val navigationItems = listOf(
                AHBottomNavigationItem(resources.getString(R.string.menu_item_feed), R.drawable.ic_feed),
                AHBottomNavigationItem(resources.getString(R.string.menu_item_search), R.drawable.ic_search),
                AHBottomNavigationItem(resources.getString(R.string.menu_item_notifications), R.drawable.ic_notifications),
                AHBottomNavigationItem(resources.getString(R.string.menu_item_profile), R.drawable.ic_person)
        )
        bottom_navigation.addItems(navigationItems)
        bottom_navigation.titleState = AHBottomNavigation.TitleState.ALWAYS_HIDE
        bottom_navigation.setOnTabSelectedListener { position, _ -> onTabSelected(position) }
        bottom_navigation.currentItem = 0
    }

    private fun createTabs() {
        tabs.apply {
            add(PostTabFragment())
            add(SearchTabFragment())
            add(NotificationTabFragment())
            add(ProfileTabFragment())
        }
    }

    private fun attachTabs() {
        supportFragmentManager.beginTransaction()
                .add(R.id.main_container, tabs[0])
                .add(R.id.main_container, tabs[1])
                .add(R.id.main_container, tabs[2])
                .add(R.id.main_container, tabs[3])
                .commit()
    }

    private fun onTabSelected(position: Int): Boolean {
        val transaction = supportFragmentManager.beginTransaction()
        tabs.forEachIndexed { index, fragment ->
            if (index == position) transaction.attach(fragment)
            else transaction.detach(fragment)
        }
        transaction.commit()
        return true
    }
}