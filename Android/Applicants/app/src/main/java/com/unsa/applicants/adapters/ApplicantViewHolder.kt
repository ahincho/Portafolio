package com.unsa.applicants.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.unsa.applicants.databinding.ItemApplicantBinding
import com.unsa.applicants.domain.Applicant

class ApplicantViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemApplicantBinding.bind(view)
    fun renderApplicant (
        applicant: Applicant,
        deleteListener: (Int) -> Unit
    ) {
        "${applicant.lastname} ${applicant.name}".also { binding.tvApplicantFullName.text = it }
        binding.tvApplicantBirthday.text = applicant.birthday
        binding.tvApplicantSchool.text = applicant.school
        binding.tvApplicantCareer.text = applicant.career
        binding.tvApplicantDocument.text = applicant.document
        binding.btnApplicantDelete.setOnClickListener { deleteListener(adapterPosition) }
    }
}