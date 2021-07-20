package com.kenneth.week_seven_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.kenneth.week_seven_task.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        itemAdapter = ItemAdapter(listOf())
        binding.recycler.adapter = itemAdapter

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.apply {
            getAllItems()
            items.observe(this@MainActivity, {items ->
                itemAdapter.lists = items
                itemAdapter.notifyDataSetChanged()
            })
        }
    }
}