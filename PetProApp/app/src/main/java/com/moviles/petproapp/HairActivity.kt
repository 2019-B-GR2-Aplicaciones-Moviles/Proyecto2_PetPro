package com.moviles.petproapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HairActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hair)
    }

    fun onClickButtonPago2(view: View) {
        val prIntent = Intent(this, metodoPagoActivity::class.java)
        startActivity(prIntent)
    }
}
