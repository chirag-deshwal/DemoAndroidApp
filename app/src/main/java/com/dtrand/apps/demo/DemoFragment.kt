package com.dtrand.apps.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DemoFragment(private val displayText : String) : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = View.inflate(requireContext(), R.layout.demo_fragement, null)

        view.findViewById<TextView>(R.id.displayText).apply {
            text = displayText
        }



        return view

    }


}