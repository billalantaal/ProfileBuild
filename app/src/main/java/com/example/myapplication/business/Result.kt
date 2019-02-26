package com.example.myapplication.business

data class Result(
    val Description: String,
    val Fields: List<Field>,
    val Id: Int,
    val Name: String,
    val Type: String
)