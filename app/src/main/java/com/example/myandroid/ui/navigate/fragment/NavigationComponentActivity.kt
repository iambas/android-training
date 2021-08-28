package com.example.myandroid.ui.navigate.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.myandroid.databinding.ActivityNavigationComponentBinding
import com.example.myandroid.ui.base.BaseActivity

class NavigationComponentActivity : BaseActivity() {

    private val binding by lazy { ActivityNavigationComponentBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    /**
     * Example for don't back pressed on first screen of Activity has any fragment.
     */
//    override fun onBackPressed() {
//        val backStackEntryCount = supportFragmentManager.backStackEntryCount
//        Log.i(logTag, "onBackPressed: $backStackEntryCount")
//        if (backStackEntryCount == 0) {
//            return
//        }
//
//        super.onBackPressed()
//    }

    companion object {

        fun startIntent(context: Context) {
            Intent(context, NavigationComponentActivity::class.java)
                .run { context.startActivity(this) }
        }
    }
}
