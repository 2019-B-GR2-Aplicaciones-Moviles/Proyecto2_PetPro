package com.moviles.petproapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class pagoTarjetaActivity : AppCompatActivity() {

    private lateinit var numeroTarjeta: EditText
    private lateinit var fechaCaducidad: EditText
    private lateinit var titularTarjeta: EditText
    private lateinit var codigoSeguridad: EditText
    private lateinit var numero: String
    private lateinit var fecha: String
    private lateinit var titular: String
    private lateinit var codigo: String
    private var id: String = ""
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago_tarjeta)

        id = intent.getStringExtra("id")
        db = FirebaseFirestore.getInstance()

        numeroTarjeta = findViewById(R.id.editTextNumeroTarjeta)
        fechaCaducidad = findViewById(R.id.editTextFechaCaduca)
        titularTarjeta = findViewById(R.id.editTextTitularTarjeta)
        codigoSeguridad = findViewById(R.id.editTextCVV)
    }

    fun OnClickAceptarTarjeta(view: View){
        numero = numeroTarjeta.text.toString()
        fecha = fechaCaducidad.text.toString()
        titular = titularTarjeta.text.toString()
        codigo = codigoSeguridad.text.toString()

        when{
            numero.isEmpty() -> {
                numeroTarjeta.error = "Campo obligatorio"
            }
            numero.length < 16 -> {
                numeroTarjeta.error = "Numero de tarjeta invalido"
            }
            fecha.isEmpty() -> {
                fechaCaducidad.error = "Campo obligatorio"
            }
            titular.isEmpty() -> {
                titularTarjeta.error = "Campo obligatorio"
            }
            codigo.isEmpty() -> {
                codigoSeguridad.error = "Campo obligatorio"
            }
            codigo.length < 3 -> {
                codigoSeguridad.error = "CVV invalido"
            }
            else -> {
                val tarjeta = hashMapOf(
                    "numero" to numero,
                    "caducidad" to fecha,
                    "titular" to titular,
                    "cvv" to codigo
                )

                sendToFirestore(tarjeta)
            }
        }
    }

    private fun sendToFirestore(card: HashMap<String, String>) {
        db.collection("usuarios").document(id).collection("tarjetas")
            .add(card as Map<String, Any>)
            .addOnSuccessListener { documentReference ->
                // Toast.makeText(this,"DocumentSnapshot added with ID: " + documentReference.id,Toast.LENGTH_LONG).show()
                val prIntent = Intent(this, HomeActivity::class.java)
                prIntent.putExtra("id",id)
                startActivity(prIntent)
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error durante registro", Toast.LENGTH_LONG).show()
            }
    }
}
