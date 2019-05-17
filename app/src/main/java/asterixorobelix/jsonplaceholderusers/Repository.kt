package asterixorobelix.jsonplaceholderusers

import asterixorobelix.jsonplaceholderusers.api.UsersService
import asterixorobelix.jsonplaceholderusers.models.User
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository() {
    private var retrofit: Retrofit
    private var usersService: UsersService

    init {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        usersService = retrofit.create(UsersService::class.java)
    }

    fun getUsers(): Response<List<User>?> {
        return usersService.getUsers().execute()
    }

    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }
}