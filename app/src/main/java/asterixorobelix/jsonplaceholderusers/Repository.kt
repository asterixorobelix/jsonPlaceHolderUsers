package asterixorobelix.jsonplaceholderusers

import asterixorobelix.jsonplaceholderusers.api.UsersService
import asterixorobelix.jsonplaceholderusers.models.User
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class Repository @Inject constructor(private val usersService: UsersService) {

    fun getUsers(): Response<List<User>?> {
        return usersService.getUsers().execute()
    }

}