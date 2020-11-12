package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.R
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.base.AppDatabase
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.Sitios

import kotlinx.android.synthetic.main.fragment_lugares.*

class LugaresFragment : Fragment(),MainAdapter.OnSitioClickListener {

    /*private val viewModel by viewModels<MainViewModel> { ((AppDatabase.getDatabase(this.context))) }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_lugares, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        val database= this.context?.let {
            AppDatabase.getDatabase(it)}

        val lista = listOf(

            Sitios(" "," "," "," "),

            )

        if (database != null) {
            database.sitios().getAll().observe(viewLifecycleOwner, Observer { result ->

                rv_sitios.adapter = MainAdapter(requireContext(),result+lista,this)

            })
        }

        btn_insert_sitio.setOnClickListener {
            findNavController().navigate(R.id.registerSitesFragment)
        }
    }

    private fun setupRecyclerView(){
        rv_sitios.layoutManager = LinearLayoutManager(requireContext())
        rv_sitios.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
    }

    override fun OnSitioClick(sitios: Sitios) {
        val bundle = Bundle()
        bundle.putParcelable("sitios", sitios)
        findNavController().navigate(R.id.detallesLugarFragment,bundle)
    }
}