package edu.udb.desafio2dsmnancy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnsignup: Button
    private lateinit var btnlogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnsignup = findViewById(R.id.button)
        btnlogin = findViewById(R.id.button2)

        btnsignup.setOnClickListener {
            val intent = Intent(this, signupActivity::class.java)
            startActivity(intent)
        }

        btnlogin.setOnClickListener{
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }

    }
}