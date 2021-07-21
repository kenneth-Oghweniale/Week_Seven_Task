package com.kenneth.week_seven_task

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ItemService {
    @GET("/items")
    suspend fun getAllItems(): List<Item>

    @POST("students")
    suspend fun addStudents(@Body newStudent: Student): List<Student>
}