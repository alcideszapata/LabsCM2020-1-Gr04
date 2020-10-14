package co.edu.udea.compumovil.gr04_20201.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import co.edu.udea.compumovil.gr04_20201.lab2.data.model.DataSource
import co.edu.udea.compumovil.gr04_20201.lab2.domain.RepoImpl
import co.edu.udea.compumovil.gr04_20201.lab2.ui.LugaresFragment
import co.edu.udea.compumovil.gr04_20201.lab2.ui.viewmodel.MainViewModel
import co.edu.udea.compumovil.gr04_20201.lab2.ui.viewmodel.VMFactory
import kotlinx.android.synthetic.main.fragment_login.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        navController = findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}
