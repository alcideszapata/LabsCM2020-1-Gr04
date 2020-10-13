package co.edu.udea.compumovil.gr04_20201.lab2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.edu.udea.compumovil.gr04_20201.lab2.R
import co.edu.udea.compumovil.gr04_20201.lab2.data.model.Sitios
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detalles_lugar.*


class DetallesLugarFragment : Fragment() {

    private lateinit var sitios: Sitios

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            sitios = it.getParcelable("sitios")!!

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_detalles_lugar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(sitios.imagen).into(img_sitio)
        txt_titulo.text = sitios.nombre
        txt_descripcion.text = sitios.descripcion

    }

}