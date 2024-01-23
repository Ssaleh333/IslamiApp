package com.basicsandroid.islamiapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.basicsandroid.islamiapp.R
import com.basicsandroid.islamiapp.databinding.ActivityMainBinding
import com.basicsandroid.islamiapp.ui.home.hadeth.HadethFragment
import com.basicsandroid.islamiapp.ui.home.quran.QuranFragment
import com.basicsandroid.islamiapp.ui.home.radio.RadioFragment
import com.basicsandroid.islamiapp.ui.home.tasbeh.TasbehFragment
import com.google.android.material.navigation.NavigationBarItemView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
       initViews()
    }

    private fun initViews() {
        viewBinding.content.bottomNav.
        setOnItemSelectedListener { item ->
          var fragment:Fragment=  when (item.itemId) {
                R.id.naviation_quran -> {
                      QuranFragment()
                }

                R.id.naviation_hadith -> {
                      HadethFragment()
                }

                R.id.naviation_tasbeh -> {
                        TasbehFragment()
                }

                R.id.naviation_radio -> {
                      RadioFragment()
                }
              else->{
                  QuranFragment()
              }
            }
            pushFragment(fragment)
            true
        }
        viewBinding.content.bottomNav.selectedItemId=R.id.naviation_quran
    }

    private fun pushFragment(fragment: Fragment){

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()
    }
}
interface TasbehClickListener {
    fun onTasbehClicked(count: Int, text: String)
}