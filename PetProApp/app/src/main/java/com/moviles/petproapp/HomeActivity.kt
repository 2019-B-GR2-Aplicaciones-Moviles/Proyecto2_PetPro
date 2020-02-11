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


/*    private lateinit var name: String
    private lateinit var nombreUsuario: TextView
    private lateinit var apellidoUsuario: TextView
    private lateinit var correoUsuario: TextView
    private lateinit var telefonoUsuario: TextView
    private lateinit var nombre: String
    private lateinit var apellido: String
    private lateinit var emailCon: String
    private lateinit var telefono: String
    private lateinit var db: FirebaseFirestore
    private lateinit var correo: String*/



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

       /*db= FirebaseFirestore.getInstance()
        name = intent.getStringExtra("correo")

        nombreUsuario = findViewById(R.id.editTextNombreConsulta)
        apellidoUsuario = findViewById(R.id.editTextApellidoConsulta)
        correoUsuario = findViewById(R.id.editTextCorreoConsulta)
        telefonoUsuario = findViewById(R.id.editTextTelefonoConsulta)

            db.collection("usuarios").whereEqualTo("correo", name)
                .get()
                .addOnSuccessListener { documentReference ->

                    for (document in documentReference){

                        nombre = document.getString("nombre").toString()
                        apellido = document.getString("apellido").toString()
                        emailCon = document.getString("email").toString()
                        telefono = document.getString("telefono").toString()


                        nombreUsuario.text = nombre
                        apellidoUsuario.text = apellido
                        this.correoUsuario.text = emailCon
                        telefonoUsuario.text = telefono

                        Log.d("Datos doc:", "$nombreUsuario $apellido $emailCon $telefono")
                    }


                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
                }*/
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

