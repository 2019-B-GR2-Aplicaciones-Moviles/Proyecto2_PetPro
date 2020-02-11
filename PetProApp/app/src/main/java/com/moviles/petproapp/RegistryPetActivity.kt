package com.moviles.petproapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class RegistryPetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registry_pet)
    }

    fun onClickButtonFinRegistroMascota(view: View) {
        val prIntent = Intent(this, LoginActivity::class.java)
        startActivity(prIntent)
    }
}
