package com.fededri.masterdetail_library

import androidx.fragment.app.Fragment

abstract class MasterDetailFragment : Fragment() {
    abstract fun handleBackPressed(): Boolean
    abstract fun isTabletMode(): Boolean

    companion object {
        fun create(delegate: MasterDetailDelegate): MasterDetailFragmentImpl {
            return MasterDetailFragmentImpl(delegate)
        }
    }
}