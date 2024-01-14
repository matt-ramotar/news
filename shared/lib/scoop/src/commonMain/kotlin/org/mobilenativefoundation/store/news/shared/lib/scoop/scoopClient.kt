package org.mobilenativefoundation.store.news.shared.lib.scoop

import ai.wandering.scoop.v1.ScoopClient
import org.mobilenativefoundation.store.news.shared.lib.env.Env
import org.mobilenativefoundation.store.news.shared.lib.httpClient.httpClient

fun scoopClient(): ScoopClient {
    val httpClient = httpClient()
    val bearerToken = Env.SCOOP_API_TOKEN
    return ScoopClient(httpClient, bearerToken)
}