package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.exercise2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val thirdFragment = ThirdFragment()

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.imHome -> setCurrentFragment(firstFragment)
                R.id.imMessages -> setCurrentFragment(secondFragment)
                R.id.imProfile -> setCurrentFragment(thirdFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}