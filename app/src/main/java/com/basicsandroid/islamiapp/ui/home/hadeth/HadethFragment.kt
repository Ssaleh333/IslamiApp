package com.basicsandroid.islamiapp.ui.home.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.green
import androidx.fragment.app.Fragment
import com.basicsandroid.islamiapp.Constants
import com.basicsandroid.islamiapp.activity_hadeth_details
import com.basicsandroid.islamiapp.databinding.FragmentHadethBinding
import com.basicsandroid.islamiapp.ui.home.adapter.HadethAdapter

class HadethFragment : Fragment() {
    lateinit var viewBinding: FragmentHadethBinding
    lateinit var adapter : HadethAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding= FragmentHadethBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter= HadethAdapter(null)
        viewBinding.hadithRecycler.adapter=adapter
        readHadithfile()
    }
    fun readHadithfile(){
        val fileName="ahadeeth.txt"
        val suraContentAsString=requireContext().assets.open(fileName).bufferedReader().use {
            it.readText()
        }
        val ahadthList=suraContentAsString.trim().split("#")
        val titleHadthList= mutableListOf<String>()
        val descriptionHadethList= mutableListOf<String>()
        for(hadith in ahadthList){
            val mutableHadethList=hadith.trim().split("\n")
            titleHadthList.add(mutableHadethList.get(0))
            descriptionHadethList.add(mutableHadethList.joinToString("\n"))
        }
        adapter.onHadethClickListener=object : HadethAdapter.OnHadethItemClickListener{
            override fun onHadethItemClick(hadethItemPostion: Int) {
             val intent=Intent(requireContext(),activity_hadeth_details::class.java)
                val item=descriptionHadethList.get(hadethItemPostion)
                intent.putExtra(Constants.EXTRA_HADETH_NAME,item)
                startActivity(intent)
            }

        }
        adapter.updateData(titleHadthList)
    }
}