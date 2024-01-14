package org.mobilenativefoundation.store.news.shared.lib.httpClient

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.apache5.Apache5


actual fun httpClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(Apache5) {
    engine {
        followRedirects = true
        socketTimeout = 10_000
        connectTimeout = 10_000
        connectionRequestTimeout = 20_000
    }
}