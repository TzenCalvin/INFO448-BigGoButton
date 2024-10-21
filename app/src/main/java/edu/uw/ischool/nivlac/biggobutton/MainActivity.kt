package edu.uw.ischool.nivlac.biggobutton

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

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

        val button = findViewById<Button>(R.id.bigButton)
        var clicked: Int = 0

        button.setOnClickListener {
            clicked++
            button.setText(when(clicked){
                1 -> "@string/pushed_me_once"
                else -> "You have pushed me $clicked times!"
            })

            button.setBackgroundColor(Color.rgb(Random.nextInt(255), Random.nextInt(255),
                Random.nextInt(255)))
            button.setTextColor(Color.rgb(Random.nextInt(255), Random.nextInt(255),
                Random.nextInt(255)))
        }

    }
}