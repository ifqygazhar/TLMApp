package com.example.submissionandroidexpert.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val thumb: String,
    val author: String,
    val tag: String,
    val time: String,
    val title: String,
    val key: String,
    val desc: String,
    val isFavorite: Boolean,
) : Parcelable