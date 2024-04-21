package com.example.viewmodel_intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val main: Button = findViewById(R.id.button4)
        val call: Button = findViewById(R.id.button3)
        val sms: Button = findViewById(R.id.button2)
        val webBrowser: Button = findViewById(R.id.button5)
        val email: Button = findViewById(R.id.button6)



        main.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        call.setOnClickListener {
            val number = "+94701422633"
            val uri = Uri.parse(String.format("tel:$number"))
            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = uri
            startActivity(intent)
        }

        sms.setOnClickListener {
            val number = "94701422633"
            val smsText = "Welcome, Dinithi!"
            val uri = Uri.parse(String.format("smsto:$number"))
            val intent = Intent()
            intent.action = Intent.ACTION_SENDTO
            intent.data = uri
            intent.putExtra("sms_body", smsText)
            startActivity(intent)
        }

        webBrowser.setOnClickListener {
            val url = "https://www.sliit.lk/"
            val uri = Uri.parse(url)
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = uri
            startActivity(intent)

        }

        email.setOnClickListener {
            val mailTo = arrayOf("abc@email.com")
            val subject = "Test mail"
            val mailBody = "This is the test email body"

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL, mailTo)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, mailBody)
            startActivity(intent)

        }


    }
}