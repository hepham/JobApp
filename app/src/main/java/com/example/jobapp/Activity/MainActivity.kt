package com.example.jobapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jobapp.Adapter.CategoryAdapter
import com.example.jobapp.Model.JobModel
import com.example.jobapp.R
import com.example.jobapp.ViewModel.JobAdapter
import com.example.jobapp.ViewModel.MainViewModel
import com.example.jobapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        initLocation()
        initRecyclerViewCat()
        initRecyclerViewJobSuggest()
        initRecyclerViewRecent("0")
    }

    private fun initRecyclerViewRecent(cat:String) {
        var data:List<JobModel>
        if(cat=="0"){
            data=mainViewModel.loadData().sortedBy{it.category}
        }else{
            data=mainViewModel.loadData().filter{it.category==cat}
        }
        binding.viewRecent.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.viewRecent.adapter= JobAdapter(data)

        binding.progressBarSuggest.visibility = View.GONE
    }


    private fun initLocation() {
        val adapter = ArrayAdapter(this, R.layout.spinner_item, mainViewModel.loadLocation())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.locationSpin.adapter = adapter
    }

    private fun initRecyclerViewCat() {
        binding.progressBarCategory.visibility = View.VISIBLE
        binding.viewCategory.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.viewCategory.adapter= CategoryAdapter(mainViewModel.loadLCategory(),object :CategoryAdapter.ClickListener{
            override fun onClick(Category: String){
                initRecyclerViewRecent("0")
            }

        })
        binding.progressBarCategory.visibility = View.GONE

    }
    private fun initRecyclerViewJobSuggest() {
        binding.progressBarSuggest.visibility = View.VISIBLE
        binding.viewSuggested.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.viewSuggested.adapter= JobAdapter(mainViewModel.loadData())

        binding.progressBarSuggest.visibility = View.GONE
    }
}