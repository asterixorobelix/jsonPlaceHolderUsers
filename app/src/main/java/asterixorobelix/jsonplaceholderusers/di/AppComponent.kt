package asterixorobelix.jsonplaceholderusers.di

import android.app.Application
import asterixorobelix.jsonplaceholderusers.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: App)
}