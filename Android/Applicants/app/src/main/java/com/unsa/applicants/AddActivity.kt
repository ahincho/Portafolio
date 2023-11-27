package com.unsa.applicants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import com.unsa.applicants.databinding.ActivityAddBinding
import com.unsa.applicants.domain.Applicant
import com.unsa.applicants.providers.ApplicantProvider

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }
    private fun initListeners() {
        binding.btnApplicantAdd.setOnClickListener {
            if (checkFields()) {
                Toast.makeText(this, "Applicant was added!", Toast.LENGTH_LONG).show()
                ApplicantProvider.applicants.add(0, buildApplicant())
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
        return Applicant(document, name, lastname, birthday, school, career)
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