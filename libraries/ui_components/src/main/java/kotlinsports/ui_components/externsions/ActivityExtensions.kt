package kotlinsports.ui_components.externsions

import android.app.Activity
import android.app.AlertDialog
import android.widget.ProgressBar

fun Activity.createDialog(message: String): AlertDialog {
    return AlertDialog.Builder(this)
        .setMessage(message)
        .setCancelable(false)
        .setPositiveButton(android.R.string.ok) { dialog, _ ->
            dialog.dismiss()
        }
        .show()
}

fun Activity.showMessage(message: String) {
    createDialog(message)
}

fun Activity.createLoadingDialog(isCancelable: Boolean = false): AlertDialog {
    val progressBar = ProgressBar(this).apply {
        isIndeterminate = true
    }
    val dialog = AlertDialog.Builder(this)
        .setView(progressBar)
        .setCancelable(isCancelable)
        .create()
    dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
    dialog.window!!.setLayout(200, 10)
    return dialog
}