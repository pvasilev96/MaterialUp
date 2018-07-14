package com.pvasilev.uplabs.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.pvasilev.uplabs.R
import com.pvasilev.uplabs.ui.base.BaseTabFragment
import com.pvasilev.uplabs.di.DI
import com.pvasilev.uplabs.di.modules.NavigationModule
import com.pvasilev.uplabs.ui.Screens
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.SupportAppNavigator
import toothpick.Toothpick

class ProfileTabFragment : BaseTabFragment() {
    override val rootScreen: String
        get() = Screens.PROFILE_SCREEN

    override fun onCreate(savedInstanceState: Bundle?) {
        val scope = Toothpick.openScope(DI.PROFILE_TAB_SCOPE)
        scope.installModules(NavigationModule())
        router = scope.getInstance(Router::class.java)
        navigatorHolder = scope.getInstance(NavigatorHolder::class.java)
        super.onCreate(savedInstanceState)
    }

    override fun createNavigator(): Navigator {
        return object : SupportAppNavigator(activity, childFragmentManager, R.id.tab_container) {
            override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? = null

            override fun createFragment(screenKey: String, data: Any?): Fragment? =
                    when (screenKey) {
                        Screens.PROFILE_SCREEN -> ProfileFragment()
                        else -> null
                    }
        }
    }
}