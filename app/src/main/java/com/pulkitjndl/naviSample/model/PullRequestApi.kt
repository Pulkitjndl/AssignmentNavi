package com.pulkitjndl.naviSample.model

import io.reactivex.Single
import retrofit2.http.GET

interface PullRequestApi {
    // sample - https://github.com/Pulkitjndl/AssignmentNavi/pulls?q=is%3Apr+is%3Aclosed
      @GET("repos/prakashshuklahub/Pull-Request-GithubApi-Demo-App/pulls?state=closed")
    fun getPullRequest(): Single<List<PullRequest>>
}
