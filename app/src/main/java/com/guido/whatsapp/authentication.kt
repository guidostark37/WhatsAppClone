package com.guido.whatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.guido.whatsapp.databinding.ActivityAuthenticationBinding

class authentication : AppCompatActivity() {
    lateinit var binding: ActivityAuthenticationBinding
    private val   titulo = arrayListOf("Login","Sign_up")
    private lateinit var  viewPager: ViewPager2
    private lateinit var  tabLayout: TabLayout
    private lateinit var  viewPagerAdapter: authenticationPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewPager = binding.viewpagerauthentication
        tabLayout = binding.tblautentication
        viewPagerAdapter = authenticationPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager){
                tab,position ->
                tab.text = titulo[position]

        }.attach()

    }
    class authenticationPagerAdapter(fragmentActivity:FragmentActivity):FragmentStateAdapter(fragmentActivity)
    {
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
           return when(position){
               0-> Login()
               1-> Sign_up()
               else -> Login()
           }
        }


    }

}

