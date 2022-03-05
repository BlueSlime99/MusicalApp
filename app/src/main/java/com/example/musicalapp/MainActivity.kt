package com.example.musicalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.musicalapp.fragments.ArtisteFragment
import com.example.musicalapp.fragments.ClassementFragment
import com.example.musicalapp.fragments.FavorisFragment
import com.example.musicalapp.fragments.RechercheFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //importer la bottom navigation
        val navigationBottom = findViewById<BottomNavigationView>(R.id.product_details_bottom_nav)
        navigationBottom.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.classement_page -> {
                    loadFragment(ClassementFragment(this))
                    return@setOnNavigationItemSelectedListener true

                }
                R.id.recherche_page -> {
                    loadFragment(RechercheFragment(this))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.favoris_page -> {
                    loadFragment(FavorisFragment(this))
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
    }
        private fun loadFragment(fragment:Fragment ){
            //injecter le fragment dans la boite fragment (fragment_title_container) -> dans activity_main

            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_title_container,fragment)
            transaction.addToBackStack(null) // pas de retour du composant
            transaction.commit() //envoyer les changements

        }

}
