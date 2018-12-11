package coesmapp.com.coesmapp.utilities

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import coesmapp.com.coesmapp.R
import android.widget.EditText


object DialogUtil {

    fun createAlertDialogWithTextInputAndTwoButtons(
        context: Context, title: String, message: String,
        positiveButtonText: String,
        positiveListener: DialogInterface.OnClickListener,
        negativeButtonText: String,
        negativeListener: DialogInterface.OnClickListener,
        editTextInput: EditText
    ): AlertDialog {
        return AlertDialog.Builder(context, R.style.AppTheme_Dialog_With_Input) //AppTheme_Dialog
            .setTitle(title)
            .setView(editTextInput)
            .setMessage(message)
            .setPositiveButton(positiveButtonText, positiveListener)
            .setNegativeButton(negativeButtonText, negativeListener)
            .create()
    }

    fun createAlertDialogWithOneButton(
        context: Context,
        title: String,
        message: String,
        positiveListener: DialogInterface.OnClickListener,
        positiveButtonText: String
    ): AlertDialog {
        return AlertDialog.Builder(context, R.style.AppTheme_Dialog)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(positiveButtonText, positiveListener)
            .setCancelable(false)
            .create()
    }
}