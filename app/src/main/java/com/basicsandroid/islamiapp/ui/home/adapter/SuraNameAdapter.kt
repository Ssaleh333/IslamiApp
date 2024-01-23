package com.basicsandroid.islamiapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.basicsandroid.islamiapp.databinding.ItemSuraTitleBinding
import com.basicsandroid.islamiapp.ui.home.model.suraNameIndex

class SuraNameAdapter(var suraNameList :List<suraNameIndex>) :RecyclerView.Adapter<SuraNameAdapter.myViewHolder>() {
    class myViewHolder(var itemBinding:ItemSuraTitleBinding):RecyclerView.ViewHolder(itemBinding.root){
         fun bind(item:suraNameIndex){
             itemBinding.suraName.text="${item.name}"
             itemBinding.suraIndex.text="${item.index}"
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
       val inflater=LayoutInflater.from(parent.context)
      val binding=ItemSuraTitleBinding.inflate(inflater,parent,false)
      return myViewHolder(binding)
    }

    override fun getItemCount(): Int =suraNameList?.size?:0

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
       val item= suraNameList?.get(position) ?: return
        holder.bind(item)
    }
}