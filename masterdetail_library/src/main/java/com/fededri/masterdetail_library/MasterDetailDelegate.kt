package com.fededri.masterdetail_library

import androidx.navigation.fragment.NavHostFragment

interface MasterDetailDelegate {
    fun createHomeNavHostFragment(): NavHostFragment
    fun createDetailsNavHostFragment(): NavHostFragment
}