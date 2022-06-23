package com.pulkitjndl.naviSample.di

import com.pulkitjndl.naviSample.model.PullRequestService
import com.pulkitjndl.naviSample.viewmodel.PullRequestViewModel
import dagger.Component



@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: PullRequestService)

    fun inject(viewModel: PullRequestViewModel)
}