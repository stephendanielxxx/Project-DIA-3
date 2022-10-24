package com.ideaco.projectdia.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ideaco.projectdia.databinding.ItemAnimalBinding
import com.ideaco.projectdia.ui.model.AnimalResponse

class AnimalAdapter(
    private var animalModels: List<AnimalResponse>,
    private val animalSelectedCallback: AnimalSelectedCallback
    ):
    RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {
    inner class ViewHolder(var binding: ItemAnimalBinding): RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener{
                animalSelectedCallback.onAnimalSelected(animalModels[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAnimalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animalModel = animalModels[position]
        with(holder){
            Glide.with(binding.ivAnimal.context).load(animalModel.imageLink).into(binding.ivAnimal)
            binding.tvName.text = animalModel.name
        }
    }

    override fun getItemCount(): Int {
        return animalModels.size
    }

    interface AnimalSelectedCallback{
        fun onAnimalSelected(animalResponse: AnimalResponse)
    }
}