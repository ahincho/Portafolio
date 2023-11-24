package com.unsa.bmi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ResultActivity : AppCompatActivity() {
    private lateinit var tvCategory : TextView
    private lateinit var tvBmi : TextView
    private lateinit var tvDescription : TextView
    private lateinit var btnBack : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val result = intent.extras?.getDouble(CalculatorActivity.IMC_RESULT) ?: 0.0
        initComponents()
        initUserInterface(result)
        initListeners()
    }
    private fun initComponents() {
        tvCategory = findViewById(R.id.tvCategory)
        tvBmi = findViewById(R.id.tvBmi)
        tvDescription = findViewById(R.id.tvDescription)
        btnBack = findViewById(R.id.btnBack)
    }
    private fun initUserInterface(result : Double) {
        tvBmi.text = result.toString()
        when (result) {
            in 0.00 .. 18.50 -> {
                tvCategory.text = getString(R.string.low_weight_category)
                tvCategory.setTextColor(ContextCompat.getColor(this, R.color.low_weight))
                tvDescription.text = getString(R.string.low_weight_description)
            }
            in 18.51 .. 24.99 -> {
                tvCategory.text = getString(R.string.normal_weight_category)
                tvCategory.setTextColor(ContextCompat.getColor(this, R.color.normal_weight))
                tvDescription.text = getString(R.string.normal_weight_description)
            }
            in 25.00 .. 29.99 -> {
                tvCategory.text = getString(R.string.over_weight_category)
                tvCategory.setTextColor(ContextCompat.getColor(this, R.color.over_weight))
                tvDescription.text = getString(R.string.over_weight_description)
            }
            in 30.00 .. 34.99 -> {
                tvCategory.text = getString(R.string.obesity_weight_category)
                tvCategory.setTextColor(ContextCompat.getColor(this, R.color.obesity_weight))
                tvDescription.text = getString(R.string.obesity_weight_description)
            }
            else -> {
                tvCategory.text = getString(R.string.error)
                tvCategory.setTextColor(ContextCompat.getColor(this, R.color.white))
                tvBmi.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }
        }
    }
    private fun initListeners() {
        btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}