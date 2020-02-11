package com.moviles.petproapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class pagoTarjetaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago_tarjeta)

        val button: Button = findViewById(R.id.buttonAceptarPagoTarjeta)
        button.setOnClickListener {
            var prIntent: Intent = Intent(this, HomeActivity::class.java)
            startActivity(prIntent)
        }
    }
}
