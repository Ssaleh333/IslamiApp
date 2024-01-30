package com.basicsandroid.islamiapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.basicsandroid.islamiapp.databinding.ItemHadithBinding
import com.basicsandroid.islamiapp.databinding.ItemVerseBinding

class HadethAdapter(var hadethList: List<String>?)  :Adapter<HadethAdapter.HadethViewHolder>(){
    var onHadethClickListener:OnHadethItemClickListener?=null
    class HadethViewHolder(val binding:ItemHadithBinding):ViewHolder(binding.root){
       fun bind(verse :String){
           binding.itemVerse.text=verse
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethViewHolder {
        val inflater=LayoutInflater.from(parent.context)
      val binding =ItemHadithBinding.inflate(inflater,parent,false)
        return HadethViewHolder(binding)
    }

    override fun getItemCount(): Int =hadethList?.size ?:0

    override fun onBindViewHolder(holder: HadethViewHolder, position: Int) {
       val item =hadethList?.get(position)?:return
        holder.binding.root.setOnClickListener{
            onHadethClickListener?.onHadethItemClick(position)
        }
        holder.bind(item)
    }
    interface OnHadethItemClickListener{
        fun onHadethItemClick(hadethItemPostion: Int)
    }
    fun updateData(verses:List<String>){
     this.hadethList=verses
        notifyDataSetChanged()
    }
}