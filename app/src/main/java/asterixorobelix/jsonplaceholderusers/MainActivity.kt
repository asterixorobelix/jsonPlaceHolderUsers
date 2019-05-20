package asterixorobelix.jsonplaceholderusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import asterixorobelix.jsonplaceholderusers.databinding.ActivityMainBinding
import asterixorobelix.jsonplaceholderusers.fragments.user.UserFragment
import asterixorobelix.jsonplaceholderusers.models.User
import asterixorobelix.jsonplaceholderusers.users.UsersFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        //todo remove hardcoded viewmodel ref
        mainActivityViewModel = MainActivityViewModel()

        viewBinding.apply {
            usersButton.setOnClickListener {
                if (isConnectedToInternet(applicationContext) && !mainActivityViewModel.users.value.isNullOrEmpty()) {
                    if(mainActivityViewModel.users.value!=null){
                        val usersNames1 = mutableListOf<String>()
                        for(user in mainActivityViewModel.users.value as List<User>){
                            usersNames1.add(user.name)
                        }
                        UsersFragment(usersNames1.toTypedArray()).showNow(supportFragmentManager, USERS_TAG)
                    }
                } else {
                    makeNoInternetConnectionToast(applicationContext, getString(R.string.no_internet))
                }
            }

            userButton.setOnClickListener {
                if (mainActivityViewModel.userEmail.value != null) {
                    UserFragment(mainActivityViewModel.userEmail.value!!).showNow(
                        supportFragmentManager,
                        USER_EMAIL_TAG
                    )
                } else {
                    makeToast(applicationContext, getString(R.string.no_email_samantha))
                }
            }
        }

        mainActivityViewModel.users.observe(this, Observer {
            if (it.isNullOrEmpty()) {
                viewBinding.apply {
                    userButton.isEnabled = false
                    usersButton.isEnabled = false
                    progressBar.visibility = View.VISIBLE
                }
            }
            else{
                viewBinding.apply {
                    progressBar.visibility = View.GONE
                    userButton.isEnabled = true
                    usersButton.isEnabled = true
                }
            }
        })
    }

    companion object {
        const val USER_EMAIL_TAG = "user email"
        const val USERS_TAG = "users"
    }
}
