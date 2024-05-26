package com.example.jobapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jobapp.R
import com.example.jobapp.databinding.ViewholderCategoryBinding

class CategoryAdapter(private val items:List<String>,val clickListener: ClickListener): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    private var selectedPosition = -1
    private var lastSelectedPosition = -1
    private lateinit var context: Context
    inner class ViewHolder(val binding:ViewholderCategoryBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        context=parent.context
        val binding=ViewholderCategoryBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
       val item=items[position]
        holder.binding.catTxt.text=item
        holder.binding.root.setOnClickListener {
            lastSelectedPosition=selectedPosition
            selectedPosition=position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
            clickListener.onClick(position.toString())
        }
        if(selectedPosition==position){
            holder.binding.root.setBackgroundResource(R.drawable.blue_full_conrner)
            holder.binding.catTxt.setTextColor(context.getColor(R.color.white))
        }else{
            holder.binding.root.setBackgroundResource(R.drawable.white_bg_full_stroke)
            holder.binding.catTxt.setTextColor(context.getColor(R.color.black))
        }
    }

    override fun getItemCount(): Int =items.size
    interface ClickListener{
        fun onClick(position: String)
    }
}
