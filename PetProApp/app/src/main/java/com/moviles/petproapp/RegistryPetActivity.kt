package com.moviles.petproapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_registry_pet.*

class RegistryPetActivity : AppCompatActivity() {

    private lateinit var nombreMascota: EditText
    private lateinit var edadMascota: EditText
    private lateinit var descripcionMascota: EditText
    private lateinit var radioGroupEspecie: RadioGroup
    private lateinit var radioButtonEspecie: RadioButton
    private var selectId: Int = 0
    private lateinit var nombre: String
    private var edad: Int = 0
    private lateinit var descripcion: String
    private lateinit var especie: String
    private var vacuna: Boolean = false
    private var id: String = ""
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registry_pet)

        db = FirebaseFirestore.getInstance()
        id = intent.getStringExtra("id")
        radioGroupEspecie = findViewById(R.id.radioGroupEspecie)
        selectId = radioGroupEspecie.checkedRadioButtonId
        radioButtonEspecie = findViewById(selectId)
        especie = radioButtonEspecie.text.toString()
        nombreMascota = findViewById(R.id.editTextNombreMascota)
        edadMascota = findViewById(R.id.editTextEdadMascota)
        descripcionMascota = findViewById(R.id.editTextDescripcionMascota)
        checkBoxVacunaAlDia.setOnClickListener {
            vacuna = checkBoxVacunaAlDia.isChecked
        }

    }

    fun onClickButtonFinRegistroMascota(view: View) {
        nombre = nombreMascota.text.toString()
        edad = edadMascota.text.toString().toInt()
        descripcion = descripcionMascota.text.toString()


        when {
            nombre.isEmpty() -> {
                nombreMascota.error = "Campo obligatorio"
            }
            edad == 0 -> {
                edadMascota.error = "Campo obligatorio"
            }
            descripcion.isEmpty() -> {
                descripcionMascota.error = "Campo obligatorio"
            }
            radioGroupEspecie.checkedRadioButtonId == -1 -> {
                Toast.makeText(this, "Debe selecccionar una especie", Toast.LENGTH_LONG).show()
            }
            else -> {
                val pet = hashMapOf(
                    "especie" to especie,
                    "nombre" to nombre,
                    "edad" to edad,
                    "vacunas" to vacuna,
                    "descripcion" to descripcion
                )

                sendToFirestore(pet)
            }
        }

    }

    private fun sendToFirestore(pet: HashMap<String, Any>) {
        db.collection("usuarios").document(id).collection("mascotas")
            .add(pet as Map<String, Any>)
            .addOnSuccessListener { documentReference ->
                // Toast.makeText(this,"DocumentSnapshot added with ID: " + documentReference.id,Toast.LENGTH_LONG).show()
                val prIntent = Intent(this, HomeActivity::class.java)
                startActivity(prIntent)
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error durante registro", Toast.LENGTH_LONG).show()
            }
    }
}
