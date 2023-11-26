package com.unsa.applicants.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.unsa.applicants.R
import com.unsa.applicants.domain.Applicant

class ApplicantAdapter (
    private var applicants: List<Applicant>,
    private val deleteListener: (Int) -> Unit
) : RecyclerView.Adapter<ApplicantViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplicantViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ApplicantViewHolder(layoutInflater.inflate(R.layout.item_applicant, parent, false))
    }
    override fun getItemCount(): Int {
        return applicants.size
    }
    override fun onBindViewHolder(holder: ApplicantViewHolder, position: Int) {
        val applicant = applicants[position]
        holder.renderApplicant(applicant, deleteListener)
    }
    fun updateApplicants(applicantsList: List<Applicant>) {
        this.applicants = applicantsList
        notifyDataSetChanged()
    }
}