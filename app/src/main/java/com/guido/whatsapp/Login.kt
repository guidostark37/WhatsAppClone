package com.guido.whatsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.guido.whatsapp.databinding.ActivityMainBinding
import com.guido.whatsapp.databinding.FragmentLoginBinding


class Login : Fragment() {
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        var guardar = requireActivity().getSharedPreferences("cuenta",Context.MODE_PRIVATE)
        var email = guardar?.getString("email","")
        var password = guardar?.getString("password","")


        binding.btnlogin.setOnClickListener {

            startActivity(Intent(activity,MainActivity::class.java))

           if(binding.txtloginemail.text.toString()== email && binding.txtloginpassword.text.toString()==password){
                startActivity(Intent(activity,MainActivity::class.java))
            }else{
                binding.txtloginemail.error = "requerido"
            }
        }
          return binding.root

    }




}