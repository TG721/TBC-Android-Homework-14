package com.example.android_tbc_homework_14.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide.init
import com.example.android_tbc_homework_14.MainViewModel
import com.example.android_tbc_homework_14.adapter.MyAdapter
import com.example.android_tbc_homework_14.databinding.FragmentMainBinding
import com.example.android_tbc_homework_14.model.Items
import kotlinx.coroutines.launch

class MainFragment : Fragment() {
    private var _bindingA: FragmentMainBinding? = null
    private val bindingB get() = _bindingA!!

    private val myAdapter by lazy {
        MyAdapter()
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bindingA = FragmentMainBinding.inflate(inflater)
        return _bindingA?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRec()
        getInfo()
    }
    private fun initRec() {
        _bindingA!!.recyclerView.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun getInfo() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getInformation()
                viewModel.myFlow.collect {
                    myAdapter.submitList(it.content)
                }
            }

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _bindingA = null
    }
}