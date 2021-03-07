package com.fededri.masterdetail_library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MasterDetailFragmentImpl(
    private val delegate: MasterDetailDelegate
) : MasterDetailFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        if (isTabletMode()) {
            displayMasterDetailLayout(view)
        } else {
            displaySingleLayout(view)
        }

        return view
    }

    override fun isTabletMode(): Boolean {
        return resources.getBoolean(R.bool.isTablet)
    }

    private fun displayMasterDetailLayout(view: View) {
        val homeHost = delegate.createHomeNavHostFragment()
        val detailsHost = delegate.createDetailsNavHostFragment()
        childFragmentManager.beginTransaction()
            .replace(R.id.main_container, homeHost)
            .commit()

        childFragmentManager.beginTransaction()
            .replace(R.id.details_container, detailsHost)
            .commit()
    }

    private fun displaySingleLayout(view: View) {
        val navHost = delegate.createHomeNavHostFragment()
        childFragmentManager.beginTransaction()
            .replace(R.id.main_container, navHost)
            .setPrimaryNavigationFragment(navHost)
            .commit()
    }


    override fun handleBackPressed(): Boolean {
        return false
    }

}