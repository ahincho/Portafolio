package com.unsa.persistence.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.unsa.persistence.data.adapters.ApplicantAdapter
import com.unsa.persistence.data.model.Applicant
import com.unsa.persistence.databinding.ActivityListBinding
import com.unsa.persistence.ui.viewmodel.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private val listViewModel: ListViewModel by viewModels()
    private lateinit var applicants: MutableList<Applicant>
    private lateinit var adapter: ApplicantAdapter
    private val manager = LinearLayoutManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }
    private fun initRecyclerView() {
        applicants = listViewModel.getAllApplicants().toMutableList()
        adapter = ApplicantAdapter (
            applicants = applicants,
            deleteListener = { position -> onApplicantDelete(position) }
        )
        binding.rvApplicants.layoutManager = manager
        binding.rvApplicants.adapter = adapter
        binding.etFilter.addTextChangedListener { textFilter ->
            val filteredApplicants = listViewModel.getAllApplicants().filter {
                    applicant -> applicant.document.contains(textFilter.toString())
            }
            adapter.updateApplicants(filteredApplicants)
        }
    }
    private fun onApplicantDelete(position: Int) {
        listViewModel.deleteApplicant(listViewModel.getAllApplicants()[position].id)
        applicants.removeAt(position)
        adapter.notifyItemRemoved(position)
    }
}