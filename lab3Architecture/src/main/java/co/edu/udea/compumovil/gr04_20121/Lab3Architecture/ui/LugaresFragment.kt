package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.R
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.base.AppDatabase
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.Sitios
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.ui.viewmodel.PostViewModel

import kotlinx.android.synthetic.main.fragment_lugares.*


class LugaresFragment : Fragment(),MainAdapter.OnSitioClickListener {

    private lateinit var viewModel: PostViewModel
    private lateinit var postAdapter: MainAdapter

    /*private val viewModel by viewModels<MainViewModel> { ((AppDatabase.getDatabase(this.context))) }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PostViewModel::class.java)

        viewModel.allPosts.observe(viewLifecycleOwner, Observer {
            postAdapter.updatePostList(it)
        })
        //viewModel.requestPosts()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_lugares, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        btn_insert_sitio.setOnClickListener {
            findNavController().navigate(R.id.registerSitesFragment)
        }
    }

    private fun setupRecyclerView(){

        rv_sitios.layoutManager = LinearLayoutManager(requireContext())
        rv_sitios.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))

        postAdapter = MainAdapter(this as MainAdapter.OnSitioClickListener)
        rv_sitios.adapter = postAdapter

    }
        override fun OnSitioClick(sitios: Sitios) {
        val bundle = Bundle()
        bundle.putParcelable("sitios", sitios)
        findNavController().navigate(R.id.detallesLugarFragment,bundle)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_post_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_refresh -> {
                Log.d("LugaresFragment", "Action refresh")
                viewModel.requestPosts()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}