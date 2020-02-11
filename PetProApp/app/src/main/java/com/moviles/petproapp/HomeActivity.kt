package com.moviles.petproapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.firestore.FirebaseFirestore

class HomeActivity : AppCompatActivity() {

    private lateinit var id: String
    private lateinit var db: FirebaseFirestore
    private lateinit var correo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        db = FirebaseFirestore.getInstance()
        correo = intent.getStringExtra("user")

        db.collection("usuarios").whereEqualTo("email", correo)
            .get()
            .addOnSuccessListener { documentReference ->
                for (document in documentReference) {
                    if(document.exists()){
                        id = document.id
                    }
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
            }

        db.collection("usuarios").document(id).collection("mascotas")
            .get()
            .addOnSuccessListener { documents ->
                if(documents.isEmpty){
                    startActivity(Intent(this, RegistryPetActivity::class.java))
                }
            }
    }


    //Conjunto de funciones las cuales responden a los principales servicios

    fun onClickButtonPaseo(view: View) {
        val prIntent = Intent(this, WalkActivity::class.java)
        startActivity(prIntent)
    }


    fun onClickButtonBaño(view: View) {
        val prIntent = Intent(this, BathActivity::class.java)
        startActivity(prIntent)
    }

    fun onClickButtonHospedaje(view: View) {
        val prIntent = Intent(this, LodgingActivity::class.java)
        startActivity(prIntent)
    }

    fun onClickButtonPeluqueria(view: View) {
        val prIntent = Intent(this, HairActivity::class.java)
        startActivity(prIntent)
    }

    fun onClickButtonPerfilUser(view: View) {
        val prIntent = Intent(this, UserDataActivity::class.java)
        startActivity(prIntent)
    }

}

