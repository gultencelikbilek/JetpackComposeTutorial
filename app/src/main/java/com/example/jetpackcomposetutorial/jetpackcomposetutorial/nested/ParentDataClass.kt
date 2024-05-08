package com.example.jetpackcomposetutorial.jetpackcomposetutorial.nested

data class ParentDataClass(
    val title : String,
    val childDataClass: List<ChildDataClass>
)
