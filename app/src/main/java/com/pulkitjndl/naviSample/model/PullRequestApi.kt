package com.pulkitjndl.naviSample.model

import io.reactivex.Single
import retrofit2.http.GET

interface PullRequestApi {
      @GET("repos/Pulkitjndl/AssignmentNavi/pulls?state=closed")
    fun getPullRequest(): Single<List<PullRequest>>
}
