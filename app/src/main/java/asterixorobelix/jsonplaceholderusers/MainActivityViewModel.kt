package asterixorobelix.jsonplaceholderusers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import asterixorobelix.jsonplaceholderusers.models.Address
import asterixorobelix.jsonplaceholderusers.models.Company
import asterixorobelix.jsonplaceholderusers.models.Geo
import asterixorobelix.jsonplaceholderusers.models.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class MainActivityViewModel: ViewModel() {

    val users: LiveData<List<User>?>
        get() = _users

    private val _users: MutableLiveData<List<User>?> = MutableLiveData()

    val userEmail: MutableLiveData<String?> = MutableLiveData()

    init {
        _users.value = null
        GlobalScope.launch {
            try{
                val response = Repository().getUsers()
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