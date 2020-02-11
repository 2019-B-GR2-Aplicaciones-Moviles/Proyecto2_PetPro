package com.vizuete.petprositterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class ProfileActivity : AppCompatActivity() {

    private lateinit var nombreUsuario: TextView
    private lateinit var apellidoUsuario: TextView
    private lateinit var correoUsuario: TextView
    private lateinit var telefonoUsuario: TextView
    private lateinit var cuentaUsuario: TextView
    private lateinit var db: FirebaseFirestore
    private var id: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        db = FirebaseFirestore.getInstance()
        id = intent.getStringExtra("id")

        nombreUsuario = findViewById(R.id.editTextNombreConsulta)
        apellidoUsuario = findViewById(R.id.editTextApellidoConsulta)
        correoUsuario = findViewById(R.id.editTextCorreoConsulta)
        telefonoUsuario = findViewById(R.id.editTextTelefonoConsulta)
        cuentaUsuario = findViewById(R.id.editTextBankAccountConsulta)

        consultarDatos(id)
    }

    fun onClickButtonAceptarConsulta(view: View) {
        val prIntent = Intent(this, HomeActivity::class.java)
        prIntent.putExtra("id", id)
        startActivity(prIntent)
    }

    private fun consultarDatos(idUser: String){
        db.collection("cuidadores").document(idUser)
            .get()
            .addOnSuccessListener { documentSnapshot ->
                nombreUsuario.text = documentSnapshot.getString("nombre")
                apellidoUsuario.text = documentSnapshot.getString("apellido")
                correoUsuario.text = documentSnapshot.getString("email")
                telefonoUsuario.text = documentSnapshot.getString("telefono")
                cuentaUsuario.text = documentSnapshot.getString("banco")
            }
    }
}
