package com.fededri.masterdetail

import android.app.Application
import androidx.navigation.fragment.NavHostFragment

class Application : Application() {

    fun createDetailsNavHostFragment(): NavHostFragment {
        return NavHostFragment.create(R.navigation.nav_graph_detail)
    }

    fun createHomeNavHostFragment(): NavHostFragment {
        return NavHostFragment.create(R.navigation.nav_graph_home)
    }
}