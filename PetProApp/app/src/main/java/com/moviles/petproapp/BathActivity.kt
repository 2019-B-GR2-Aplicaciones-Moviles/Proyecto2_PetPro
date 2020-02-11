package com.moviles.petproapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class BathActivity : AppCompatActivity() {

    private var servicio: String = "Baño"
    private lateinit var radioButtonCuota1: RadioButton
    private lateinit var radioButtonCuota2: RadioButton
    private lateinit var radioButtonCuota3: RadioButton
    private lateinit var radioGroupValores: RadioGroup
    private var id: String = ""
    private lateinit var db: FirebaseFirestore
    private var valor: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bath)

        db = FirebaseFirestore.getInstance()
        id = intent.getStringExtra("id")

        radioGroupValores = findViewById(R.id.radioGroupBaths)
        radioButtonCuota1 = findViewById(R.id.radioButtonBañoBasico)
        radioButtonCuota2 = findViewById(R.id.radioButtonBañoCompleto)
        radioButtonCuota3 = findViewById(R.id.radioButtonBañoPremium)
    }

    fun onClickButtonPago3(view: View) {
        when {
            radioButtonCuota1.isChecked -> {
                valor = 12
            }
            radioButtonCuota2.isChecked -> {
                valor = 18
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
