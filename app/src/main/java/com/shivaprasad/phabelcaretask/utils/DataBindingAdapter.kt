package com.shivaprasad.phabelcaretask.utils

import android.app.Activity
import android.opengl.Visibility
import android.view.View
import android.widget.ImageView
import android.widget.SearchView
import androidx.databinding.BindingAdapter

@BindingAdapter("visibility")
fun setVisibility(view: View, visibility: Boolean){

    if(visibility){
        view.visibility = View.VISIBLE

    }else{
        view.visibility = View.GONE

    }
}


