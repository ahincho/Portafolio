package com.unsa.applicants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.unsa.applicants.adapters.ApplicantAdapter
import com.unsa.applicants.databinding.ActivityListBinding
import com.unsa.applicants.domain.Applicant
import com.unsa.applicants.providers.ApplicantProvider

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private var applicants: MutableList<Applicant> = ApplicantProvider.applicants
    private lateinit var adapter: ApplicantAdapter
    private val manager = LinearLayoutManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
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
    }
    private fun onApplicantDelete(position: Int) {
        applicants.removeAt(position)
        adapter.notifyItemRemoved(position)
    }
}