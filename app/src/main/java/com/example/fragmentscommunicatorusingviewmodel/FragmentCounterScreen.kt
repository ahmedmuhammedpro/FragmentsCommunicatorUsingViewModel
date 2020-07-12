package com.example.fragmentscommunicatorusingviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_counter_screen.view.*

class FragmentCounterScreen : Fragment() {

    var mover: MoveToFragmentCounter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_counter_screen, container, false)
        val viewModel = ViewModelProvider(requireActivity(), ViewModelFactory())
            .get(SharedViewModel::class.java)

        viewModel.getSelected().observe(viewLifecycleOwner, Observer { counter ->
            view.counterTextView.text = "$counter"
        })

        view.moveToFragmentCounter.setOnClickListener {
            mover?.moveToFragmentCounter()
        }

        return view
    }

    interface MoveToFragmentCounter {
        fun moveToFragmentCounter()
    }
}