package com.moviles.petproapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_user_data.view.*


class UserDataActivity : AppCompatActivity() {

    private lateinit var nombreUsuario: TextView
    private lateinit var apellidoUsuario: TextView
    private lateinit var correoUsuario: TextView
    private lateinit var telefonoUsuario: TextView
    private lateinit var db: FirebaseFirestore
    private var id: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)


        db = FirebaseFirestore.getInstance()
        id = intent.getStringExtra("id")

        nombreUsuario = findViewById(R.id.editTextNombreConsulta)
        apellidoUsuario = findViewById(R.id.editTextApellidoConsulta)
        correoUsuario = findViewById(R.id.editTextCorreoConsulta)
        telefonoUsuario = findViewById(R.id.editTextTelefonoConsulta)

        consultarDatos(id)
    }

    fun onClickButtonAceptarConsulta(view: View) {
        val prIntent = Intent(this, HomeActivity::class.java)
        startActivity(prIntent)
    }

    private fun consultarDatos(idUser: String){
        db.collection("usuarios").document(idUser)
            .get()
            .addOnSuccessListener { documentSnapshot ->
                nombreUsuario.text = documentSnapshot.getString("nombre")
                apellidoUsuario.text = documentSnapshot.getString("apellido")
                correoUsuario.text = documentSnapshot.getString("email")
                telefonoUsuario.text = documentSnapshot.getString("telefono")
            }
    }
}
