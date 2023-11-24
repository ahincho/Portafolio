package com.unsa.bmi

import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class CalculatorActivity : AppCompatActivity() {
    private var isMaleSelected : Boolean = true
    private var isFemaleSelected : Boolean = false
    private var currentWeight : Int = 50
    private var currentAge : Int = 20
    private lateinit var cardMale : CardView
    private lateinit var cardFemale : CardView
    private lateinit var tvHeight : TextView
    private lateinit var rsHeight : RangeSlider
    private lateinit var btnSubtractWeight : FloatingActionButton
    private lateinit var btnAddWeight : FloatingActionButton
    private lateinit var tvWeight : TextView
    private lateinit var btnSubtractAge : FloatingActionButton
    private lateinit var btnAddAge : FloatingActionButton
    private lateinit var tvAge : TextView
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
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnAddWeight = findViewById(R.id.btnAddWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnAddAge = findViewById(R.id.btnAddAge)
        tvAge = findViewById(R.id.tvAge)
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
        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            updateWeight()
        }
        btnAddWeight.setOnClickListener {
            currentWeight += 1
            updateWeight()
        }
        btnSubtractAge.setOnClickListener {
            currentAge -= 1
            updateAge()
        }
        btnAddAge.setOnClickListener {
            currentAge += 1
            updateAge()
        }
    }
    private fun initUserInterface() {
        setGenderColor()
        updateWeight()
        updateAge()
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
    private fun updateWeight() {
        tvWeight.text = currentWeight.toString()
    }
    private fun updateAge() {
        "${this.currentAge} years".also { tvAge.text = it }
    }
}