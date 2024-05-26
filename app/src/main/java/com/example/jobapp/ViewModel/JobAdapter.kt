package com.example.jobapp.ViewModel

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jobapp.Activity.DetailJobActivity
import com.example.jobapp.Model.JobModel
import com.example.jobapp.databinding.ViewholderJobBinding

class JobAdapter(private val items:List<JobModel>):RecyclerView.Adapter<JobAdapter.ViewHolder>() {
    private lateinit var context: Context
    class ViewHolder(val binding: ViewholderJobBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context=parent.context
        val binding=ViewholderJobBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int =items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=items[position]
        holder.binding.titleTxt.text=item.title
        holder.binding.companyTxt.text=item.company
        holder.binding.locationTxt.text=item.location
        holder.binding.timeTxt.text=item.time
        holder.binding.salaryTxt.text=item.salary
        holder.binding.levelTxt.text=item.level
        holder.binding.modelTxt.text=item.model
        val drawableResourceId=context.resources.getIdentifier(item.picUrl,"drawable",context.packageName)
        Glide.with(holder.itemView.context).load(drawableResourceId).into(holder.binding.picture)
        holder.itemView.setOnClickListener {
            val intent= Intent(context,DetailJobActivity::class.java)
            intent.putExtra("object",item)
            holder.itemView.context.startActivity(intent)
        }
    }
}