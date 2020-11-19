package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.R
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.base.BaseViewHolder
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.Places
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.sitios_row.view.*

class MainAdapter(
                  private val itemClickLister: MainAdapter.OnPlaceClickListener) :
    RecyclerView.Adapter<BaseViewHolder<*>>(){

    private var PlacesList = mutableListOf<Places>()

    interface OnPlaceClickListener{
        fun OnPlaceClick(places: Places)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.sitios_row,parent,false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is MainViewHolder -> holder.bind(PlacesList[position],position)
        }
    }

    override fun getItemCount(): Int {
        return PlacesList.size
    }

    inner class MainViewHolder(itemView: View): BaseViewHolder<Places>(itemView){
        override fun bind(item: Places, position: Int) {
            Glide.with(itemView.context).load(item.image).centerCrop().into(itemView.img_place)
            itemView.txt_title.text = item.name
            itemView.txt_description.text = item.description
            itemView.setOnClickListener { itemClickLister.OnPlaceClick(item)}
        }

    }
    fun updatePostList(posts: List<Places>?) {
        this.PlacesList.clear()
        posts?.let { this.PlacesList.addAll(it) }
        notifyDataSetChanged()
    }
}