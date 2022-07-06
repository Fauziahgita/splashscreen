package com.hewan.namanamahewan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hewan.namanamahewan.databinding.ActivityLogin2Binding



private lateinit var binding:ActivityLogin2Binding
class Login_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLog.setOnClickListener {

            val dataLogin = ModelLogin(binding.textPusername.text.toString(), binding.textPpassword.text.toString())
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("data", dataLogin)
            startActivity(intent)

        }
    }
}