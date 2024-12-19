package com.example.submissionandroidexpert.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GameResponse(

	@field:SerializedName("GameResponse")
	val gameResponse: List<GameResponseItem>
)

data class GameResponseItem(

	@field:SerializedName("thumb")
	val thumb: String,

	@field:SerializedName("author")
	val author: String,

	@field:SerializedName("tag")
	val tag: String,

	@field:SerializedName("time")
	val time: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("key")
	val key: String,

	@field:SerializedName("desc")
	val desc: String
)
