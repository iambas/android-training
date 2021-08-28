package com.example.myandroid.ui.architecture

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doBeforeTextChanged
import androidx.core.widget.doOnTextChanged
import com.example.myandroid.R
import com.example.myandroid.databinding.ActivityArchitectureBinding
import com.example.myandroid.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArchitectureActivity : BaseActivity() {

    private val binding by lazy { ActivityArchitectureBinding.inflate(layoutInflater) }
    private val viewModel: ArchitectureViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        initObserver()
        setUpView()
    }

    private fun initObserver() {
        viewModel.errorDialog.observe(this, {
            showDialog(it)
        })
    }

    private fun setUpView() {
        displayArrowIconForBack()
        handleWeightEditText()
    }

    private fun handleWeightEditText() {
        binding.edtWeight.doBeforeTextChanged { text, start, count, after ->
            Log.d(
                logTag,
                "doBeforeTextChanged -> text: $text, start: $start, count: $count, after: $after"
            )
        }
        binding.edtWeight.doOnTextChanged { text, start, before, count ->
            Log.d(
                logTag,
                "doOnTextChanged -> text: $text, start: $start, before: $before, count: $count"
            )
        }
        binding.edtWeight.doAfterTextChanged { editable ->
            Log.d(logTag, "doAfterTextChanged -> ${editable.toString()}")
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
            Intent(context, ArchitectureActivity::class.java)
                .run { context.startActivity(this) }
        }
    }
}
