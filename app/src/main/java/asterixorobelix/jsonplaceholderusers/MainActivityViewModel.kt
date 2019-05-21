package asterixorobelix.jsonplaceholderusers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import asterixorobelix.jsonplaceholderusers.models.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val users: LiveData<List<User>?>
        get() = _users

    private val _users: MutableLiveData<List<User>?> = MutableLiveData()

    val userEmail: MutableLiveData<String?> = MutableLiveData()

    init {
        getUsers()
    }

    private fun getUsers() {
        _users.value = null
        GlobalScope.launch {
            try {
                val response = repository.getUsers()
                if (response.isSuccessful) {
                    //marshal back to main thread. Posts a task to a main thread to set the given value.
                    _users.postValue(response.body())
                    userEmail.postValue(response.body()?.find { user -> user.username == USERNAME }?.email)
                }
            }
            //handle no internet connection or other problems
            catch (ex: Exception) {

            }

        }
    }

    companion object {
        const val USERNAME = "Samantha"
    }
}