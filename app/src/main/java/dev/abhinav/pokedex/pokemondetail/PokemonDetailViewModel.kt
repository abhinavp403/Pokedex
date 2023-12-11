package dev.abhinav.pokedex.pokemondetail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.abhinav.pokedex.data.remote.response.Pokemon
import dev.abhinav.pokedex.repository.PokemonRepository
import dev.abhinav.pokedex.util.Resource
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(name: String): Resource<Pokemon> {
        return repository.getPokemonInfo(name)
    }
}