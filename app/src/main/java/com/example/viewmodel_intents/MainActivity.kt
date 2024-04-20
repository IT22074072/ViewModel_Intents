package com.example.viewmodel_intents

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel_intents.viewmodel.MainActivityData

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textView:TextView = findViewById(R.id.textView)
        val button:Button = findViewById(R.id.button)
        val viewModel = ViewModelProvider(this)[MainActivityData::class.java]

        textView.text = viewModel.count.value.toString()

        button.setOnClickListener{
            viewModel.increment()
        }

        viewModel.count.observe(this){
            textView.text = it.toString()
        }

    }
}