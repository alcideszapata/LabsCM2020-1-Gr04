package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.valueObjet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.R
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.base.AppDatabase
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.Places
import kotlinx.android.synthetic.main.fragment_register_places.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class
RegisterPlacesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register_places, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val database = this.context?.let {
            AppDatabase.getDatabase(
                it,
                this.viewLifecycleOwner.lifecycleScope
            )
        }
        btn_save.setOnClickListener {
            val name = name_et.text.toString()
            val image = img_et.text.toString()
            val description = description_et.text.toString()
            val temperature = temperature_et.text.toString()

            if (name_et.text.isEmpty() || img_et.text.isEmpty() || description_et.text.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Por favor diligencie todos los campos",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val sitios = Places(name, image, description, temperature)
                Toast.makeText(requireContext(), "Nuevo registro guardado", Toast.LENGTH_SHORT)
                    .show()

                CoroutineScope(Dispatchers.IO).launch {
                    if (database != null) {
                        database.places().insertAll(sitios)
                    }
                }
                findNavController().navigate(R.id.placesFragment)
            }
        }
    }
}

