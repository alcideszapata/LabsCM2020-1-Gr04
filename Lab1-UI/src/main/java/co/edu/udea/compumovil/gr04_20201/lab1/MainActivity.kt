package co.edu.udea.compumovil.gr04_20201.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        
        btnIniciar.setOnClickListener {
            if (txtinic.text.isEmpty()){
                Toast.makeText(this, "Escribe el nombre de tu empresa", Toast.LENGTH_SHORT).show()
            }else {

                val intent: Intent = Intent(this, PersonalData::class.java)
                startActivity(intent)
            }
        }
    }

}