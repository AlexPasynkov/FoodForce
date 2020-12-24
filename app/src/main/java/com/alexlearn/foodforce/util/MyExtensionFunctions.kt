package com.alexlearn.foodforce.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


// Позволяет при первом запуске программы не считатывать информацию из базы данных, а только записывать
fun <T> LiveData<T>.observeOnce(lifecycleOwner: LifecycleOwner, observer: Observer<T>){
    observe(lifecycleOwner, object : Observer<T>{
      override fun onChanged(t: T?){
          removeObserver(this)
          observer.onChanged(t)
      }
    })
}