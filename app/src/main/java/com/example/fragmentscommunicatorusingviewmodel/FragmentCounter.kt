package com.example.fragmentscommunicatorusingviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_counter.view.*

class FragmentCounter : Fragment() {

    private var counter = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val viewModel = ViewModelProvider(requireActivity(), ViewModelFactory())
            .get(SharedViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_counter, container, false)
        view.counterButton.setOnClickListener {
            counter++
            viewModel.select(counter)
        }
        return view
    }
}