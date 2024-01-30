package com.basicsandroid.islamiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.basicsandroid.islamiapp.databinding.ActivitySuraDetailsBinding
import com.basicsandroid.islamiapp.ui.home.adapter.VersesAdapter

class suraDetailsActivity : AppCompatActivity() {
    lateinit var binding:ActivitySuraDetailsBinding
    lateinit var adapter: VersesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.icBack.setOnClickListener{
            finish()
        }
        val title=intent.getStringExtra(Constants.EXTRA_SURA_NAME)
        val index=intent.getIntExtra(Constants.EXTRA_SURA_INDEX,-1)
        binding.tvToolbarTittle.text=title
        adapter=VersesAdapter(null)
        binding.rvSuraDetails.adapter=adapter
        readFromAssets(index)
    }

    fun readFromAssets(index:Int){
        val fileName="$index.txt"
        val suraContentAsString=application.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
        val verses=suraContentAsString.trim().split("\n")
        adapter.updateData(verses)
    }
}