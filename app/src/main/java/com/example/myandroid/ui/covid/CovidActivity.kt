package com.example.myandroid.ui.covid

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myandroid.R
import com.example.myandroid.data.covid.TimeLineCasesAllResponse
import com.example.myandroid.databinding.ActivityCovidBinding
import com.example.myandroid.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class CovidActivity : BaseActivity() {

    private val binding by lazy { ActivityCovidBinding.inflate(layoutInflater) }
    private val covidAdapter by lazy { CovidAdapter(::onCovidItemClicked) }
    private val viewModel: CovidViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpView()
        initObserver()
        viewModel.executeGetTimeLineCasesAll()
    }

    private fun setUpView() {
        binding.rvTimeLine.apply {
            adapter = covidAdapter
            layoutManager = LinearLayoutManager(this@CovidActivity)
        }
    }

    private fun initObserver() {
        val owner = this
        with(viewModel) {
            loading.observe(owner, {
                showLoading(it)
            })
            errorDialog.observe(owner, {
                showDialog(message = it)
            })

            displayTimeLineCases.observe(owner, {
                covidAdapter.update(it)
            })
        }
    }

    private fun onCovidItemClicked(item: TimeLineCasesAllResponse) {
        Log.d(logTag, "onCovidItemClicked: $item")
    }

    private fun showLoading(show: Boolean) {
        if (show) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun showDialog(message: String) {
        val builder = AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(R.string.btn_ok) { dialog, _ ->
                dialog.dismiss()
                Log.d(logTag, "onPositiveClicked")
            }
            .setCancelable(false)
            .create()

        builder.show()
    }

    companion object {

        fun startIntent(context: Context) {
            Intent(context, CovidActivity::class.java)
                .run { context.startActivity(this) }
        }
    }
}
