package com.ideaco.projectdia.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ideaco.projectdia.databinding.ActivityRandomAnimalsBinding
import com.ideaco.projectdia.ui.adapter.AnimalAdapter
import com.ideaco.projectdia.ui.model.AnimalResponse
import com.ideaco.projectdia.ui.viewmodel.RandomAnimalsViewModel
import com.ideaco.projectdia.utils.ResponseStatus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RandomAnimalsActivity : AppCompatActivity(), AnimalAdapter.AnimalSelectedCallback {
    private lateinit var binding: ActivityRandomAnimalsBinding
    private lateinit var adapter: AnimalAdapter
    private val viewModel: RandomAnimalsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomAnimalsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvAnimals.layoutManager = LinearLayoutManager(this@RandomAnimalsActivity)

        viewModel.getRandomAnimals(10)

        setObserver()
    }

    private fun setObserver() {
        viewModel.getRandomAnimalsLiveData().observe(this, Observer {
            if (it.isNotEmpty()) {
                adapter = AnimalAdapter(it, this)
                binding.rvAnimals.adapter = adapter
            } else {
                Toast.makeText(
                    this@RandomAnimalsActivity, "Empty Data",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        viewModel.getInsertAnimalIveData().observe(this) {
            when (it.status) {
                ResponseStatus.SUCCESS -> {
                    Toast.makeText(
                        this@RandomAnimalsActivity, "Success insert data",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                ResponseStatus.ERROR -> {
                    Toast.makeText(
                        this@RandomAnimalsActivity, it.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {}
            }
        }
    }

    override fun onAnimalSelected(animalResponse: AnimalResponse) {
        viewModel.insertAnimal(animalResponse)
    }
}