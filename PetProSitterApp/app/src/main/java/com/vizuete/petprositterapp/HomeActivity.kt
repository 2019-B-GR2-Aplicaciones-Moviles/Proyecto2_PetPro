package com.vizuete.petprositterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun onClickButtonService(view: View) {
        val intentService = Intent(this, ServicesActivity::class.java)
        startActivity(intentService)
    }

    fun onClickButtonProfile(view: View) {
        val intentProfile = Intent(this, ProfileActivity::class.java)
        startActivity(intentProfile)
    }
}
