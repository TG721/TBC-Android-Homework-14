package com.example.android_tbc_homework_14.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_tbc_homework_14.R
import com.example.android_tbc_homework_14.databinding.MainItemBinding
import com.example.android_tbc_homework_14.model.Items

class MyAdapter: ListAdapter<Items.Content ,MyAdapter.MyViewHolder>(ItemCallback()){
    private var myList = emptyList<Items.Content>()
    inner class MyViewHolder(val binding: MainItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int) {
          Glide.with(binding.imageViewMain)
              .load(currentList[position].cover)
              .into(binding.imageViewMain)
            binding.textViewTitleMain.text = currentList[position].titleEN
            binding.textViewPublishDate.text = currentList[position].publishDate
            binding.textViewDescrption.text = currentList[position].descriptionEN
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            MainItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

private class ItemCallback: DiffUtil.ItemCallback<Items.Content>() {
    override fun areItemsTheSame(oldItem: Items.Content, newItem: Items.Content): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Items.Content, newItem: Items.Content): Boolean {
        return oldItem == newItem
    }

}



}