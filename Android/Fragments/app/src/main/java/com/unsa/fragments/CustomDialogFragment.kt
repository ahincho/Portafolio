package com.unsa.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class CustomDialogFragment : DialogFragment() {
    private lateinit var btnCancel: Button
    private lateinit var btnSubmit: Button
    private lateinit var rgRatios: RadioGroup
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView: View = inflater.inflate(R.layout.fragment_custom_dialog, container, false)
        btnCancel = rootView.findViewById(R.id.cancelButton)
        btnSubmit = rootView.findViewById(R.id.submitButton)
        rgRatios = rootView.findViewById(R.id.rgRatios)
        btnCancel.setOnClickListener {
            dismiss()
        }
        btnSubmit.setOnClickListener {
            val selectedId = rgRatios.checkedRadioButtonId
            val radio = rootView.findViewById<RadioButton>(selectedId)
            val rating = radio.text.toString()
            Toast.makeText(context, "You rated: $rating", Toast.LENGTH_LONG).show()
            dismiss()
        }
        return rootView
    }
}