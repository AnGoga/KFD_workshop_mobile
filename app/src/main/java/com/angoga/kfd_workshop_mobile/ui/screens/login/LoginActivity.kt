package com.angoga.kfd_workshop_mobile.ui.screens.login

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.angoga.kfd_workshop_mobile.databinding.ActivityLoginBinding
import com.angoga.kfd_workshop_mobile.ui.screens.register.RegisterActivity


class LoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initOnClicks()
    }

    private fun initOnClicks() {
        binding.textViewNotRegisteredYet.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }
    }
}