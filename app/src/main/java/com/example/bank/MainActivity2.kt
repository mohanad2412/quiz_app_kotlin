package com.example.bank

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener

class MainActivity2 : AppCompatActivity() {
    lateinit var nameText: EditText
    lateinit var clickButton: Button
    lateinit var answerView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        nameText = findViewById(R.id.nameText)
        clickButton = findViewById(R.id.clickButton)
        answerView = findViewById(R.id.answerView)

        nameText.addTextChangedListener {
            if (nameText.text.toString().isEmpty()) {
                clickButton.isEnabled = false
            } else {
                clickButton.isEnabled = true
            }
        }
    }
    fun click(view: View) {
        val a = Intent(this, MainActivity::class.java)
        a.putExtra("name", nameText.text.toString())
        startActivityForResult(a,100)
    }
// msh sh3'alaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == 100) {
        val a = data?.getIntExtra("score", 0)
        a?.let {
            Toast.makeText(this, "return with $a", Toast.LENGTH_SHORT).show()
        }
    }
}
}
