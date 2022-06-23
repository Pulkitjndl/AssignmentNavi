package com.pulkitjndl.naviSample.model

import io.reactivex.Single
import retrofit2.http.GET

interface PullRequestApi {
      @GET("repos/prakashshuklahub/Pull-Request-GithubApi-Demo-App/pulls?state=closed")
    fun getPullRequest(): Single<List<PullRequest>>
}
