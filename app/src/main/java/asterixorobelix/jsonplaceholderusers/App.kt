package asterixorobelix.jsonplaceholderusers

import android.app.Application
import asterixorobelix.jsonplaceholderusers.di.AppComponent
import asterixorobelix.jsonplaceholderusers.di.AppModule
import asterixorobelix.jsonplaceholderusers.di.DaggerAppComponent

class App: Application() {
    val component: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}