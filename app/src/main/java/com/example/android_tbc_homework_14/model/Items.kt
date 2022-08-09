package com.example.android_tbc_homework_14.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Items(
    val content: List<Content>
) {
    data class Content(
    val id: String,
    val descriptionEN: String,
    val descriptionKA: String,
    val descriptionRU: String,
    val titleEN: String,
    val titleKA: String,
    val titleRU: String,
    val published: Int,
    @SerializedName("publish_date")
    val publishDate: String,
    @SerializedName("created_at")
    val createdAt: Long,
    @SerializedName("updated_at")
    val updatedAt: Long,
    val category: String,
    val cover: String,
    val isLast: Boolean
    )
}