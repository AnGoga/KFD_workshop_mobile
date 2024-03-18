package com.angoga.kfd_workshop_mobile.ui.screens.home

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.angoga.kfd_workshop_mobile.R
import com.angoga.kfd_workshop_mobile.databinding.ItemPublicationBinding
import com.angoga.kfd_workshop_mobile.remote.model.response.PublicationResponse
import com.angoga.kfd_workshop_mobile.ui.screens.create_news.PublicationViewModel

class NewsAdapter(
    private val viewModel: PublicationViewModel
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    private val list = mutableListOf<PublicationResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_publication, parent, false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.update(list[position])
    }

    override fun getItemCount(): Int = list.size


    fun addNewPublication(data: PublicationResponse) {
        list.add(data)
        notifyItemInserted(list.size - 1)
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding by lazy { ItemPublicationBinding.bind(itemView) }

        fun update(data: PublicationResponse) {
            binding.textViewTitle.text = data.title
            binding.textViewContent.text = data.content
            if (data.isLiked) {
                binding.imageLike.setImageResource(R.mipmap.ic_like_active)
            } else {
                binding.imageLike.setImageResource(R.mipmap.ic_like_inactive)
            }
        }
    }
}