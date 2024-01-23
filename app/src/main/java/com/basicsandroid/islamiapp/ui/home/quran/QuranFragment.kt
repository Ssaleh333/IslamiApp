package com.basicsandroid.islamiapp.ui.home.quran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.basicsandroid.islamiapp.databinding.FragmentQuranBinding
import com.basicsandroid.islamiapp.ui.home.adapter.SuraNameAdapter
import com.basicsandroid.islamiapp.ui.home.model.suraNameIndex
import com.basicsandroid.islamiapp.ui.home.model.suraNameList

class QuranFragment :Fragment() {
    lateinit var vievBinding:FragmentQuranBinding
    lateinit var  adapter:SuraNameAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vievBinding=FragmentQuranBinding.inflate(inflater,container,false)
        return vievBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val suranameIndexList= suraNameList.mapIndexed{index, suraName -> suraNameIndex(suraName,index+1)  }
        adapter=SuraNameAdapter(suranameIndexList)
        vievBinding.chapterRecycler.adapter=adapter
    }


}