package com.ujian.soaluts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import com.ujian.soaluts.akun.HalamanLogin
import com.ujian.soaluts.databinding.ActivityMainBinding
import com.ujian.soaluts.fragments.HalamanKalkulator
import com.ujian.soaluts.fragments.HalamanUtama
import com.ujian.soaluts.fragments.WisataFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding

    lateinit var home: HalamanUtama
    lateinit var kalkulator: HalamanKalkulator
    lateinit var wisata: WisataFragment

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var namaBaru: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.setNavigationItemSelectedListener(this)

        val nama: String = this.intent.getStringExtra("nama").toString()
        val kelas: String = this.intent.getStringExtra("kelas").toString()
        namaBaru = findViewById(R.id.txUtama)
        namaBaru.text = nama + " / " + kelas
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home -> {
                home = HalamanUtama()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, home)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.kalkulator -> {
                kalkulator = HalamanKalkulator()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, kalkulator)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.wisata-> {
                wisata = WisataFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, wisata)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.Logout-> {
                val intent = Intent(this, HalamanLogin::class.java)
                startActivity(intent)
                Toast.makeText(this, "Anda sudah logout", Toast.LENGTH_SHORT).show()
            }
        }
        binding.drawerLayout.closeDrawers()
        return true
    }
    fun clkKalkulator(view: View?) {
        kalkulator = HalamanKalkulator()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, kalkulator)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }
    fun clkWisata(view: View?) {
        wisata = WisataFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, wisata)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}