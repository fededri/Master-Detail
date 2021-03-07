package com.fededri.masterdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavDestination
import androidx.navigation.fragment.findNavController
import com.fededri.masterdetail_library.MasterDetailFragment

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.demo_home_fragment, container, false)

        val button = view.findViewById<Button>(R.id.button_go_to_details)

        button.setOnClickListener {
            //Knowing which navigation controller use is client's responsibility
            val controller = getMasterDetailActivity().provideDetailsNavController()
                ?: getMasterDetailActivity().provideHomeNavController()
            controller.navigate(R.id.afterDetails)
        }
        return view
    }

    private fun getMasterDetailActivity(): MainActivity {
        return activity as MainActivity
    }
}