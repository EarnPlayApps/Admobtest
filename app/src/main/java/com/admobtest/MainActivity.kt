package com.admobtest

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val text = TextView(this)
        text.text = "APK BERJAYA DIBUKA"
        text.textSize = 24f
        text.setPadding(40, 100, 40, 40)

        setContentView(text)
    }
}
