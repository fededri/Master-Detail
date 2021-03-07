package com.fededri.masterdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class DetailFragment : Fragment() {

    private val navController by lazy { findNavController() }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.demo_detail_fragment, container, false)
        val buttonNext = view.findViewById<Button>(R.id.button_next)
        buttonNext.setOnClickListener {
            navController.navigate(R.id.afterDetails)
        }
        return view
    }
}