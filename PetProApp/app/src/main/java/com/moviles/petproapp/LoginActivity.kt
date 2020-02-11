package com.moviles.petproapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

class LoginActivity : AppCompatActivity() {

    // declaracion de variables 
    private lateinit var nombreUsuario: EditText
    private lateinit var passwordUsuario: EditText
    private lateinit var usuario: String
    private lateinit var password: String
    private lateinit var id: String
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        nombreUsuario = findViewById(R.id.editTextUserLogin)
        passwordUsuario = findViewById(R.id.editTextPwLogin)

        db = FirebaseFirestore.getInstance()
        auth = FirebaseAuth.getInstance()
    }

    fun onClickLogin(view: View) {

        usuario = nombreUsuario.text.toString()
        password = passwordUsuario.text.toString()

        when {
            usuario.isEmpty() -> {
                nombreUsuario.error = "Campo obligatorio"
            }
            password.isEmpty() -> {
                passwordUsuario.error = "Campo obligatorio"
            }
            password.length < 8 -> {
                passwordUsuario.error = "La contraseña debe tener al menos 8 caracteres"
            }
            else -> {
                loginUser()
            }
        }
    }

    fun onClickButtonRegistro(view: View) {
        val prIntent = Intent(this, RegistryActivity::class.java)
        startActivity(prIntent)
    }

    private fun loginUser() {
        auth.signInWithEmailAndPassword(usuario,password)
            .addOnCompleteListener(this){task ->
                if (task.isSuccessful){
                    var user = auth.currentUser
                    if (user!!.isEmailVerified){
                        consultarIDUsuario()
                        val intentHome = Intent(this,HomeActivity::class.java)
                        intentHome.putExtra("id",id)
                        startActivity(intentHome)
                        finish()
                    }else{
                        
                        Toast.makeText(this, "Verificar su cuenta para poder iniciar sesion", Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(this, "El usuario o contraseña son incorrectas", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun consultarIDUsuario(){
        db.collection("usuarios").whereEqualTo("email", usuario)
            .get()
            .addOnSuccessListener { documentReference ->
                for (document in documentReference) {
                    if (document.exists()) {
                        id = document.id
                    }
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(
                    this,
                    "Error$e",
                    Toast.LENGTH_LONG
                ).show()
            }
    }
}
