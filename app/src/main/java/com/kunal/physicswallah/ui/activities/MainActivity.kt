package com.kunal.physicswallah.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kunal.physicswallah.data.network.models.Data
import com.kunal.physicswallah.databinding.ActivityMainBinding
import com.kunal.physicswallah.ui.adapters.DataAdapter
import com.kunal.physicswallah.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var view: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)
        view.lifecycleOwner = this
        getData()
        initializeObservers()
        view.close.setOnClickListener {
            finish()
        }
    }

    private fun getData() {
        viewModel.getData()
    }

    private fun initializeObservers() {
        viewModel.data.observe(this) {
            initViews(it)
        }
    }

    private fun initViews(data: List<Data>) {
        view.rvData.apply {
            adapter = DataAdapter(data)
        }
    }
}