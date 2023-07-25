package com.guido.whatsapp

import android.content.Intent
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.guido.whatsapp.databinding.FragmentLoginBinding
import com.guido.whatsapp.databinding.FragmentSignUpBinding


class Sign_up : Fragment() {
lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        binding = FragmentSignUpBinding.inflate(layoutInflater)
        binding.btnsignup.setOnClickListener {
            val email = binding.txtsignupemail.text.toString()
            val password = binding.txtsignuppassword.text.toString()
            val confirmpassw = binding.txtsignupconfirmpassword.text.toString()
            if (TextUtils.isEmpty(email)){
                binding.txtsignupemail.error = " email Required to Create Account"
            }else if (TextUtils.isEmpty(password)){
                binding.txtsignuppassword.error = " Password Required to Create Account"
            }
            else if (password.length<6){
                binding.txtsignuppassword.error = " Password must be greater than 6 charactersin size"
            }
            else if (password!=confirmpassw){
                binding.txtsignupconfirmpassword.error = "Both Password not Matched"
            }
            else{
                binding.signupProgress.visibility = View.VISIBLE
                crearCuenta()
                Toast.makeText(activity, "se ha creado la cuenta correctamente", Toast.LENGTH_SHORT).show()

            }

        }

        return binding.root
    }

    private fun crearCuenta() {
        context?.getSharedPreferences("cuenta",Context.MODE_PRIVATE)?.edit()
            ?.putString("email",binding.txtsignupemail.text.toString())
            ?.putString("password",binding.txtsignuppassword.text.toString())?.apply()


    }


}