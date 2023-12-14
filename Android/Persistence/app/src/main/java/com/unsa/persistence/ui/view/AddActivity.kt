package com.unsa.persistence.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.unsa.persistence.data.model.Applicant
import com.unsa.persistence.databinding.ActivityAddBinding
import com.unsa.persistence.ui.viewmodel.AddViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    private val addViewModel: AddViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }
    private fun initListeners() {
        binding.btnAdd.setOnClickListener {
            if (checkFields()) {
                Toast.makeText(this, "Applicant was added!", Toast.LENGTH_LONG).show()
                addViewModel.addApplicant(buildApplicant())
                cleanFields()
            } else {
                Toast.makeText(this, "Please complete all the fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun checkFields(): Boolean {
        val documentLoaded = checkIsNotEmpty(binding.etDocument)
        val nameLoaded = checkIsNotEmpty(binding.etName)
        val lastnameLoaded = checkIsNotEmpty(binding.etLastname)
        val birthdayLoaded = checkIsNotEmpty(binding.etBirthday)
        val schoolLoaded = checkIsNotEmpty(binding.etSchool)
        val careerLoaded = checkIsNotEmpty(binding.etCareer)
        return documentLoaded && nameLoaded && lastnameLoaded && birthdayLoaded && schoolLoaded && careerLoaded
    }
    private fun checkIsNotEmpty(field: EditText): Boolean {
        return field.text.isNotEmpty()
    }
    private fun getText(field: EditText): String {
        return field.text.toString()
    }
    private fun buildApplicant(): Applicant {
        val document = getText(binding.etDocument)
        val name = getText(binding.etName)
        val lastname = getText(binding.etLastname)
        val birthday = getText(binding.etBirthday)
        val school = getText(binding.etSchool)
        val career = getText(binding.etCareer)
        return Applicant(0, document, name, lastname, birthday, school, career)
    }
    private fun cleanFields() {
        cleanField(binding.etDocument)
        cleanField(binding.etName)
        cleanField(binding.etLastname)
        cleanField(binding.etBirthday)
        cleanField(binding.etSchool)
        cleanField(binding.etCareer)
    }
    private fun cleanField(field: EditText) {
        field.text = Editable.Factory.getInstance().newEditable("")
    }
}