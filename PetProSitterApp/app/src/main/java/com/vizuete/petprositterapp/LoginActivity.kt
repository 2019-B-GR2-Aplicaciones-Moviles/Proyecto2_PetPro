package com.vizuete.petprositterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onClickButtonRegistro(view: View) {
        val prIntent = Intent(this, RegistryActivity::class.java)
        startActivity(prIntent)
    }
    fun onClickLogin(view: View) {}
}
