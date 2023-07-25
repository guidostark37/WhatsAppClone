package com.guido.whatsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.core.os.postDelayed
import com.guido.whatsapp.databinding.ActivitySplashBinding
import java.util.logging.Handler

class splash : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    lateinit var imageGif:ImageView
    lateinit var topAnim:Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imageGif = binding.splashGif
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_anim)
        imageGif.animation = topAnim
        android.os.Handler(Looper.myLooper()!!).postDelayed(5000){
            startActivity(Intent(this,authentication::class.java))
        }
    }
}