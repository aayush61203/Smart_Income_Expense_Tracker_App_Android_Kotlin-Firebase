package com.myapp.catatuang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import com.myapp.catatuang.databinding.ActivityMainBinding
import com.myapp.catatuang.fragments.AccountFragment
import com.myapp.catatuang.fragments.TransactionFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //---Bottom Nabvigation Method 2 :
        val transactionFragment = TransactionFragment()
        val accountFragment = AccountFragment()
        binding.chipAppBar.setItemSelected(R.id.ic_transaction,true)
        makeCurrentFragment(transactionFragment)
        binding.chipAppBar.setOnItemSelectedListener { //when the bottom nav clicked
            when (it){
                R.id.ic_transaction -> makeCurrentFragment(transactionFragment)
                R.id.ic_account -> makeCurrentFragment(accountFragment)
            }
            val b = true
            b
        }
        //------

    }


    private fun makeCurrentFragment(fragment: Fragment) { //method 2
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }


    fun floating_button(view: View){
        val intent = Intent(this, InsertionActivity::class.java)
        startActivity(intent)
    }
}