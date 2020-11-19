package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.R
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.Places
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.ui.viewmodel.PostViewModel
import kotlinx.android.synthetic.main.fragment_places.*

class PlacesFragment : Fragment(), MainAdapter.OnPlaceClickListener {

    private lateinit var viewModel: PostViewModel
    private lateinit var postAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        viewModel.allPosts.observe(viewLifecycleOwner, Observer {
            postAdapter.updatePostList(it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_places, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        btn_insert_place.setOnClickListener {
            findNavController().navigate(R.id.registerPlacesFragment)
        }
    }

    private fun setupRecyclerView() {
        rv_places.layoutManager = LinearLayoutManager(requireContext())
        rv_places.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        postAdapter = MainAdapter(this as MainAdapter.OnPlaceClickListener)
        rv_places.adapter = postAdapter
    }

    override fun OnPlaceClick(places: Places) {
        val bundle = Bundle()
        bundle.putParcelable("placesTable", places)
        findNavController().navigate(R.id.detailsPlaceFragment, bundle)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_post_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_refresh -> {
                Log.d("PlacesFragment", "Action refresh")
                viewModel.requestPosts()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}