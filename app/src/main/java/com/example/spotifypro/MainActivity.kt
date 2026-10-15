package com.example.spotifypro

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var etcorreo: EditText
    private lateinit var etpass: EditText
    private lateinit var btningresar: Button

    private lateinit var dbHelper: Databasehelper


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val tvcrearcuenta = findViewById<TextView>(R.id.tvcrearcuenta)

        etcorreo = findViewById(R.id.etcorreo)
        etpass = findViewById(R.id.etpass)
        btningresar = findViewById(R.id.btningresar)

        //iniciarlizar la base de datos
        dbHelper = Databasehelper(this)

        //evento para inciar sesion

        btningresar.setOnClickListener {
            //lama al metodo para iniciar sesion
            iniciarSesion()
        }




        tvcrearcuenta.setOnClickListener {
            val intent = Intent(this, RegistrarActivity::class.java)
            startActivity(intent)
        }


    }

    //metodo para iniciar sesion

    private fun iniciarSesion(){
        val correo = etcorreo.text.toString().trim()
        val password = etpass.text.toString().trim()

        if(correo.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        //crear instancia de la base de datos
        val resultado = dbHelper.iniciarSesion(correo, password)

        //validar si el inicisio de sesion fue correcto

        if(resultado){
            //el resutlado es verdadero
            val intent = Intent(this, HomeActivity::class.java)

            Toast.makeText(this, "Inicio de sesion correcto", Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()
        }else{
            //el resultado es falso
            Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
        }
        }



    }





