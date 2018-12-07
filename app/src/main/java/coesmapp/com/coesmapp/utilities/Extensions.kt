package coesmapp.com.coesmapp.utilities

import android.app.Activity
import android.widget.ArrayAdapter
import android.widget.Spinner


/**
 * Determined options Spinner Extension Function
 *
 * @param context
 * @param stringResource
 * @param layout
 */
fun Spinner.displaySpinner(
    context: Activity,
    stringResource: Int,
    layout: Int = android.R.layout.simple_spinner_dropdown_item
) {

    ArrayAdapter.createFromResource(
        context,
        stringResource,
        layout
    )
        .also { adapter ->
            adapter.setDropDownViewResource(layout)
            this.adapter = adapter
        }

}