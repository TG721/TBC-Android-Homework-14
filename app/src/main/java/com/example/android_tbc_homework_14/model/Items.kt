package com.example.android_tbc_homework_14.model

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
    val titleKa: String,
    val titleRU: String,
    val published: Int,
    val publishDate: String,
    val createdAt: Long,
    val updatedAt: Long,
    val category: String,
    val cover: String,
    val isLast: Boolean
    )
}