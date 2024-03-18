package com.angoga.kfd_workshop_mobile.ui.screens.create_news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.angoga.kfd_workshop_mobile.databinding.ActivityCreateNewsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateNewsActivity : AppCompatActivity() {
    private val binding by lazy { ActivityCreateNewsBinding.inflate(layoutInflater) }
    private val viewModel: PublicationViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initOnClicks()
    }

    private fun initOnClicks() {
        binding.buttonCreateNews.setOnClickListener {
            val title = binding.titleEditTitle.text.toString()
            val content = binding.editTextContent.text.toString()

            // TODO: add validation
            viewModel.createPublication(title, content)
            finish()
        }
    }
}