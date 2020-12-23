package com.alexlearn.foodforce.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alexlearn.foodforce.models.FoodRecipe
import com.alexlearn.foodforce.util.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
    var FoodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}