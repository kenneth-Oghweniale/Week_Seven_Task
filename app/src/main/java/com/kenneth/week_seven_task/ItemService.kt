package com.kenneth.week_seven_task

import retrofit2.Response
import retrofit2.http.GET

interface ItemService {
    @GET("/items")
    suspend fun getAllItems(): List<Item>
}