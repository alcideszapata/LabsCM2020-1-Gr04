package co.edu.udea.compumovil.gr04_20201.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_contact_data.*
import kotlinx.android.synthetic.main.activity_main.*

class ContactData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)

        btnSigueContacto.setOnClickListener {

           if (txtMail.text.isEmpty()||txtPais.text.isEmpty()||txtTelefono.text.isEmpty()){
               Toast.makeText(this, "Los campos con asterisco con obligatorios", Toast.LENGTH_SHORT).show()
           }else {
               val intent: Intent = Intent(this, MainActivity::class.java)
               startActivity(intent)
           }
        }
    }
}