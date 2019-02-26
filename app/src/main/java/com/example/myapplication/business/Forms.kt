package com.example.myapplication.business

data class Forms(
    val IsSuccess: Boolean,
    val Message: String,
    val Result: List<Result>
)