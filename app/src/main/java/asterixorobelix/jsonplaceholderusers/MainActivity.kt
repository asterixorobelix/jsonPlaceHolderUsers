package asterixorobelix.jsonplaceholderusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import asterixorobelix.jsonplaceholderusers.databinding.ActivityMainBinding
import asterixorobelix.jsonplaceholderusers.fragments.user.UserFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        viewBinding.apply {
            usersButton.setOnClickListener {
                if (isConnectedToInternet(applicationContext)) {

                } else {
                    makeNoInternetConnectionToast(applicationContext)
                }
            }

            userButton.setOnClickListener {
                if (isConnectedToInternet(applicationContext)) {
                    //todo remove hardcoded email
                    UserFragment("samanthaemail@email.com").showNow(supportFragmentManager,USER_EMAIL_TAG)
                } else {
                    makeNoInternetConnectionToast(applicationContext)
                }
            }
        }
    }

    companion object{
        const val USER_EMAIL_TAG = "user email"
        const val USERS_TAG = "users"
    }
}
