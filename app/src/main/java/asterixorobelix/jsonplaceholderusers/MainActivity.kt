package asterixorobelix.jsonplaceholderusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import asterixorobelix.jsonplaceholderusers.databinding.ActivityMainBinding
import asterixorobelix.jsonplaceholderusers.fragments.user.UserFragment
import asterixorobelix.jsonplaceholderusers.models.User
import asterixorobelix.jsonplaceholderusers.users.UsersFragment
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var mainActivityViewModel: MainActivityViewModel
    @Inject
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        viewBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        //todo remove hardcoded viewmodel ref
        mainActivityViewModel = MainActivityViewModel(repository)

        viewBinding.apply {
            usersButton.setOnClickListener {
                if (isConnectedToInternet(applicationContext) && !mainActivityViewModel.users.value.isNullOrEmpty()) {
                    if (mainActivityViewModel.users.value != null) {
                        val usersNamesOnly = mutableListOf<String>()
                        for (user in mainActivityViewModel.users.value as List<User>) {
                            usersNamesOnly.add(user.name)
                        }
                        UsersFragment(usersNamesOnly.toTypedArray()).showNow(supportFragmentManager, USERS_TAG)
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
            viewBinding.apply {
                userButton.isEnabled = !it.isNullOrEmpty()
                usersButton.isEnabled = !it.isNullOrEmpty()
                progressBar.visibility = if (it.isNullOrEmpty()) View.VISIBLE else View.GONE
            }
        })
    }

    companion object {
        const val USER_EMAIL_TAG = "user email"
        const val USERS_TAG = "users"
    }
}
