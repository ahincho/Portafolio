package com.unsa.bmi

import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class CalculatorActivity : AppCompatActivity() {
    private var isMaleSelected : Boolean = true
    private var isFemaleSelected : Boolean = false
    private lateinit var cardMale : CardView
    private lateinit var cardFemale : CardView
    private lateinit var tvHeight : TextView
    private lateinit var rsHeight : RangeSlider
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        initComponents()
        initListeners()
        initUserInterface()
    }
    private fun initComponents() {
        cardMale = findViewById(R.id.cardMale)
        cardFemale = findViewById(R.id.cardFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
    }
    private fun initListeners() {
        cardMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        cardFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            val res = df.format(value)
            "${res}cm".also { tvHeight.text = it }
        }
    }
    private fun setGenderColor() {
        cardMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        cardFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }
    private fun getBackgroundColor(isSelectedComponent : Boolean) : Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorReference)
    }
    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }
    private fun initUserInterface() {
        setGenderColor()
    }
}