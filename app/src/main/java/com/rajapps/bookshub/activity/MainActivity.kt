package com.rajapps.bookshub.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.rajapps.bookshub.R
import com.rajapps.bookshub.fragment.AboutAppFragment
import com.rajapps.bookshub.fragment.DashboardFragment
import com.rajapps.bookshub.fragment.FavouritesFragment
import com.rajapps.bookshub.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout : DrawerLayout
    lateinit var coordinatorLayout : CoordinatorLayout
    lateinit var toolbar : Toolbar
    lateinit var framelayout : FrameLayout
    lateinit var navigationview : NavigationView

    var previousMenuItem : MenuItem? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        framelayout = findViewById(R.id.framelayout)
        navigationview = findViewById(R.id.navigationview)

        setUpToolbar()
        openDashboard()

        val actionBarDrawerToggle = ActionBarDrawerToggle(this,drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        openDashboard()

        navigationview.setNavigationItemSelectedListener {

            if (previousMenuItem != null){
                previousMenuItem?.isChecked =false
            }

            it.isCheckable = true
            it.isChecked = true
            previousMenuItem = it

            when(it.itemId){

                R.id.dashboard -> {

                    openDashboard()
                    drawerLayout.closeDrawers()

                }

                R.id.favourites ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayout, FavouritesFragment())
                        .commit()

                    supportActionBar?.title="Favourites"
                    drawerLayout.closeDrawers()
                }

                R.id.profile ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayout, ProfileFragment())
                        .commit()

                    supportActionBar?.title="Profile"
                    drawerLayout.closeDrawers()
                }

                R.id.about ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayout, AboutAppFragment())
                        .commit()

                    supportActionBar?.title="About App"
                    drawerLayout.closeDrawers()
                }

            }

            return@setNavigationItemSelectedListener true
        }


    } // below are functions

    fun setUpToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title="BooksHub"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return super.onOptionsItemSelected(item)
    }

    fun openDashboard(){

        val fragment = DashboardFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.framelayout, fragment)
        transaction.commit()

        supportActionBar?.title="Dashboard"
        navigationview.setCheckedItem(R.id.dashboard)
    }

    override fun onBackPressed() {

        val frag = supportFragmentManager.findFragmentById(R.id.framelayout)

        when(frag){
            !is DashboardFragment -> openDashboard()

            else ->  super.onBackPressed()

        }

    }


}




















