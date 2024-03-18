package com.angoga.kfd_workshop_mobile.ui.screens.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.angoga.kfd_workshop_mobile.R
import com.angoga.kfd_workshop_mobile.databinding.ActivityHomeBinding
import com.angoga.kfd_workshop_mobile.databinding.ActivityLoginBinding
import com.angoga.kfd_workshop_mobile.remote.model.Result
import com.angoga.kfd_workshop_mobile.ui.screens.create_news.CreateNewsActivity
import com.angoga.kfd_workshop_mobile.ui.screens.create_news.PublicationViewModel
import com.angoga.kfd_workshop_mobile.ui.screens.register.RegistrationViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeActivity : AppCompatActivity() {
    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }
    private val viewModel: PublicationViewModel by viewModel()
    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initOnClicks()
        initRecyclerView()
        initSubscribe()
    }

    private fun initOnClicks() {
        binding.buttonCreatePublication.setOnClickListener {
            startActivity(Intent(this, CreateNewsActivity::class.java))
        }
    }

    private fun initSubscribe() {
        lifecycleScope.launch {
            viewModel.flow.collect {
                when(it) {
                    is Result.Error -> {
                        Toast.makeText(this@HomeActivity, "Что-то пошло не так", Toast.LENGTH_LONG).show()
                    }
                    is Result.Success -> {
                        adapter.addNewPublication(it.data)
                    }
                }
            }
        }
    }

    private fun initRecyclerView() {
        adapter = NewsAdapter(viewModel)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        initData()
    }

    private fun initData() {
        viewModel.getNextPublication()
    }
}