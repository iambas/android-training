package com.example.myandroid.ui.shared_preferences

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.myandroid.databinding.ActivitySharedPreferencesBinding
import com.example.myandroid.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SharedPreferencesActivity : BaseActivity() {

    private val binding by lazy { ActivitySharedPreferencesBinding.inflate(layoutInflater) }
    private val viewModel: SharedPreferencesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    companion object {

        fun startIntent(context: Context) {
            Intent(context, SharedPreferencesActivity::class.java)
                .run { context.startActivity(this) }
        }
    }
}
