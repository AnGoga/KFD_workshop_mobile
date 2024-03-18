package com.angoga.kfd_workshop_mobile.ui.screens.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.angoga.kfd_workshop_mobile.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private val binding by lazy { ActivityRegisterBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}