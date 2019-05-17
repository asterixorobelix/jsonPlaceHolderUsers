package asterixorobelix.jsonplaceholderusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import asterixorobelix.jsonplaceholderusers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        
        viewBinding.usersButton.setOnClickListener {
            val toast = Toast.makeText(applicationContext, "Clicked!", Toast.LENGTH_LONG)
            toast.show()
        }
    }
}
