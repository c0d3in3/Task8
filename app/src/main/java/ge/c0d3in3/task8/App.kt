package ge.c0d3in3.task8

import android.app.Application
import ge.c0d3in3.task8.api.RetrofitClient

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        RetrofitClient.initClient()
    }

}