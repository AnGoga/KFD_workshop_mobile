package com.angoga.kfd_workshop_mobile.ui.screens.create_news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.angoga.kfd_workshop_mobile.R
import com.angoga.kfd_workshop_mobile.databinding.ActivityCreateNewsBinding
import com.angoga.kfd_workshop_mobile.databinding.ActivityHomeBinding

class CreateNewsActivity : AppCompatActivity() {
    private val binding by lazy { ActivityCreateNewsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}