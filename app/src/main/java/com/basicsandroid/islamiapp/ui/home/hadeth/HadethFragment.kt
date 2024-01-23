package com.basicsandroid.islamiapp.ui.home.hadeth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.basicsandroid.islamiapp.databinding.FragmentHadethBinding

class HadethFragment : Fragment() {
    lateinit var viewBinding: FragmentHadethBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding= FragmentHadethBinding.inflate(inflater,container,false)
        return viewBinding.root
    }
}