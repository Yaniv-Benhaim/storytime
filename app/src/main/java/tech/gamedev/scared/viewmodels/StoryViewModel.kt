package tech.gamedev.scared.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import tech.gamedev.scared.data.models.Story
import tech.gamedev.scared.repository.MainRepository
import javax.inject.Inject

@HiltViewModel
class StoryViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _stories = MutableLiveData<ArrayList<Story>>()
    val stories: LiveData<ArrayList<Story>> = _stories
    val currentStory = mutableStateOf(Story("", "", "", "", "Sorry, can't load this story at the moment. \n Please try again later"))

    init {
        getAllStories()
    }

    private fun getAllStories() = viewModelScope.launch {


        _stories.value = ArrayList()
        mainRepository.getAllStories().addOnCompleteListener {

            if(it.isSuccessful) {
                for (document in it.result!!){
                    val story = document.toObject(Story::class.java)
                    _stories.value!!.add(story)
                }
            }

        }
    }

    fun setCurrentStory(story: Story) {
        currentStory.value = story
    }
}