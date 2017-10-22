package com.example.trungnguyen.tancangproject.base

import android.app.Application

/**
 * Author : Trung Nguyen
 * Date : 10/22/2017
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        @get:Synchronized
        var instance: App? = null
            private set
    }
}
