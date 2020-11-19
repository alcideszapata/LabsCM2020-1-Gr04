package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.R
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.Places
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_details_place.*

class DetailsPlaceFragment : Fragment() {
    private lateinit var places: Places

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            places = it.getParcelable("placesTable")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details_place, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(places.image).into(img_place)
        txt_title.text = places.name
        txt_description.text = places.description
        txt_temperature.text = places.temperature

        bte_localization.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:0,0?q=city+" + places.name)
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
        val url =
            "https://www.google.com/search?ei=6IOLX8D8HIOG5wKfoYXwDA&q=Atracciones+destacadas+en " + places.name
        bte_places_recommended.setOnClickListener {
            val gmmIntentUri = Uri.parse(url);
            val intent = Intent(Intent.ACTION_VIEW, gmmIntentUri);
            startActivity(intent);
        }
    }
}