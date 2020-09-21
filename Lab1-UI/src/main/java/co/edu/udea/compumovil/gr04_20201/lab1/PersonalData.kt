package co.edu.udea.compumovil.gr04_20201.lab1

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_personal_data.*
import java.util.*

class PersonalData : AppCompatActivity() {
    lateinit var escolaridad : Spinner
    lateinit var mostrar : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)

        escolaridad = findViewById(R.id.idSpinner) as Spinner
        mostrar = findViewById(R.id.textView4) as TextView

        val options = arrayOf("Primaria", "Secundaria", "Universitario", "Otros")
        escolaridad.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        escolaridad.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                mostrar.text = options.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                mostrar.text = "grado de escolaridad"
            }

        }


        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        cambiarbtn.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view: DatePicker?, mYear: Int, mMonth: Int, mDay: Int ->
                dateTv.setText(""+ mDay +"/"+ mMonth +"/"+ mYear)
            }, year, month, day)
            dpd.show()
        }



    }
}