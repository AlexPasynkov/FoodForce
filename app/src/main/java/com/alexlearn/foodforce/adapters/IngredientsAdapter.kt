package com.alexlearn.foodforce.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.alexlearn.foodforce.R
import com.alexlearn.foodforce.databinding.IngredientsRowLayoutBinding
import com.alexlearn.foodforce.models.ExtendedIngredient
import com.alexlearn.foodforce.util.Constants.Companion.BASE_IMAGE_URL
import com.alexlearn.foodforce.util.RecipesDiffUtil


class IngredientsAdapter: RecyclerView.Adapter<IngredientsAdapter.MyViewHolder>() {

    private var ingredientsList = emptyList<ExtendedIngredient>()

    class MyViewHolder(val binding: IngredientsRowLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(IngredientsRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.binding.ingredientImageView.load(BASE_IMAGE_URL + ingredientsList[position].image){
           crossfade(600)
           error(R.drawable.ic_error_placeholder)
       }
        holder.binding.ingredientName.text = ingredientsList[position].name.capitalize()
        holder.binding.ingredientAmount.text = ingredientsList[position].amount.toString()
        holder.binding.ingredientUnit.text = ingredientsList[position].unit
        holder.binding.ingredientConsistency.text = ingredientsList[position].consistency
        holder.binding.ingredientOriginal.text = ingredientsList[position].original
    }

    override fun getItemCount(): Int {
       return ingredientsList.size
    }

    fun setData(newIngredients: List<ExtendedIngredient>){
        val ingredientsDiffUtil =
            RecipesDiffUtil(ingredientsList, newIngredients)
        val diffUtilResult = DiffUtil.calculateDiff(ingredientsDiffUtil)
        ingredientsList = newIngredients
        diffUtilResult.dispatchUpdatesTo(this)
    }
}