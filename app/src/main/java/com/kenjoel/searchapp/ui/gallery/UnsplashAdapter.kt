package com.kenjoel.searchapp.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.kenjoel.searchapp.R
import com.kenjoel.searchapp.databinding.ItemUnsplashPhotoBinding
import com.kenjoel.searchapp.unsplash_folder.Unsplash

class UnsplashAdapter: PagingDataAdapter<Unsplash, UnsplashAdapter.PhotoViewholder>(COMPARE_PHOTOS) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewholder {
        val binding = ItemUnsplashPhotoBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return PhotoViewholder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewholder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null){
            holder.bind(currentItem)
        }
    }



    class PhotoViewholder(private val binding: ItemUnsplashPhotoBinding ): RecyclerView.ViewHolder(binding.root){

        fun bind(photo:Unsplash){
            binding.apply {
                Glide.with(itemView)
                    .load(photo.urls.regular)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .apply(RequestOptions().error(R.drawable.ic_baseline_error_24))
                    .into(imagePets)

                textUser.text = photo.user.username
            }
        }

    }

    companion object{
        private val COMPARE_PHOTOS = object : DiffUtil.ItemCallback<Unsplash>(){
            override fun areItemsTheSame(oldItem: Unsplash, newItem: Unsplash) =
                oldItem.id   == newItem.id
            override fun areContentsTheSame(oldItem: Unsplash, newItem: Unsplash) =
                oldItem == newItem
        }
    }

}

