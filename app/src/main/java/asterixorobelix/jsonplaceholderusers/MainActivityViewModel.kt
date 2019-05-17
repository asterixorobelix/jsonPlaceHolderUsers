package asterixorobelix.jsonplaceholderusers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import asterixorobelix.jsonplaceholderusers.models.Address
import asterixorobelix.jsonplaceholderusers.models.Company
import asterixorobelix.jsonplaceholderusers.models.Geo
import asterixorobelix.jsonplaceholderusers.models.User

class MainActivityViewModel: ViewModel() {

    val users: LiveData<List<User>?>
        get() = _users

    private val _users: MutableLiveData<List<User>?> = MutableLiveData()

    val userEmail: MutableLiveData<String?> = MutableLiveData()

    init {
        _users.value = null
        userEmail.value = "samanthaemail@email.com"
        _users.value = listOf(User(address = Address("Holy","moly","cape","town",Geo(23.2,35.4)),id = 1,username = "dawg", name = "Holy", company = Company("disney","whatUp?","Holla"),email = "@@email",phone = "phone",website = "www.website.com"))
    }
}