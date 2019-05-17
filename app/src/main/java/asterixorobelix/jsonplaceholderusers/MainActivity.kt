package asterixorobelix.jsonplaceholderusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import asterixorobelix.jsonplaceholderusers.databinding.ActivityMainBinding
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

                } else {
                    makeNoInternetConnectionToast(applicationContext)
                }
            }
        }
    }
}
