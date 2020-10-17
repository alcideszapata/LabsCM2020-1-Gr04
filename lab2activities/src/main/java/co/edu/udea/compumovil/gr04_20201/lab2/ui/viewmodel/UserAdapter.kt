package co.edu.udea.compumovil.gr04_20201.lab2.ui.viewmodel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import carlose.morales.udea.roomsqlite.Entity.User_Entity_Activity
import co.edu.udea.compumovil.gr04_20201.lab2.R
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter (private val mContext: Context, private val userList: List<User_Entity_Activity>) : ArrayAdapter<User_Entity_Activity>(mContext, 0, userList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_user, parent, false)

        val userItem = userList[position]

        layout.txt_userItem.text = userItem.user
        layout.txt_passwordItem.text = userItem.password
        layout.txt_emailItem.text = userItem.email
        //layout.imageView.setImageResource(userItem.imagen)
        return layout
    }
}