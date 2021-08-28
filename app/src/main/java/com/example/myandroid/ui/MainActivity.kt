package com.example.myandroid.ui

import android.os.Bundle
import com.example.myandroid.databinding.ActivityMainBinding
import com.example.myandroid.ui.base.BaseActivity
import com.example.myandroid.ui.covid.CovidActivity
import com.example.myandroid.ui.architecture.ArchitectureActivity
import com.example.myandroid.ui.fragment.basic.BasicFragmentActivity
import com.example.myandroid.ui.fragment.bottom.BottomNavigationActivity
import com.example.myandroid.ui.layout.ConstraintLayoutActivity
import com.example.myandroid.ui.layout.LinearLayoutActivity
import com.example.myandroid.ui.navigate.fragment.NavigationComponentActivity
import com.example.myandroid.ui.navigate.activity.FirstActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        initObserver()
    }

    private fun initObserver() {
        val owner = this
        with(viewModel) {
            navigateToLinearLayout.observe(owner, {
                navigateToLinearLayout()
            })
            navigateToConstraintLayout.observe(owner, {
                navigateToConstraintLayout()
            })
            navigateToActivityNavigation.observe(owner, {
                navigateToActivityNavigation()
            })
            navigateToBasicFragment.observe(owner, {
                navigateToBasicFragment()
            })
            navigateToBottomNavigation.observe(owner, {
                navigateToBottomNavigation()
            })
            navigateToNavigationComponent.observe(owner, {
                navigateToNavigationComponent()
            })
            navigateToArchitecture.observe(owner, {
                navigateToArchitecture()
            })
            navigateToCallService.observe(owner, {
                navigateToCallService()
            })
        }
    }

    private fun navigateToLinearLayout() {
        LinearLayoutActivity.startIntent(this)
    }

    private fun navigateToConstraintLayout() {
        ConstraintLayoutActivity.startIntent(this)
    }

    private fun navigateToActivityNavigation() {
        FirstActivity.startIntent(this)
    }

    private fun navigateToBasicFragment() {
        BasicFragmentActivity.startIntent(this)
    }

    private fun navigateToNavigationComponent() {
        NavigationComponentActivity.startIntent(this)
    }

    private fun navigateToBottomNavigation() {
        BottomNavigationActivity.startIntent(this)
    }

    private fun navigateToArchitecture() {
        ArchitectureActivity.startIntent(this)
    }

    private fun navigateToCallService() {
        CovidActivity.startIntent(this)
    }
}
