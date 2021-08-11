package com.example.jogodavelha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var indice = 2
    private var score1 = 0
    private var score2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val l1c1: Button = findViewById(R.id.l1c1)
        val l1c2: Button = findViewById(R.id.l1c2)
        val l1c3: Button = findViewById(R.id.l1c3)
        val l2c1: Button = findViewById(R.id.l2c1)
        val l2c2: Button = findViewById(R.id.l2c2)
        val l2c3: Button = findViewById(R.id.l2c3)
        val l3c1: Button = findViewById(R.id.l3c1)
        val l3c2: Button = findViewById(R.id.l3c2)
        val l3c3: Button = findViewById(R.id.l3c3)

        l1c1.setOnClickListener{
            defineSymbol(l1c1)
            winner(l1c1, l1c2, l1c3, l2c1, l2c2, l2c3, l3c1, l3c2, l3c3)
        }
        l1c2.setOnClickListener{
            defineSymbol(l1c2)
            winner(l1c1, l1c2, l1c3, l2c1, l2c2, l2c3, l3c1, l3c2, l3c3)
        }
        l1c3.setOnClickListener{
            defineSymbol(l1c3)
            winner(l1c1, l1c2, l1c3, l2c1, l2c2, l2c3, l3c1, l3c2, l3c3)
        }

        l2c1.setOnClickListener{
            defineSymbol(l2c1)
            winner(l1c1, l1c2, l1c3, l2c1, l2c2, l2c3, l3c1, l3c2, l3c3)
        }
        l2c2.setOnClickListener{
            defineSymbol(l2c2)
            winner(l1c1, l1c2, l1c3, l2c1, l2c2, l2c3, l3c1, l3c2, l3c3)
        }
        l2c3.setOnClickListener{
            defineSymbol(l2c3)
            winner(l1c1, l1c2, l1c3, l2c1, l2c2, l2c3, l3c1, l3c2, l3c3)
        }

        l3c1.setOnClickListener{
            defineSymbol(l3c1)
            winner(l1c1, l1c2, l1c3, l2c1, l2c2, l2c3, l3c1, l3c2, l3c3)
        }
        l3c2.setOnClickListener{
            defineSymbol(l3c2)
            winner(l1c1, l1c2, l1c3, l2c1, l2c2, l2c3, l3c1, l3c2, l3c3)
        }
        l3c3.setOnClickListener{
            defineSymbol(l3c3)
            winner(l1c1, l1c2, l1c3, l2c1, l2c2, l2c3, l3c1, l3c2, l3c3)
        }
    }

    private fun defineSymbol(botao: Button){
        if(indice % 2 == 0){
            botao.text = "X"
        }else {
            botao.text = "O"
        }
        indice++
        botao.isClickable = false
    }

    private fun winner(l1c1: Button, l1c2:Button, l1c3:Button, l2c1:Button, l2c2:Button, l2c3:Button, l3c1:Button, l3c2:Button, l3c3:Button){
        var hasWinner = false

        if(l1c1.text != "" && l1c2.text != "" && l1c3.text != "" && l1c1.text == l1c2.text && l1c1.text == l1c3.text){
            hasWinner = true
        }else if(l2c1.text != "" && l2c2.text != "" && l2c3.text != "" && l2c1.text == l2c2.text && l2c1.text == l2c3.text){
            hasWinner = true
        }else if(l3c1.text != "" && l3c2.text != "" && l3c3.text != "" && l3c1.text == l3c2.text && l3c1.text == l3c3.text){
            hasWinner = true
        }else if(l1c1.text != "" && l2c1.text != "" && l3c1.text != "" && l1c1.text == l2c1.text && l1c1.text == l3c1.text){
            hasWinner = true
        }else if(l1c2.text != "" && l2c2.text != "" && l3c2.text != "" && l1c2.text == l2c2.text && l1c2.text == l3c2.text){
            hasWinner = true
        }else if(l1c3.text != "" && l2c3.text != "" && l3c3.text != "" && l1c3.text == l2c3.text && l1c3.text == l3c3.text){
            hasWinner = true
        }else if(l1c1.text != "" && l2c2.text != "" && l3c3.text != "" && l1c1.text == l2c2.text && l1c1.text == l3c3.text){
            hasWinner = true
        }else if(l1c3.text != "" && l2c2.text != "" && l3c1.text != "" && l1c3.text == l2c2.text && l1c3.text == l3c1.text){
            hasWinner = true
        }else if(l1c1.text != "" && l1c2.text != "" && l1c3.text != "" && l2c1.text != "" && l2c2.text != "" && l2c3.text != "" && l3c1.text != "" && l3c2.text != "" && l3c3.text != ""){
            hasWinner = true
            indice = -1
        }

        if(hasWinner){
            val p1score: TextView = findViewById(R.id.p1score)
            val p2score: TextView = findViewById(R.id.p2score)

            if(indice < 0) {
                Toast.makeText(this, "EMPATE!", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "O PLAYER 1 COMEÇA!", Toast.LENGTH_SHORT).show()
                indice = 2
            }else if(indice % 2 == 0){
                Toast.makeText(this, "PLAYER 2 VENCEU!", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "O PLAYER 2 COMEÇA!", Toast.LENGTH_SHORT).show()
                indice = 3
                score2++
            }else{
                Toast.makeText(this, "PLAYER 1 VENCEU!", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "O PLAYER 1 COMEÇA!", Toast.LENGTH_SHORT).show()
                indice = 2
                score1++
            }

            l1c1.text = ""
            l1c2.text = ""
            l1c3.text = ""
            l2c1.text = ""
            l2c2.text = ""
            l2c3.text = ""
            l3c1.text = ""
            l3c2.text = ""
            l3c3.text = ""

            l1c1.isClickable = true
            l1c2.isClickable = true
            l1c3.isClickable = true
            l2c1.isClickable = true
            l2c2.isClickable = true
            l2c3.isClickable = true
            l3c1.isClickable = true
            l3c2.isClickable = true
            l3c3.isClickable = true

            p1score.text = score1.toString()
            p2score.text = score2.toString()
        }
    }
}