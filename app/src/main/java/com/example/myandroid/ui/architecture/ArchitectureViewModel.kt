package com.example.myandroid.ui.architecture

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.myandroid.ui.base.BaseViewModel
import java.math.RoundingMode
import java.text.DecimalFormat

class ArchitectureViewModel : BaseViewModel() {

    val weight = MutableLiveData<String>()
    val height = MutableLiveData<String>()
    val bmiText = MutableLiveData<String>()
    val result = MutableLiveData<String>()

    /**
     * https://www.lovefitt.com/
     * BMI kg/m2	            อยู่ในเกณท์	            ภาวะเสี่ยงต่อโรค
     * น้อยกว่า 18.50	            น้ำหนักน้อย / ผอม	        มากกว่าคนปกติ
     * ระหว่าง 18.50 - 22.90	    ปกติ (สุขภาพดี)	        เท่าคนปกติ
     * ระหว่าง 23 - 24.90	    ท้วม / โรคอ้วนระดับ 1	    อันตรายระดับ 1
     * ระหว่าง 25 - 29.90	    อ้วน / โรคอ้วนระดับ 2	    อันตรายระดับ 2
     * มากกว่า 30	            อ้วนมาก / โรคอ้วนระดับ 3	อันตรายระดับ 3
     */
    fun onCalculateButtonClicked() {
        if (!validateWeightAndHeight()) {
            showErrorDialog("น้ำหนักหรือส่วนสูงไม่ถูกต้อง")
            return
        }

        val bmi = calculateBMI()
        bmiText.value = "BMI: $bmi"

        result.value = when {
            bmi < 18.5 -> {
                "น้ำหนักน้อย / ผอม"
            }
            bmi <= 22.9 -> {
                "ปกติ (สุขภาพดี)"
            }
            bmi <= 24.9 -> {
                "ท้วม / โรคอ้วนระดับ 1"
            }
            bmi <= 29.9 -> {
                "อ้วน / โรคอ้วนระดับ 2"
            }
            else -> {
                "อ้วนมาก / โรคอ้วนระดับ 3"
            }
        }
    }

    fun calculateBMI(): Double {
        val weightDouble = weight.value?.toDoubleOrNull() ?: 0.0
        val heightDouble = (height.value?.toDoubleOrNull() ?: 1.0) / 100
        val bmi = weightDouble / (heightDouble * heightDouble)
        return roundOffDecimal(bmi)
    }

    private fun validateWeightAndHeight(): Boolean {
//        Log.d(tag, "weight: ${weight.value}")
//        Log.d(tag, "height: ${height.value}")

        val weightDouble = weight.value?.toDoubleOrNull()
        val heightDouble = height.value?.toDoubleOrNull()
        return weightDouble != null
                && weightDouble > 0.0
                && heightDouble != null
                && heightDouble > 0.0
    }

    private fun roundOffDecimal(number: Double): Double {
        val decimalFormat = DecimalFormat("#.##")
        decimalFormat.roundingMode = RoundingMode.CEILING
        return decimalFormat.format(number).toDouble()
    }
}
