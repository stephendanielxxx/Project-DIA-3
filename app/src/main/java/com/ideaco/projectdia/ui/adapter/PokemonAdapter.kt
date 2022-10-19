package com.ideaco.projectdia.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ideaco.projectdia.databinding.ItemPokemonBinding
import com.ideaco.projectdia.ui.model.PokemonModel

class PokemonAdapter(private var pokemonList: ArrayList<PokemonModel>): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemPokemonBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        with(holder){
            binding.tvName.text = pokemon.pokemonName
            // show image from asset drawable
//            binding.ivPokemon.setImageResource(pokemon.pokemonImage)
            //show image from remote url
            Glide.with(binding.ivPokemon.context).load(pokemon.pokemonUrl).into(binding.ivPokemon)

        }
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }
}