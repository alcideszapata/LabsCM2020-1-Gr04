package co.edu.udea.compumovil.gr04_20121.Lab3Architecture.valueObjet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.R
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.base.AppDatabase
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.model.UserEntity
import co.edu.udea.compumovil.gr04_20121.Lab3Architecture.ui.viewmodel.UserAdapter
import kotlinx.android.synthetic.main.activity_register_user.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)
        val dataBaseUserPOI = AppDatabase.getDatabase(this,this.lifecycleScope)

        btn_save_Register.setOnClickListener {
            val user = txtuser_Register.text.toString()
            val pass = txtpass_Register.text.toString()
            val email = txtemail_Register.text.toString()
            val users = UserEntity(user, pass, email)
            CoroutineScope(Dispatchers.IO).launch {
                dataBaseUserPOI.UserDao().insertAll(users)
                this@RegisterUserActivity.finish()
            }
        }

        var userList = emptyList<UserEntity>()
        val database = AppDatabase.getDatabase(this,this.lifecycleScope)
        database.UserDao().getAll().observe(this, Observer {
            userList = it
            val adapter = UserAdapter(this, userList)
            listAllUsser_Register.adapter = adapter
        })
    }
}