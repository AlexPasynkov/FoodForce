package com.alexlearn.foodforce.data

import com.alexlearn.foodforce.data.database.RecipesDao
import com.alexlearn.foodforce.data.database.entities.FavoritesEntity
import com.alexlearn.foodforce.data.database.entities.FoodJokeEntity
import com.alexlearn.foodforce.data.database.entities.RecipesEntity
import com.alexlearn.foodforce.models.FoodJoke
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val recipesDao: RecipesDao
){

    fun readRecipes(): Flow<List<RecipesEntity>> {
        return recipesDao.readRecipes()
    }

    fun readFavoriteRecipes(): Flow<List<FavoritesEntity>>{
        return recipesDao.readFavoriteRecipes()
    }

    fun readFoodJoke(): Flow<List<FoodJokeEntity>>{
        return recipesDao.readFoodJoke()
    }

    suspend fun insertRecipes(recipesEntity: RecipesEntity){
        recipesDao.insertRecipes(recipesEntity)
    }

    suspend fun insertFavoriteRecipes(favoritesEntity: FavoritesEntity){
        recipesDao.insertFavoriteRecipe(favoritesEntity)
    }

    suspend fun insertFoodJoke(foodJokeEntity: FoodJokeEntity){
        recipesDao.insertFoodJoke(foodJokeEntity)
    }

    suspend fun deleteFavoriteRecipe(favoritesEntity: FavoritesEntity){
        recipesDao.deleteFavoriteRecipe(favoritesEntity)
    }

    suspend fun deleteAllFavoriteRecipes(){
        recipesDao.deleteAllFavoriteRecipes()
    }
}