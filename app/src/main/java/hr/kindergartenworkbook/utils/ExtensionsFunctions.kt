package hr.kindergartenworkbook.utils

import android.content.Context
import android.content.DialogInterface
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


fun Context.showShortToast(
    message: String
) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
