package com.example.myapplication.business

data class Field(
    val Answer: Any,
    val Description: Any,
    val FieldsOptions: List<FieldsOptions?>,
    val Id: Int,
    val Name: String,
    val Section: Any,
    val Type: String
)