package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.ui.viewmodel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.R
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.UserEntity
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(private val mContext: Context, private val userList: List<UserEntity>) :
    ArrayAdapter<UserEntity>(mContext, 0, userList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_user, parent, false)
        val userItem = userList[position]
        layout.txt_userItem.text = userItem.user
        layout.txt_passwordItem.text = userItem.password
        layout.txt_emailItem.text = userItem.email
        return layout
    }
}