package co.edu.udea.compumovil.gr04_20201.lab2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import co.edu.udea.compumovil.gr04_20201.lab2.ui.LugaresFragment
import co.edu.udea.compumovil.gr04_20201.lab2.vo.RegisterUserActivity
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btningresar.setOnClickListener {
            findNavController().navigate(R.id.lugaresFragment)
        }



        btnregirtro.setOnClickListener {
            val intent:Intent = Intent(activity, RegisterUserActivity::class.java)
            startActivity(intent)
        }

    }

}