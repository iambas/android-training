package com.example.myandroid.ui.navigate.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myandroid.R
import com.example.myandroid.databinding.FragmentFirstBinding
import com.example.myandroid.model.SecondModel
import com.example.myandroid.ui.base.BaseFragement

class FirstFragment : BaseFragement() {

    private val binding get() = _binding as FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i(logTag, "onCreateView")
        _binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.setTitle(R.string.title_first_fragment)
        binding.btnNext.setOnClickListener {
            navigateToSecond()
        }
    }

    private fun navigateToSecond() {
        val directions = FirstFragmentDirections.actionFirstFragmentToSecondFragment(
            SecondModel(name = "name from FirstFragment")
        )
        findNavController().navigate(directions)
    }
}
