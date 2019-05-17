package asterixorobelix.jsonplaceholderusers

import android.content.Context
import android.content.res.Resources
import android.net.ConnectivityManager
import android.widget.Toast

fun makeToast(context: Context, textToDisplay: String){
    val toast = Toast.makeText(context, textToDisplay, Toast.LENGTH_LONG)
    toast.show()
}

fun makeNoInternetConnectionToast(context: Context){
    makeToast(context,Resources.getSystem().getString(R.string.no_internet))
}

fun isConnectedToInternet(context: Context?): Boolean {
    val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnected
}