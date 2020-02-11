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
    private lateinit var nombre: String
    private lateinit var apellido: String
    private lateinit var email: String
    private lateinit var telefono: String
    private lateinit var db: FirebaseFirestore
    private lateinit var documento: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)


        db = FirebaseFirestore.getInstance()



        /*fun onClickButtonAceptarConsulta(view: View) {
        val prIntent = Intent(this, LoginActivity::class.java)
        startActivity(prIntent)
    }*/
    }



}
