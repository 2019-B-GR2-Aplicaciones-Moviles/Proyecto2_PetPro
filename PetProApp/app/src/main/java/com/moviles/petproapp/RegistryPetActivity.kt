package com.moviles.petproapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_registry_pet.*

class RegistryPetActivity : AppCompatActivity() {

    private lateinit var nombreMascota: EditText
    private lateinit var edadMacota: EditText
    private lateinit var descripcionMascota: EditText
    private lateinit var vacunaMascota: CheckBox
    private lateinit var nombre: String
    private lateinit var edad: String
    private lateinit var descripcion: String
    private var vacuna: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registry_pet)

        nombreMascota = findViewById(R.id.editTextNombreMascota)
        edadMacota = findViewById(R.id.editTextEdadMascota)
        descripcionMascota = findViewById(R.id.editTextDescripcionMascota)
        checkBoxVacunaAlDia.setOnClickListener(View.OnClickListener {
            vacuna = checkBoxVacunaAlDia.isChecked
        })
    }

    fun onClickButtonFinRegistroMascota(view: View) {
        val prIntent = Intent(this, LoginActivity::class.java)
        startActivity(prIntent)

        nombre = nombreMascota.text.toString()
        edad = edadMacota.text.toString()
        descripcion = descripcionMascota.text.toString()


        when {
            nombre.isEmpty() -> {
                nombreMascota.error = "Campo obligatorio"
            }
            edad.isEmpty() -> {
                edadMacota.error = "Campo obligatorio"
            }

            descripcion.isEmpty() -> {
                descripcionMascota.error = "Campo obligatorio"
            }

            else -> {

            }
            }

    }





}
