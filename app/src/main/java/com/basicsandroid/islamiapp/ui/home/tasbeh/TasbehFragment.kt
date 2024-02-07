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
   var counter =0
   lateinit var azkarList: MutableList<String>
    lateinit var binding: FragmentTasbehBinding
    var currentZekrIndex=0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentTasbehBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            azkarList=resources.getStringArray(R.array.azkarList).toMutableList()
            binding.tvTasbeh.text=azkarList[currentZekrIndex]

            onSebhaClick()




    }

    private fun onSebhaClick() {
        binding.bodySebha.setOnClickListener {
            binding.bodySebha.rotation +=(360/33).toFloat()

            if(counter<33){
                counter ++
            }else {
                counter =0
                currentZekrIndex=if(currentZekrIndex <azkarList.size -1 ) ++currentZekrIndex else 0
                binding.tvTasbeh.text=azkarList[currentZekrIndex]
            }
            binding.numOfTasbeh.text=counter.toString()
            }
        }
    }







