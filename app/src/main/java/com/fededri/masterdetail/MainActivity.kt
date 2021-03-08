package com.fededri.masterdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.fededri.masterdetail_library.MasterDetailDelegate
import com.fededri.masterdetail_library.MasterDetailFragment
import com.fededri.masterdetail_library.MasterDetailFragmentImpl

class MainActivity : AppCompatActivity(), MasterDetailDelegate, NavHostProvider {

    private var homeNavHostFragment: NavHostFragment? = null
    private var detailsNavHostFragment: NavHostFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = FragmentFactoryImpl(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun createDetailsNavHostFragment(): NavHostFragment {
        detailsNavHostFragment = NavHostFragment.create(R.navigation.nav_graph_detail)
        return detailsNavHostFragment!!
    }

    override fun createHomeNavHostFragment(): NavHostFragment {
        homeNavHostFragment = NavHostFragment.create(R.navigation.nav_graph_home)
        return homeNavHostFragment!!
    }

    override fun provideDetailsNavController(): NavController? {
        return detailsNavHostFragment?.navController
    }

    override fun provideHomeNavController(): NavController {
        return homeNavHostFragment!!.navController
    }
}


class FragmentFactoryImpl(private val delegate: MasterDetailDelegate) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            MasterDetailFragmentImpl::class.java.name -> MasterDetailFragment.create(delegate)
            else -> super.instantiate(classLoader, className)
        }
    }
}