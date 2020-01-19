package science.aditya.smsforward

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Telephony
import android.telephony.SmsManager
import android.telephony.SmsMessage
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class SmsBroadcastReceiver : BroadcastReceiver() {

    private val telegramToken:String = "955737806:AAFMH_z61D9aEJCOb268rBAv-nRmZUUsV_k"
    private val chatId:String = "399364613"

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Telephony.Sms.Intents.SMS_RECEIVED_ACTION) {
            var smsBody = ""
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                for (smsMessage in Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                    smsBody += smsMessage.messageBody
                }
            } else {
                val smsBundle = intent.extras
                if (smsBundle != null) {
                    val pdus = smsBundle.get("pdus") as Array<Any>?
                    if (pdus != null) {
                        val messages = arrayOfNulls<SmsMessage>(pdus.size)
                        for (i in messages.indices) {
                            messages[i] = SmsMessage.createFromPdu(pdus[i] as ByteArray)
                            smsBody += messages[i]?.messageBody
                        }
                    }
                }
            }
//            if (smsBody.contains("XX0008")) {
//                sendSMS(context, smsBody)
            sendTelegram(context, smsBody)
//            }
        }
    }

    private fun sendSMS(context: Context, message: String) {
        try {
            val sms = SmsManager.getDefault()
            val mSMSMessage = sms.divideMessage(message)
            sms.sendMultipartTextMessage("+918307517963", null, mSMSMessage, null, null)
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, "SMS sending failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendTelegram(context: Context, message: String) {
        val queue = Volley.newRequestQueue(context)
        val url = "https://api.telegram.org/bot$telegramToken/sendMessage?chat_id=-$chatId&text=$message"
        val request = JsonObjectRequest(url, null, Response.Listener<JSONObject> {}, Response.ErrorListener {})
        queue.add(request)
    }

}