package com.vizuete.petprositterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore

class HomeActivity : AppCompatActivity() {

    private var id: String = ""
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        db = FirebaseFirestore.getInstance()
        id = intent.getStringExtra("id")
    }

    fun onClickButtonService(view: View) {
        val intentService = Intent(this, ServicesActivity::class.java)
        startActivity(intentService)
    }

    fun onClickButtonProfile(view: View) {
        val prIntent = Intent(this, ProfileActivity::class.java)
        prIntent.putExtra("id", id)
        startActivity(prIntent)
    }
}
