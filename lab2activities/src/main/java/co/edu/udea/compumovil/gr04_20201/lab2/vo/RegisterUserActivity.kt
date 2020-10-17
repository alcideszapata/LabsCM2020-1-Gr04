package co.edu.udea.compumovil.gr04_20201.lab2.vo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import carlose.morales.udea.roomsqlite.Entity.User_Entity_Activity
import co.edu.udea.compumovil.gr04_20201.lab2.R
import co.edu.udea.compumovil.gr04_20201.lab2.base.AppDatabase
import co.edu.udea.compumovil.gr04_20201.lab2.ui.viewmodel.UserAdapter
import kotlinx.android.synthetic.main.activity_register_user.*
import kotlinx.android.synthetic.main.item_user.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class RegisterUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        val dataBaseUserPOI = AppDatabase.getDatabase(this)

        btn_save_Register.setOnClickListener {
            val user = txtuser_Register.text.toString()
            val pass = txtpass_Register.text.toString()
            val email = txtemail_Register.text.toString()

            val users = User_Entity_Activity(user, pass, email)

            CoroutineScope(Dispatchers.IO).launch {

                dataBaseUserPOI.UserDao().insertAll(users)

                this@RegisterUserActivity.finish()

            }
        }


        var userList = emptyList<User_Entity_Activity>()

        val database = AppDatabase.getDatabase(this)

        database.UserDao().getAll().observe(this, Observer {
            userList = it

            val adapter = UserAdapter(this, userList)

            listAllUsser_Register.adapter = adapter
        })

    }
}