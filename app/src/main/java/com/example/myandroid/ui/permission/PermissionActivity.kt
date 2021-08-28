package com.example.myandroid.ui.permission

import android.Manifest
import android.os.Bundle
import android.util.Log
import com.example.myandroid.databinding.ActivityPermissionBinding
import com.example.myandroid.ui.base.BaseActivity
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener

class PermissionActivity : BaseActivity() {

    private val binding by lazy { ActivityPermissionBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRequestPermission.setOnClickListener {
            requestPermission()
        }
    }

    private fun requestPermission() {
        Dexter.withContext(this)
            .withPermission(Manifest.permission.CAMERA)
            .withListener(object : PermissionListener {
                override fun onPermissionGranted(grantedResponse: PermissionGrantedResponse?) {
                    Log.d(logTag, "onPermissionGranted")
                }

                override fun onPermissionDenied(deniedResponse: PermissionDeniedResponse?) {
                    Log.d(logTag, "onPermissionDenied")

                    if (deniedResponse?.isPermanentlyDenied == true) {
                        Log.d(logTag, "Permanently Denied")
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    request: PermissionRequest?,
                    token: PermissionToken?
                ) {
                    Log.d(logTag, "onPermissionRationaleShouldBeShown")
                    token?.continuePermissionRequest()
                }
            }).check()
    }
}
