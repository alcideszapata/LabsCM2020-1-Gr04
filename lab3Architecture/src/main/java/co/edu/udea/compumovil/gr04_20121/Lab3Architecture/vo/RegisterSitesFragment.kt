package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.vo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.R
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.base.AppDatabase
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.Sitios
import kotlinx.android.synthetic.main.fragment_register_sites.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class
RegisterSitesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment



        return inflater.inflate(R.layout.fragment_register_sites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = this.context?.let { AppDatabase.getDatabase(it) }
        btn_save.setOnClickListener {
            val nombre= name_et.text.toString()
            val imagen= img_et.text.toString()
            val descripcion= description_et.text.toString()
            val temperatura= temperatura_et.text.toString()

            if (name_et.text.isEmpty()||img_et.text.isEmpty()||description_et.text.isEmpty()){
                Toast.makeText(requireContext(), "Por favor diligencie todos los campos", Toast.LENGTH_SHORT).show()
            }else {
                val sitios = Sitios(nombre, imagen, descripcion,temperatura)
                Toast.makeText(requireContext(), "Nuevo registro guardado", Toast.LENGTH_SHORT)
                    .show()

                CoroutineScope(Dispatchers.IO).launch {
                    if (database != null) {
                        database.sitios().insertAll(sitios)
                    }
                }

                findNavController().navigate(R.id.lugaresFragment)
            }

        }

    }


}

