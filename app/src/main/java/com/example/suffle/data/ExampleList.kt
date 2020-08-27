package com.example.suffle.data

data class ExampleList(
    val profilename: String,
    val placename: String,
    val ratingnum: String,
    val content: String,
    val profileimage: Int,
    val recycler: ArrayList<ExampleSubList>
)