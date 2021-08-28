package com.example.myandroid.ui.fragment.basic

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.myandroid.R
import com.example.myandroid.databinding.FragmentFirstBinding
import com.example.myandroid.ui.base.BaseFragement
import com.example.myandroid.model.SecondModel

class FirstBasicFragment : BaseFragement() {

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

        binding.btnNext.setOnClickListener {
            navigateToSecond()
        }
    }

    private fun navigateToSecond() {
        activity?.supportFragmentManager?.commit {
            setReorderingAllowed(true)

            val bundle = bundleOf("model" to SecondModel(name = "name from FirstBasicFragment"))
            add<SecondBasicFragment>(R.id.basic_fragment_view, args = bundle)
            addToBackStack(null)
        }
    }
}
