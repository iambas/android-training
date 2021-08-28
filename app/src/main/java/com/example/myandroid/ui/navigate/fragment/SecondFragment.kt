package com.example.myandroid.ui.navigate.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.myandroid.R
import com.example.myandroid.databinding.FragmentSecondBinding
import com.example.myandroid.ui.base.BaseFragement

class SecondFragment : BaseFragement() {

    private val binding get() = _binding as FragmentSecondBinding
    private val args by navArgs<SecondFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i(logTag, "onCreateView")
        _binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.setTitle(R.string.title_second_fragment)

        // set data from arguments
        binding.tvData.text = args.model?.name

        binding.btnNext.setOnClickListener {
            navigateToThird()
        }
    }

    private fun navigateToThird() {
        // TODO
    }
}
