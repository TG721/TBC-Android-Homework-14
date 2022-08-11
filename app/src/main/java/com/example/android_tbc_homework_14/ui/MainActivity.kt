package com.example.android_tbc_homework_14.UI

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_tbc_homework_14.MainViewModel
import com.example.android_tbc_homework_14.MainViewModelFactory
import com.example.android_tbc_homework_14.MyResponseState
import com.example.android_tbc_homework_14.adapter.ItemsListAdapter
import com.example.android_tbc_homework_14.databinding.ActivityMainBinding
import com.example.android_tbc_homework_14.repository.Repository
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    private val adapter by lazy { ItemsListAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getInfo()

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.myState.collect{
                    when(it){
                        is MyResponseState.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }
                        is MyResponseState.Error -> {
                            binding.finalText.text = it.message
                            binding.progressBar.visibility = View.GONE
                        }
                        is MyResponseState.Success -> {
                            binding.progressBar.visibility = View.GONE
                            adapter.submitList(it.items.content)
//                            binding.finalText.text = it.items.toString()
                        }
                        else -> {}
                    }
                }
            }
        }
    }
}