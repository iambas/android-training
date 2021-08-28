package com.example.myandroid.ui.fragment.basic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.myandroid.R
import com.example.myandroid.databinding.ActivityBasicFragmentBinding
import com.example.myandroid.ui.base.BaseActivity

class BasicFragmentActivity : BaseActivity() {

    private val binding by lazy { ActivityBasicFragmentBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                // use setReorderingAllowed(true) when performing a FragmentTransaction
                setReorderingAllowed(true)
                add<FirstBasicFragment>(R.id.basic_fragment_view)
            }
        }
    }

    companion object {

        fun startIntent(context: Context) {
            Intent(context, BasicFragmentActivity::class.java)
                .run { context.startActivity(this) }
        }
    }
}
