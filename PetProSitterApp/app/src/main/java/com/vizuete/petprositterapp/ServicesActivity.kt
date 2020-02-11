package com.vizuete.petprositterapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore


class ServicesActivity : AppCompatActivity() {

    private lateinit var listaServicios: ListView
    private lateinit var db: FirebaseFirestore
    private lateinit var service: Services

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        val listServices: MutableList<Services> = ArrayList()
        db = FirebaseFirestore.getInstance()

        listaServicios = findViewById(R.id.listViewServicios)
        db.collection("servicios").whereEqualTo("idCuidador","")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents){
                    service.idUsuario = document.getString("idUsuario")
                    service.servicio = document.getString("servicio")
                    service.valor = document.getDouble("valor")
                    service.idTarjeta = document.getString("idTarjeta")
                    service.idCuidador= document.getString("idCuidador")
                    listServices.add(service)
                }
            }

        val servicesAdapter = ArrayAdapter<Services>(this,
            android.R.layout.simple_list_item_1, listServices)

        listaServicios.adapter = servicesAdapter
    }
}
