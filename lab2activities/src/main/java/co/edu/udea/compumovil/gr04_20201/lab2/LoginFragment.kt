package co.edu.udea.compumovil.gr04_20201.lab2

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CursorAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import co.edu.udea.compumovil.gr04_20201.lab2.base.AppDatabase
import co.edu.udea.compumovil.gr04_20201.lab2.ui.LugaresFragment
import co.edu.udea.compumovil.gr04_20201.lab2.ui.MainAdapter
import co.edu.udea.compumovil.gr04_20201.lab2.vo.RegisterUserActivity
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_lugares.*
import org.intellij.lang.annotations.JdkConstants


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

        val database= this.context?.let {
            AppDatabase.getDatabase(it)}

        btningresar.findViewById<Button>(R.id.btningresar)
        btningresar.setOnClickListener {

            val userLogin = txtUser_Login.text.toString()
            val userpasslog = txtPass_Login.text.toString()

            txtUser_Login.findViewById<EditText>(R.id.txtUser_Login)
            txtPass_Login.findViewById<EditText>(R.id.txtPass_Login)


            if (userLogin.isEmpty()||userpasslog.isEmpty()){
                Toast.makeText(requireContext(),"Por favor diligencie todos los campos",Toast.LENGTH_SHORT).show()
            }else {
                if (database != null) {
                    database.UserDao().getUser(userLogin).observe(
                        viewLifecycleOwner,
                        Observer { result ->
                            if (result != null && result.password.equals(userpasslog)) {
                                Toast.makeText(requireContext(), "Bienvenido", Toast.LENGTH_SHORT)
                                    .show()
                                findNavController().navigate(R.id.lugaresFragment)
                            } else {
                                Toast.makeText(requireContext(), "Usuario ó Contrseña Incorrecto ", Toast.LENGTH_SHORT).show()
                            }

                        })
                }

                /*findNavController().navigate(R.id.lugaresFragment)
                Toast.makeText(requireContext(),"Bienvenido(a) sr(a)" + userLogin,Toast.LENGTH_SHORT).show()*/
            }


        }

        btnregirtro.setOnClickListener {
            val intent:Intent = Intent(activity, RegisterUserActivity::class.java)
            startActivity(intent)
        }

    }

}