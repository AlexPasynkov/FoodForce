package com.alexlearn.foodforce.databinding

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.alexlearn.foodforce.data.database.entities.RecipesEntity
import com.alexlearn.foodforce.models.FoodRecipe
import com.alexlearn.foodforce.util.NetworkResult

class RecipesBinding {

    companion object {


        @BindingAdapter("readApiResponse", "readDatabase", requireAll = true)
        @JvmStatic
        fun errorImageViewVisibility(
                imageView: ImageView,
                apiResponse: NetworkResult<FoodRecipe?>?,
                dataBase: List<RecipesEntity>?
        ){
            if(apiResponse is NetworkResult.Error && dataBase.isNullOrEmpty()){
                imageView.visibility = View.VISIBLE
            } else if (apiResponse is NetworkResult.Loading){
                imageView.visibility = View.INVISIBLE
            } else if (apiResponse is NetworkResult.Success){
                imageView.visibility = View.INVISIBLE
            }
        }


        @BindingAdapter("readApiResponse2", "readDatabase2", requireAll = true)
        @JvmStatic
        fun errorTextViewVisibility(
                textView: TextView,
                apiResponse: NetworkResult<FoodRecipe>?,
                dataBase: List<RecipesEntity>?
        ){
            if(apiResponse is NetworkResult.Error && dataBase.isNullOrEmpty()){
                textView.visibility = View.VISIBLE
                textView.text = apiResponse.message.toString()
            } else if (apiResponse is NetworkResult.Loading){
                textView.visibility = View.INVISIBLE
            } else if (apiResponse is NetworkResult.Success){
                textView.visibility = View.INVISIBLE
            }
        }
    }
}