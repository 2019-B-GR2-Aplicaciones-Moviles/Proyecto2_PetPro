package com.moviles.petproapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class LodgingActivity : AppCompatActivity() {

    private var servicio: String = "Hospedaje"
    private lateinit var radioButtonCuota1: RadioButton
    private lateinit var radioButtonCuota2: RadioButton
    private lateinit var radioButtonCuota3: RadioButton
    private lateinit var radioGroupValores: RadioGroup
    private var id: String = ""
    private lateinit var db: FirebaseFirestore
    private var valor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lodging)

        db = FirebaseFirestore.getInstance()
        id = intent.getStringExtra("id")

        radioButtonCuota1 = findViewById(R.id.radioButtonHospedajeBasico)
        radioButtonCuota2 = findViewById(R.id.radioButtonHospedajeCompleto)
        radioButtonCuota3 = findViewById(R.id.radioButtonHospedajePremium)
    }

    fun onClickButtonPago1(view: View) {
        when {
            radioButtonCuota1.isChecked -> {
                valor = 15
            }
            radioButtonCuota2.isChecked -> {
                valor = 20
            }
            radioButtonCuota3.isChecked -> {
                valor = 25
            }
        }

        when{
            radioGroupValores.checkedRadioButtonId == -1 -> {
                Toast.makeText(this, "Debe selecccionar una opcion", Toast.LENGTH_LONG).show()
            }
            else -> {
                val service = hashMapOf(
                    "idUsuario" to id,
                    "servicio" to servicio,
                    "valor" to valor,
                    "idTarjeta" to "",
                    "idCuidador" to ""
                )

                sendToFirestore(service)
            }
        }
    }

    private fun sendToFirestore(service: HashMap<String, Any>) {
        db.collection("servicios")
            .add(service as Map<String, Any>)
            .addOnSuccessListener { documentReference ->
                // Toast.makeText(this,"DocumentSnapshot added with ID: " + documentReference.id,Toast.LENGTH_LONG).show()
                val prIntent = Intent(this, metodoPagoActivity::class.java)
                prIntent.putExtra("id",id)
                startActivity(prIntent)
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error durante registro", Toast.LENGTH_LONG).show()
            }
    }
}
