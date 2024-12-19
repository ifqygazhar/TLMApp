package com.example.submissionandroidexpert.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DetailResponse(

	@field:SerializedName("method")
	val method: String,

	@field:SerializedName("results")
	val results: Results,

	@field:SerializedName("status")
	val status: Boolean
)

data class Results(

	@field:SerializedName("date")
	val date: String,

	@field:SerializedName("figure")
	val figure: List<Any>,

	@field:SerializedName("author")
	val author: String,

	@field:SerializedName("categories")
	val categories: List<String>,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("content")
	val content: List<String>
)
