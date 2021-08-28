package com.example.myandroid.ui.fragment.basic

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myandroid.databinding.FragmentSecondBinding
import com.example.myandroid.ui.base.BaseFragement
import com.example.myandroid.model.SecondModel

class SecondBasicFragment : BaseFragement() {

    private val binding get() = _binding as FragmentSecondBinding

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

        val model = requireArguments().getParcelable<SecondModel>("model")
        binding.tvData.text = model?.name ?: "Not found model"

        binding.btnNext.setOnClickListener {
            navigateToThird()
        }
    }

    private fun navigateToThird() {
        // TODO
    }
}
