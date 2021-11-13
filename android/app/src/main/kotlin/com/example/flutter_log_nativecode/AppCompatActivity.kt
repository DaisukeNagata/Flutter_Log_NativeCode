package com.example.flutter_log_nativecode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class AppCompatActivity : AppCompatActivity() {

    private var textTitle: TextView? = null
    private var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.appcompat_activity)

        textTitle = findViewById(R.id.tvName)
        button = findViewById(R.id.pushListener)
        button?.setOnClickListener(PusListener())
    }

    private inner class PusListener : View.OnClickListener {
        override fun onClick(v: View?) {
            textTitle?.text = "Log count" + (0..10).random().toString()
        }
    }

}