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
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class MainActivityViewModel: ViewModel() {

    val users: LiveData<List<User>?>
        get() = _users

    private val _users: MutableLiveData<List<User>?> = MutableLiveData()

    val userEmail: MutableLiveData<String?> = MutableLiveData()

    init {
        _users.value = null
        userEmail.value = "samanthaemail@email.com"
        GlobalScope.launch {
            val response = Repository().getUsers()
            if(response.isSuccessful){
                val users =  response.body()
                var aa = _users.value
                aa = users
                _users.postValue(aa)
            }
        }
    }
}