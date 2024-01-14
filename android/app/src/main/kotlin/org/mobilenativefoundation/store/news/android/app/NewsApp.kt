package org.mobilenativefoundation.store.news.android.app

import android.app.Application

class NewsApp : Application() {
    val appComponent: AppComponent by lazy {
        AppComponent.create(this)
    }
}