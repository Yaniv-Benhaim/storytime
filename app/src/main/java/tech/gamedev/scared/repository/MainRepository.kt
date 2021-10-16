package tech.gamedev.scared.repository

import tech.gamedev.scared.data.db.FirebaseDatabase
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase
){

    fun getAllStories() = firebaseDatabase.getStoryList()

}