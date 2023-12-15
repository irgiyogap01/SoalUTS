package com.ujian.soaluts.akun

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.ujian.soaluts.MainActivity
import com.ujian.soaluts.R
import com.ujian.soaluts.databinding.ActivityLoginBinding
import com.ujian.soaluts.fragments.HalamanUtama

class HalamanLogin: AppCompatActivity(){
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logRegis.setOnClickListener {
            val intent = Intent(this,HalamanRegistrasi::class.java)
            startActivity(intent)
        }
        binding.logBtn.setOnClickListener {
            if(intent.hasExtra("nama")){
                val nama: String = this.intent.getStringExtra("nama").toString()
                val kelas: String = this.intent.getStringExtra("kelas").toString()
                val username: String = this.intent.getStringExtra("username").toString()
                val pass: String = this.intent.getStringExtra("pass").toString()
                login(nama, pass, username, kelas)
            }
            else{
                Toast.makeText(this,"akun belum ada", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun login(namaBaru:String, passBaru:String, usernameBaru: String, kelasBaru: String){

        val username = binding.logUsername.getText().toString()
        val pass = binding.logPass.getText().toString()

        if (username == usernameBaru) {
            if (passBaru == pass) {
                val intent = Intent(this,MainActivity::class.java)
                intent.putExtra("nama", namaBaru)
                intent.putExtra("kelas", kelasBaru)

                startActivity(intent)
                Toast.makeText(this, "anda berhasil login", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"password salah", Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Toast.makeText(this,"nama salah", Toast.LENGTH_SHORT).show()
        }
    }
}