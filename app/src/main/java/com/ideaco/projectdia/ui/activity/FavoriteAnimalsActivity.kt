package com.ideaco.projectdia.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ideaco.projectdia.databinding.ActivityFavoriteAnimalsBinding
import com.ideaco.projectdia.ui.adapter.AnimalAdapter
import com.ideaco.projectdia.ui.model.AnimalResponse
import com.ideaco.projectdia.ui.viewmodel.FavoriteAnimalsViewModel
import com.ideaco.projectdia.utils.ResponseStatus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteAnimalsActivity : AppCompatActivity(), AnimalAdapter.AnimalSelectedCallback {
    private lateinit var binding: ActivityFavoriteAnimalsBinding
    private lateinit var adapter: AnimalAdapter
    private val viewModel: FavoriteAnimalsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteAnimalsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvAnimals.layoutManager = LinearLayoutManager(this@FavoriteAnimalsActivity)

        viewModel.getFavoriteAnimals()

        setObserver()
    }

    private fun setObserver() {
        viewModel.getFavoriteAnimalsLiveData().observe(this){
            when(it.status){
                ResponseStatus.SUCCESS -> {
                    it.data?.let { data ->
                        adapter = AnimalAdapter(data, this)
                        binding.rvAnimals.adapter = adapter
                    }

                }
                ResponseStatus.ERROR -> {
                    Toast.makeText(this@FavoriteAnimalsActivity, it.message, Toast.LENGTH_SHORT).show()
                }
                ResponseStatus.LOADING -> {

                }
                ResponseStatus.EMPTY -> {
                    Toast.makeText(this@FavoriteAnimalsActivity, "No data", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onAnimalSelected(animalResponse: AnimalResponse) {

    }
}