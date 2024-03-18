package com.angoga.kfd_workshop_mobile.ui.screens.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.angoga.kfd_workshop_mobile.R
import com.angoga.kfd_workshop_mobile.databinding.ActivityHomeBinding
import com.angoga.kfd_workshop_mobile.databinding.ActivityLoginBinding


class HomeActivity : AppCompatActivity() {
    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}