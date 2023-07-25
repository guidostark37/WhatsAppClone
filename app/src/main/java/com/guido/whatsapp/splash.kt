package com.guido.whatsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.core.os.postDelayed
import com.guido.whatsapp.databinding.ActivitySplashBinding


class splash : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    lateinit var imageGif:ImageView
    lateinit var topAnim:Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        cuentaatras()

    }
    private fun cuentaatras() {
        Handler(Looper.myLooper()!!).postDelayed(5000){
            startActivity(Intent(this,authentication::class.java))
        }
    }
}