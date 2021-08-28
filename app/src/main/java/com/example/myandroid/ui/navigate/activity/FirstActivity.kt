package com.example.myandroid.ui.navigate.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myandroid.R
import com.example.myandroid.databinding.ActivityFirstBinding
import com.example.myandroid.model.SecondModel
import com.example.myandroid.ui.base.BaseActivity

class FirstActivity : BaseActivity() {

    private val binding by lazy { ActivityFirstBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpView()
    }

    private fun setUpView() {
        setTitle(R.string.title_first_activity)

        binding.btnNextForResult.setOnClickListener {
            val name = binding.edtName.text.toString()
            navigateToSecondForResult(SecondModel(name = name))
        }

        binding.btnNext.setOnClickListener {
            val name = binding.edtName.text.toString()
            navigateToSecondActivity(SecondModel(name = name))
        }
    }

    private fun navigateToSecondActivity(secondModel: SecondModel) {
//        navigateToSecondBySelf(secondModel)
        navigateToSecondByInside(secondModel)
    }

    private fun navigateToSecondBySelf(secondModel: SecondModel) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(SecondActivity.EXTRA_MODEL, secondModel)
        startActivity(intent)
//        finish()
    }

    private val startSecondForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                // Handle the Intent
                Log.d(logTag, "result: ${intent?.getStringExtra("name_data")}")
            }
        }

    private fun navigateToSecondForResult(secondModel: SecondModel) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(SecondActivity.EXTRA_MODEL, secondModel)
        startSecondForResult.launch(intent)
    }

    private fun navigateToSecondByInside(secondModel: SecondModel) {
        SecondActivity.startIntent(
            context = this,
            secondModel = secondModel
        )
    }

    companion object {

        fun startIntent(context: Context) {
            Intent(context, FirstActivity::class.java)
                .run { context.startActivity(this) }
        }
    }
}
