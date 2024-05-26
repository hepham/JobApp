package com.example.jobapp.Activity

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bumptech.glide.Glide
import com.example.jobapp.Fragment.AboutFragment
import com.example.jobapp.Fragment.CompanyFragment
import com.example.jobapp.Fragment.SoldFragment
import com.example.jobapp.Model.JobModel
import com.example.jobapp.databinding.ActivityDetailJobBinding

class DetailJobActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailJobBinding
    private lateinit var item: JobModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailJobBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        getBundle()
        setupViewPager()
    }

    private fun getBundle() {
        item=intent.getParcelableExtra("object")!!
        binding.titleTxt.text=item.title
        binding.companyTxt.text=item.company
        binding.locationTxt.text=item.location
        binding.workingModelDetailTxt.text=item.model
        binding.salaryDetailTxt.text=item.salary
        binding.jobTypeDetailTxt.text=item.time
        binding.levelTxt.text=item.level
        val drawableResourceId=resources.getIdentifier(item.picUrl,"drawable",packageName)
        Glide.with(this).load(drawableResourceId).into(binding.picDetail)
        binding.backBtn.setOnClickListener {
            finish()
        }
    }
    private fun setupViewPager(){
        val adapter=ViewPagerAdapter(supportFragmentManager)
        val tab1= AboutFragment()
        val tab2=CompanyFragment()
        val tab3=SoldFragment()
        val bundle1=Bundle()
        bundle1.putParcelable("object",item)
        bundle1.putString("about",item.about)
        bundle1.putString("description",item.description)
        tab1.arguments=bundle1
        tab2.arguments=Bundle()
        tab3.arguments=Bundle()
        adapter.addFrag(tab1,"About")
        adapter.addFrag(tab2,"Company")
        adapter.addFrag(tab3,"Review")
        binding.viewPager.adapter=adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
    private class ViewPagerAdapter(fm: FragmentManager):
        FragmentPagerAdapter(fm){
            private val fragmentList= arrayListOf<Fragment>()
            private val fragmentTitleList= arrayListOf<String>()
        override fun getCount(): Int =fragmentList.size
        override fun getItem(position: Int): Fragment =fragmentList[position]
        fun addFrag(fragment: Fragment,title:String){
            fragmentList.add(fragment)
            fragmentTitleList.add(title)
        }
        override fun getPageTitle(position: Int): CharSequence =fragmentTitleList[position]

    }
}