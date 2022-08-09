package com.example.android_tbc_homework_14.adapter

import android.text.InputType
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_tbc_homework_14.databinding.MainItemBinding
import com.example.android_tbc_homework_14.model.Items

class ItemsListAdapter: ListAdapter<Items.Content, ItemsListAdapter.ItemVewHolder>(ItemDiffCallback()) {

    inner class ItemVewHolder(private val binding: MainItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
        val source = getItem(absoluteAdapterPosition)
            binding.apply {
                Glide.with(this.imageViewMain)
                    .load(source.cover)
                    .into(imageViewMain)
                textViewPublishDate.text = source.publishDate
                textViewDescrption.text = source.descriptionKA
                textViewTitleMain.text = source.titleKA

            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVewHolder {
        return ItemVewHolder(
            MainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemsListAdapter.ItemVewHolder, position: Int) {
        holder.bind()
    }
}

  private class ItemDiffCallback : DiffUtil.ItemCallback<Items.Content>() {
        override fun areItemsTheSame(oldItem: Items.Content, newItem: Items.Content): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Items.Content, newItem: Items.Content): Boolean =
            oldItem == newItem

    }
