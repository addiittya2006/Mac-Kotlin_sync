package science.aditya.smsforward

import android.Manifest.permission.*
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker.PERMISSION_GRANTED

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (!hasSMSPerms())
            showRequestPermsAlertDialog()
    }

    private fun showRequestPermsAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.permission_alert_dialog_title)
        builder.setMessage(R.string.permission_dialog_message)
        builder.setPositiveButton(R.string.action_ok) { dialog, _ ->
            dialog.dismiss()
            requestSmsPerms()
        }
        builder.show()
    }

    private fun hasSMSPerms(): Boolean {
        return ContextCompat.checkSelfPermission(
            this@MainActivity, READ_SMS) == PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(
            this@MainActivity, RECEIVE_SMS) == PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(
            this@MainActivity, SEND_SMS) == PERMISSION_GRANTED
    }

    private fun requestSmsPerms() {
        if (!ActivityCompat.shouldShowRequestPermissionRationale(this@MainActivity, READ_SMS)) {
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(READ_SMS, RECEIVE_SMS, SEND_SMS), 0)
        }
    }

}