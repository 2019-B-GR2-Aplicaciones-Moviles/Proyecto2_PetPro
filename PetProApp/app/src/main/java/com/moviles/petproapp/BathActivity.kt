package com.moviles.petproapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BathActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bath)


        val button: Button = findViewById(R.id.buttonAceptarBaño)
        button.setOnClickListener {
            var prIntent: Intent = Intent(this, metodoPagoActivity::class.java)
            startActivity(prIntent)
        }
    }
}
