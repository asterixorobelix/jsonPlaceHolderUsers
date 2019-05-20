package asterixorobelix.jsonplaceholderusers.di

import android.app.Application
import asterixorobelix.jsonplaceholderusers.App
import asterixorobelix.jsonplaceholderusers.Repository
import asterixorobelix.jsonplaceholderusers.api.UsersService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule{

    @Provides
    @Singleton
    fun provideUsersService(): UsersService= Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
        GsonConverterFactory.create()).build().create(UsersService::class.java)

    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }
}