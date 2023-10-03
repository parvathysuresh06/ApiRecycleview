package com.example.apirecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apirecycleview.viewmodel.ProductViewModel
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var viewmodel: ProductViewModel
    private lateinit var adapter: AdapterClass
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        drawerLayout = findViewById(R.id.drawerLayout)
//        navigationView = findViewById(R.id.navView)
//        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open_nav, R.string.close_nav)
//        drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()
//
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        navigationView.setNavigationItemSelectedListener { menuItem ->
//
//            when (menuItem.itemId) {
//                R.id.nav_home -> {
//                    // Handle item 1 click
//                    // Add your code here
//                }
//                R.id.nav_about -> {
//                    // Handle item 2 click
//                    // Add your code here
//                }
//                R.id.nav_about -> {
//                    // Handle item 2 click
//                    // Add your code here
//                }
//        }
//            drawerLayout.closeDrawer(GravityCompat.START)
//            true
//        }


        val recyclerview = findViewById<RecyclerView>(R.id.recycleView)
        viewmodel= ViewModelProvider(this)[ProductViewModel::class.java]
        viewmodel.apply {
            getPro()
        }
        recyclerview.layoutManager = LinearLayoutManager(this)
        viewmodel.productDataList.observe(this) { result ->
            val adapter = AdapterClass(result ?: emptyList())
            recyclerview.adapter = adapter
            adapter.notifyDataSetChanged()
        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}



