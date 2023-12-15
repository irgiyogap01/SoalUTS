package com.ujian.soaluts.akun

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ujian.soaluts.databinding.ActivityRegistrasiBinding

class HalamanRegistrasi :AppCompatActivity() {
    private lateinit var binding: ActivityRegistrasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.regBtn.setOnClickListener {
            val nama = binding.regNama.getText().toString()
            val kelas = binding.regKelas.getText().toString()
            val prodi = binding.regUsername.getText().toString()
            val pass = binding.regPass.getText().toString()

            val intent = Intent(this,HalamanLogin::class.java)
            intent.putExtra("nama", nama)
            intent.putExtra("kelas", kelas)
            intent.putExtra("username", prodi)
            intent.putExtra("pass", pass)
            startActivity(intent)
        }
    }
}