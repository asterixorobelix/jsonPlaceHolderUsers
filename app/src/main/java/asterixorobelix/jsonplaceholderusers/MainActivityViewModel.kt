package asterixorobelix.jsonplaceholderusers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import asterixorobelix.jsonplaceholderusers.api.UsersService
import asterixorobelix.jsonplaceholderusers.models.Address
import asterixorobelix.jsonplaceholderusers.models.Company
import asterixorobelix.jsonplaceholderusers.models.Geo
import asterixorobelix.jsonplaceholderusers.models.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class MainActivityViewModel @Inject constructor(private val usersService: UsersService): ViewModel() {

    val users: LiveData<List<User>?>
        get() = _users

    private val _users: MutableLiveData<List<User>?> = MutableLiveData()

    val userEmail: MutableLiveData<String?> = MutableLiveData()

    fun getUsers() {
        _users.value = null
        GlobalScope.launch {
            try{
                val response = Repository(usersService).getUsers()
                if(response.isSuccessful){
                    //marshal back to main thread
                    _users.postValue(response.body())
                    userEmail.postValue(response.body()?.find { user -> user.username == USERNAME }?.email)
                }
            }
            //handle no internet connection
            catch (ex: Exception){

            }

        }
    }
    companion object{
        const val USERNAME = "Samantha"
    }
}