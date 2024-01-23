package com.basicsandroid.islamiapp.ui.home.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.basicsandroid.islamiapp.R
import com.basicsandroid.islamiapp.databinding.FragmentTasbehBinding
import com.basicsandroid.islamiapp.ui.home.TasbehClickListener

class TasbehFragment :Fragment() {
    private val tasbehOptions = listOf("سبحان الله", "الله أكبر", "لا إله إلا الله", "الحمدلله")
    private var tasbehIndex = 0
    private var tasbehCount = 0
    private var currentTasbehText = tasbehOptions[0]

    lateinit var viewBinding: FragmentTasbehBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding=FragmentTasbehBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.tvTasbeh.setOnClickListener{
            updatedText()
            updateTasbehCount()

        }


    }

    private fun updatedText(): String {

        currentTasbehText = tasbehOptions[tasbehCount % tasbehOptions.size]
        return currentTasbehText
    }

    private fun updateTasbehCount() {
        tasbehCount++
        viewBinding.numOfTasbeh.text=tasbehCount.toString()
        if(tasbehCount==33){
            viewBinding.tvTasbeh.text = updatedText()
            tasbehCount=0
        }

    }



}
