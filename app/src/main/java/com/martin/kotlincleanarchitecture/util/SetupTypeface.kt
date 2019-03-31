package com.martin.kotlincleanarchitecture.util

import android.content.Context
import android.graphics.Typeface
import android.support.v4.content.res.ResourcesCompat
import com.martin.kotlincleanarchitecture.R

fun setupFont(context: Context): Typeface? {
    var typeFace: Typeface? = ResourcesCompat.getFont(context.applicationContext, R.font.roboto_regular)
return typeFace
}
