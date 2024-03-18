package com.angoga.kfd_workshop_mobile.ui.screens.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.angoga.kfd_workshop_mobile.databinding.ActivityLoginBinding
import com.angoga.kfd_workshop_mobile.remote.model.Result
import com.angoga.kfd_workshop_mobile.ui.screens.home.HomeActivity
import com.angoga.kfd_workshop_mobile.ui.screens.register.RegisterActivity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        checkJWT()
        initOnClicks()
        initSubscribe()
    }

    private fun checkJWT() {
        val jwt = getSharedPreferences("JWT", Context.MODE_PRIVATE).getString("JWT", null)
        if (jwt != null) {
            startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
            finish()
        }
    }

    private fun initSubscribe() {
        lifecycleScope.launch {
            viewModel.flow.collect {
                when(it) {
                    is Result.Success -> {
                        getSharedPreferences("JWT", Context.MODE_PRIVATE).edit().putString("JWT", it.data.accessJwt).apply()
                        startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                        finish()
                    }
                    is Result.Error -> {
                        Toast.makeText(this@LoginActivity, it.e.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun initOnClicks() {
        binding.textViewNotRegisteredYet.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }

        binding.buttonSignIn.setOnClickListener {
            viewModel.login(
                binding.editTextMail.text.toString(),
                binding.editTextPassword.text.toString()
            )
        }
    }
}