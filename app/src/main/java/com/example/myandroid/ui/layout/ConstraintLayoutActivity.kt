package com.example.myandroid.ui.layout

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myandroid.databinding.ActivityConstraintLayoutBinding

class ConstraintLayoutActivity : AppCompatActivity() {

    private val binding by lazy { ActivityConstraintLayoutBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    companion object {

        fun startIntent(context: Context) {
            return Intent(context, ConstraintLayoutActivity::class.java)
                .run {
                    context.startActivity(this)
                }
        }
    }
}
