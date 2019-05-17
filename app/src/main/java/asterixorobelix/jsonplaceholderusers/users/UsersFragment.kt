package asterixorobelix.jsonplaceholderusers.users

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import asterixorobelix.jsonplaceholderusers.R

class UsersFragment(private val usersNames: Array<CharSequence>) : DialogFragment(){

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setItems(usersNames, null)
            builder.setTitle(getString(R.string.user_names))
                .setPositiveButton(getString(R.string.ok_button_text),
                    DialogInterface.OnClickListener { dialog, id ->
                        //user clicked ok
                    })
                .setNegativeButton(getString(R.string.cancel_button_text),
                    DialogInterface.OnClickListener { dialog, id ->
                        // User cancelled the dialog
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}