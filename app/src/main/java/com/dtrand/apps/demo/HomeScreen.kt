package com.dtrand.apps.demo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar


class HomeScreen :  AppCompatActivity()  {


   private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.itemIconTintList = null

        intiActions()


        bottomNavigationView.setOnItemSelectedListener { item ->
            // Change the size for the selected item
            val fragment : Fragment = when(item.itemId) {
                R.id.nav_home_btn -> HomeFragment()
                R.id.nav_myQR_btn -> MyQrFragment()
                else -> DemoFragment(item.title.toString())
            }

            val icon = item.icon
            // Resize the icon
            icon?.setBounds(0, 0, 100, 100)

            // Setting up fragments
            fragment.let {
                val fragmentManager: FragmentManager = supportFragmentManager
                fragmentManager.beginTransaction().replace(R.id.fragmentContainer, it, "TY" ).commit()
            }


            val selectedItemId = item.itemId
            val menu = bottomNavigationView.menu
            for (i in 0 until menu.size()) {
                val menuItem = menu.getItem(i)
                val selected = menuItem.itemId == selectedItemId
            }
            true
        }
    }

    private fun intiActions() {

        findViewById<View>(R.id.locationTxt).setOnClickListener {
            showSnackbar(window.decorView, "Change Location action is here!")
        }
        findViewById<View>(R.id.notificationBtn).setOnClickListener {
            showSnackbar(window.decorView, "Notifications  is here!")
        }
        findViewById<View>(R.id.searchBtn).setOnClickListener {
            showSnackbar(window.decorView, "Notifications  is here!")
        }

    }

    private fun showSnackbar(decorView: View, string: String) {
        Snackbar.make(decorView, string, Snackbar.LENGTH_SHORT).show()
    }

}