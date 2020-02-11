package com.moviles.petproapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.firestore.FirebaseFirestore

class metodoPagoActivity : AppCompatActivity() {

    private var id: String = ""
    private lateinit var db: FirebaseFirestore
    private lateinit var buttonTarjeta: Button
    private var idTarjeta: String = ""
    private var idServicio: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metodo_pago)

        db = FirebaseFirestore.getInstance()
        id = intent.getStringExtra("id")

        buttonTarjeta = findViewById(R.id.buttonTarjeta)

        db.collection("usuarios").document(id).collection("tarjetas")
            .get()
            .addOnSuccessListener { documents ->
                if (documents.isEmpty) {
                    buttonTarjeta.visibility = View.INVISIBLE
                }
            }
    }

    fun OnClickTarjeta(view: View) {
        db.collection("usuarios").document(id).collection("tarjetas")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    idTarjeta = document.id
                }
                consultarServicio()
                val prIntent = Intent(this, HomeActivity::class.java)
                prIntent.putExtra("id", id)
                startActivity(prIntent)
            }
    }

    fun OnClickEfectivo(view: View) {

        consultarServicio()
        val prIntent = Intent(this, HomeActivity::class.java)
        prIntent.putExtra("id", id)
        startActivity(prIntent)

    }

    private fun consultarServicio() {
        db.collection("servicios").whereEqualTo("idUsuario", id)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    if (document.exists()) {
                        idServicio = document.id
                        actualizarServicio(idServicio)
                    }
                }
            }
    }

    private fun actualizarServicio(idS: String) {
        db.collection("servicios").document(idS).update("idTarjeta", idTarjeta)
    }


}
