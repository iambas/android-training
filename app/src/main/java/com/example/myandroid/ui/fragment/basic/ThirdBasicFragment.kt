package com.example.myandroid.ui.fragment.basic

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myandroid.databinding.FragmentThirdBinding
import com.example.myandroid.ui.base.BaseFragement

class ThirdBasicFragment : BaseFragement() {

    private val binding get() = _binding as FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i(logTag, "onCreateView")
        _binding = FragmentThirdBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDone.setOnClickListener {
            // TODO
        }
    }
}
