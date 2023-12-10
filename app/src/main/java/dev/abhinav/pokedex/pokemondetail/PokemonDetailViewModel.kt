package dev.abhinav.pokedex.pokemondetail

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.abhinav.pokedex.data.models.PokedexListEntry
import dev.abhinav.pokedex.data.remote.response.Pokemon
import dev.abhinav.pokedex.repository.PokemonRepository
import dev.abhinav.pokedex.util.Constants.PAGE_SIZE
import dev.abhinav.pokedex.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    var pokemonList = mutableStateOf<List<PokedexListEntry>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)

    suspend fun getPokemonInfo(name: String): Resource<Pokemon> {
        return repository.getPokemonInfo(name)
    }
}