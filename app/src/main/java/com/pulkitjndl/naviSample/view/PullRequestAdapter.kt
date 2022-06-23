package com.pulkitjndl.naviSample.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pulkitjndl.naviSample.databinding.ItemListBinding
import com.pulkitjndl.naviSample.model.PullRequest
import com.pulkitjndl.naviSample.util.getProgressDrawable
import com.pulkitjndl.naviSample.util.loadImage

class PullRequestAdapter(var pullRequest: ArrayList<PullRequest>) : RecyclerView.Adapter<PullRequestAdapter.PullListRequestViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updatePullRequestList(newPullRequest: List<PullRequest>) {
        pullRequest.clear()
        pullRequest.addAll(newPullRequest)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PullListRequestViewHolder {
        val view = ItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PullListRequestViewHolder(view)
    }

    override fun getItemCount() = pullRequest.size

    override fun onBindViewHolder(holder: PullListRequestViewHolder, position: Int) {
        holder.bind(pullRequest[position])
    }

    class PullListRequestViewHolder(view: ItemListBinding) : RecyclerView.ViewHolder(view.root) {

        private val title = view.title
        private val created_date = view.createdDate
        private val closed_date = view.closedDate
        private val imageView = view.imageView
        private val username = view.user

        fun bind(pullRequest: PullRequest) {
            title.text = pullRequest.title
            created_date.text = pullRequest.created_date
            closed_date.text = pullRequest.closed_date
            username.text = pullRequest.user.name
            imageView.loadImage(pullRequest.user.avatar_url, getProgressDrawable(imageView.context))
        }
    }
}