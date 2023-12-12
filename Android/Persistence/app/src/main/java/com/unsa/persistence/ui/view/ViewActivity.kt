package com.unsa.persistence.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.unsa.persistence.data.adapters.ApplicantAdapter
import com.unsa.persistence.data.model.Applicant
import com.unsa.persistence.data.providers.ApplicantProvider
import com.unsa.persistence.databinding.ActivityViewBinding

class ViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewBinding
    private var applicants: MutableList<Applicant> = ApplicantProvider.applicants
    private lateinit var adapter: ApplicantAdapter
    private val manager = LinearLayoutManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }
    private fun initRecyclerView() {
        adapter = ApplicantAdapter (
            applicants = applicants,
            deleteListener = { position -> onApplicantDelete(position) }
        )
        binding.rvApplicants.layoutManager = manager
        binding.rvApplicants.adapter = adapter
        binding.etFilter.addTextChangedListener { textFilter ->
            val filteredApplicants = applicants.filter {
                    applicant -> applicant.document.contains(textFilter.toString())
            }
            adapter.updateApplicants(filteredApplicants)
        }
    }
    private fun onApplicantDelete(position: Int) {
        applicants.removeAt(position)
        adapter.notifyItemRemoved(position)
    }
}