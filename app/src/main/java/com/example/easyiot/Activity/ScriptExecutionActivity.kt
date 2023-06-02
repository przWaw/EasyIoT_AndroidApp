package com.example.easyiot.Activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.easyiot.Fragments.AboutApp
import com.example.easyiot.Fragments.AboutMe
import com.example.easyiot.Fragments.ScriptDescription
import com.example.easyiot.Fragments.ScriptList
import com.example.easyiot.R
import com.example.easyiot.Service.RequestService
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.launch

class ScriptExecutionActivity : AppCompatActivity() {
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private val service = RequestService.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_script_execution)
        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawerLayout)
        navView = findViewById(R.id.navView)
        setSupportActionBar(toolbar)
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.aboutMe -> {
                    changeFragment(AboutMe())
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.aboutApp -> {
                    changeFragment(AboutApp())
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.scripts -> {
                    changeFragment(ScriptList())
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.scriptDescription -> {
                    changeFragment(ScriptDescription())
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
            }
            true
        }
        lifecycleScope.launch {
            findViewById<TextView>(R.id.hostname).text = service.getHostName()
        }
    }



    private fun changeFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentView, fragment)
            .commit()
    }

}