package asterixorobelix.jsonplaceholderusers.api

import asterixorobelix.jsonplaceholderusers.models.User
import retrofit2.Call
import retrofit2.http.GET

interface UsersService {
    @GET("/users")
    fun getUsers(): Call<List<User>>
}