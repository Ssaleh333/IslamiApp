package com.basicsandroid.islamiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.basicsandroid.islamiapp.databinding.ActivityHadethDetailsBinding
import com.basicsandroid.islamiapp.ui.home.adapter.HadethAdapter
import com.basicsandroid.islamiapp.ui.home.adapter.VersesAdapter

class activity_hadeth_details : AppCompatActivity() {
    lateinit var binding:ActivityHadethDetailsBinding
    lateinit var adapter:VersesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val description=intent.getStringExtra(Constants.EXTRA_HADETH_NAME)
        val descriptionList=description?.split("\n")?.toMutableList()
        val title=descriptionList?.get(0)
        descriptionList?.removeAt(0)
        adapter=VersesAdapter(descriptionList)
        binding.rvHadethDetails.adapter=adapter
        binding.tvToolbarTittle.text=title
        binding.icBack.setOnClickListener{
            finish()
        }
    }
}