package com.moviles.petproapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class metodoPagoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metodo_pago)


        val button: Button = findViewById(R.id.buttonTarjeta)
        button.setOnClickListener {
            var prIntent: Intent = Intent(this, resumenPagoActivity::class.java)
            startActivity(prIntent)
        }

        val buttonEfectivo: Button = findViewById(R.id.buttonEfectivo)
            buttonEfectivo.setOnClickListener {
                var prIntent: Intent = Intent(this, resumenPagoActivity::class.java)
                startActivity(prIntent)
            }
    }
}
