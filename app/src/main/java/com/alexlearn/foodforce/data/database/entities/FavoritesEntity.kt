package com.alexlearn.foodforce.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alexlearn.foodforce.models.Result
import com.alexlearn.foodforce.util.Constants.Companion.FAVORITE_RECIPES_TABLE

@Entity(tableName = FAVORITE_RECIPES_TABLE)
class FavoritesEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var result: Result
)