package com.example.myandroid.ui.navigate.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.myandroid.R
import com.example.myandroid.databinding.ActivitySecondBinding
import com.example.myandroid.model.SecondModel
import com.example.myandroid.ui.base.BaseActivity

class SecondActivity : BaseActivity() {

    private val binding by lazy { ActivitySecondBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpView()
    }

    private fun setUpView() {
        setTitle(R.string.title_second_activity)
        displayData()
        setUpButton()
    }

    private fun displayData() {
        val secondModel = intent.getParcelableExtra<SecondModel>(EXTRA_MODEL)
        Log.d(logTag, "SecondModel: ${secondModel?.name}")
        binding.tvData.text = secondModel?.name
    }

    private fun setUpButton() {
        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnCloseWithResult.setOnClickListener {
            val data = Intent()
                .putExtra("name_data", "data value")
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }

    companion object {

        const val EXTRA_MODEL = "second_model"

        fun startIntent(context: Context, secondModel: SecondModel) {
            Intent(context, SecondActivity::class.java)
                .putExtra(EXTRA_MODEL, secondModel)
                .run { context.startActivity(this) }
        }
    }
}
