package com.fededri.masterdetail

import androidx.navigation.NavController

interface NavHostProvider {
    fun provideHomeNavController(): NavController
    fun provideDetailsNavController(): NavController?
}