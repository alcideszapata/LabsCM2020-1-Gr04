package co.edu.udea.compumovil.gr04_20201.lab2.ui

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
import co.edu.udea.compumovil.gr04_20201.lab2.R
import co.edu.udea.compumovil.gr04_20201.lab2.base.AppDatabase
import co.edu.udea.compumovil.gr04_20201.lab2.data.model.DataSource
import co.edu.udea.compumovil.gr04_20201.lab2.data.model.Sitios
import co.edu.udea.compumovil.gr04_20201.lab2.domain.RepoImpl
import co.edu.udea.compumovil.gr04_20201.lab2.ui.viewmodel.MainViewModel
import co.edu.udea.compumovil.gr04_20201.lab2.ui.viewmodel.VMFactory
import co.edu.udea.compumovil.gr04_20201.lab2.vo.Resource

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

        if (database != null) {
            database.sitios().getAll().observe(viewLifecycleOwner, Observer { result ->

                rv_sitios.adapter = MainAdapter(requireContext(),result,this)

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