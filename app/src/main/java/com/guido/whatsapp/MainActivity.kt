package com.guido.whatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.guido.whatsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var toolbar: Toolbar
    private lateinit var appPagerAdapter: appPagerAdapter
    private val titulos = arrayListOf("chats", "estados", "llamadas")
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewPager2 = binding.viewpager2Main
        tabLayout = binding.tabLayoutMain
        toolbar = binding.toolbarMain
        toolbar.title = "WHATSAPP"
        setSupportActionBar(toolbar)
        appPagerAdapter = appPagerAdapter(this)
        viewPager2.adapter = appPagerAdapter
        TabLayoutMediator(tabLayout,viewPager2){
            tab,position->
            tab.text= titulos[position]
        }.attach()
    }


}
class appPagerAdapter(fragmentActivity:FragmentActivity):FragmentStateAdapter(fragmentActivity)
{
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> chats()
            2-> estados()
            3-> llamadas()
            else->chats()
        }
    }

}

