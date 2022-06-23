package com.pulkitjndl.naviSample.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pulkitjndl.naviSample.viewmodel.PullRequestViewModel
import com.pulkitjndl.naviSample.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit  var viewModel: PullRequestViewModel

    private val pullRequestAdapter = PullRequestAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(PullRequestViewModel::class.java)

        viewModel.refresh()

        recyclerList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = pullRequestAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
        observeViewModel()

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            viewModel.refresh()
        }
    }

    private fun observeViewModel(){
        viewModel.pullRequestList.observe(this, Observer { pullRequestList->
            pullRequestList?.let {
                recyclerList.visibility = View.VISIBLE
                pullRequestAdapter.updatePullRequestList(it)
            }
        })

        viewModel.pullRequestLoadError.observe(this, Observer { isError ->
            isError?.let { list_error.visibility = if(it) View.VISIBLE else View.GONE }
        })

        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                loading_view.visibility = if(it) View.VISIBLE else View.GONE
                if(it) {
                    list_error.visibility = View.GONE
                    recyclerList.visibility = View.GONE
                }
            }
        })
    }
}