package com.jeddy.pembelajaran

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jeddy.pembelajaran.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMateri.setOnClickListener {
            val intent = Intent(this, MateriActivity::class.java)
            startActivity(intent)
        }

        binding.btnGame.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

        binding.btnEvaluasi.setOnClickListener {
            val intent = Intent(this, EvaluasiActivity::class.java)
            startActivity(intent)
        }

        binding.btnStandarKompetensi.setOnClickListener {
            val intent = Intent(this, StandarKompetensiActivity::class.java)
            startActivity(intent)
        }

//        binding.btnKembali.setOnClickListener {
//            val intent = Intent(this, StartActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
//            startActivity(intent)
//            finish()
//        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        val intent = Intent(this, StartActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
        finish()
    }
}