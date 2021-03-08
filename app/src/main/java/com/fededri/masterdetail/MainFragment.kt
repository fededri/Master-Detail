package com.fededri.masterdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.navigation.fragment.NavHostFragment
import com.fededri.masterdetail_library.MasterDetailDelegate
import com.fededri.masterdetail_library.MasterDetailFragment
import com.fededri.masterdetail_library.MasterDetailFragmentImpl

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_fragment, container)

        val masterDetailFragment = instantiate(MasterDetailFragmentImpl::class)

        childFragmentManager.beginTransaction()
            .add(R.id.fragment_container, masterDetailFragment)
            .commit()
        return view
    }

    private fun getMasterDetailActivity(): MainActivity {
        return activity as MainActivity
    }
}


