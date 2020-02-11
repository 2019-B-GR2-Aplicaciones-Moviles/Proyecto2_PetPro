package com.moviles.petproapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LodgingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lodging)
    }

    fun onClickButtonPago3(view: View) {
        val prIntent = Intent(this, metodoPagoActivity::class.java)
        startActivity(prIntent)
    }
}
