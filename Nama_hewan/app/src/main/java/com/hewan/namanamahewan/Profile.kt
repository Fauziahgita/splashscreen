package com.hewan.namanamahewan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle ;
import android.view.LayoutInflater
import com.hewan.namanamahewan.databinding.ActivityMainBinding
import com.hewan.namanamahewan.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {
    private lateinit var  binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnback.setOnClickListener {
            val intent = Intent (this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}