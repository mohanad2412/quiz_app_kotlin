package com.example.bank

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var spinner: Spinner
    lateinit var resultView: TextView
    lateinit var questionView: TextView
    lateinit var question:TextView
    lateinit var nextButton:Button
//    val country= arrayOf("egypt","usa","uk","france")
//    val city= arrayOf("cairo","ws","london","paris")
    val items= mutableListOf<String>("please select","cairo","ws","london","dubai","tunis","paris")
    val questions= arrayOf(
        Questions("egypt","cairo"),
        Questions("usa","ws"),
        Questions("france","paris"),
        Questions("uk","london")
    )
    var score=0
    var index=0
    var scoreList= mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        question=findViewById(R.id.question)
        spinner=findViewById(R.id.spinner)
        nextButton=findViewById(R.id.nextButton)
        resultView=findViewById(R.id.resultView)
        questionView=findViewById(R.id.questionView)

        val a=intent.getStringExtra("name")
        questionView.setText("Hello $a")

        score=0
        index=0
        questions.shuffle()
        question.setText("what is the captial of ${questions[index].country}")
        items.clear()
        items.addAll(listOf("please select","cairo","ws","london","dubai","tunis","paris"))




        val b=ArrayAdapter(this,android.R.layout.simple_list_item_1,items)
        spinner.adapter=b

    }

    fun next(view: View) {

        val input=spinner.selectedItem.toString()
        if (input=="please select") {
            Toast.makeText(this,"please enter value",Toast.LENGTH_LONG).show()
            return
        }
            if (input==questions[index].city){
            score++
            items.remove(input)
            scoreList.add(score)
        }
//        if (input.isEmpty()) {
//            Toast.makeText(this,"please enter value",Toast.LENGTH_LONG).show()
//        }
        index++
        if (index < questions.size) {
            question.setText("what is the captial of ${questions[index].country}")

        } else {
            scoreList.add(score)
            val a =Intent(this,MainActivity2::class.java)
            a.putExtra("score",score)
            setResult(RESULT_OK,a)
            finish()
        }
        spinner.setSelection(0)
        items.subList(1,items.size).shuffle()
    }
}