package com.example.socialproblemandroid.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.socialproblemandroid.R
import com.example.socialproblemandroid.databinding.ActivityMainBinding
import com.example.socialproblemandroid.util.BindingActivity

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var context : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        initView()
        setBottomNav()
    }

    private fun initView(){
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_main)
        if (currentFragment == null) {
            changeFragment(HomeFragment())
        }
    }


    private fun setBottomNav() {
        binding.bnvMain.run {
            setOnItemSelectedListener {
                changeFragment(
                    when (it.itemId) {
                        R.id.menu_home -> {
                            HomeFragment()
                        }
                        R.id.menu_chat -> {
                            ChatFragment()
                        }
                        else -> {
                            MyPageFragment()
                        }
                    }
                )
                true
            }
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_main, fragment)
            .commit()
    }
}