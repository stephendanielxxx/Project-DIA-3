package com.ideaco.projectdia.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.ideaco.projectdia.databinding.ActivityRandomAnimalBinding
import com.ideaco.projectdia.ui.viewmodel.RandomAnimalViewModel

class RandomAnimalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRandomAnimalBinding
    private val viewModel: RandomAnimalViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomAnimalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getRandomAnimal()

        setObserver()
    }

    private fun setObserver() {
        viewModel.getRandomAnimalLiveData().observe(this, Observer {
            // show animal image to image view
            Glide.with(this@RandomAnimalActivity).load(it.imageLink).into(binding.ivAnimal)

            binding.tvName.text = it.name
            binding.tvLatinName.text = "Latin Name = ${it.latinName}"
            binding.tvAnimalType.text = "Animal Type = ${it.animalType}"
            binding.tvHabitat.text = "Habitat = ${it.habitat}"
        })
    }
}