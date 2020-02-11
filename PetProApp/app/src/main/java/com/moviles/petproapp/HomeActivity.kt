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

    private var id: String = ""
    private lateinit var db: FirebaseFirestore
    private lateinit var correo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        db = FirebaseFirestore.getInstance()
        id = intent.getStringExtra("id")

        consultarMascotas(id)
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
        prIntent.putExtra("id", id)
        startActivity(prIntent)
    }

    fun onClickButtonRegistryCard(view: View) {
        val prIntent = Intent(this, pagoTarjetaActivity::class.java)
        prIntent.putExtra("id", id)
        startActivity(prIntent)
    }

    fun onClickButtonRegistryPet(view: View) {
        val prIntent = Intent(this, RegistryPetActivity::class.java)
        prIntent.putExtra("id", id)
        startActivity(prIntent)
    }

    private fun consultarMascotas(idUser: String) {
        db.collection("usuarios").document(idUser).collection("mascotas")
            .get()
            .addOnSuccessListener { documents ->
                if (documents.isEmpty) {
                    val intentRegistryPet = Intent(this, RegistryPetActivity::class.java)
                    intentRegistryPet.putExtra("id", idUser)
                    startActivity(intentRegistryPet)
                }
            }
    }
}

