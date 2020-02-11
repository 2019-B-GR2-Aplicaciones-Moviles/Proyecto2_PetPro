package com.moviles.petproapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class VerifyActivity : AppCompatActivity() {

    private lateinit var correo: TextView
    private lateinit var email: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify)

        correo = findViewById(R.id.textViewEmail)
        email = intent.extras?.getString("email").toString()
        correo.text = email

    }

    fun onClickButtonFinRegistro(view: View) {
        val prIntent = Intent(this, LoginActivity::class.java)
        startActivity(prIntent)
    }
}
