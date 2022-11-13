package com.example.hambis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    //VARIABLES
        val cheesePrice: Int = 3
        var moneyAmount: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //VARIABLES
            val doubleCheesePrice: Int = 5
            val resultTextView: TextView = findViewById(R.id.resultTextView)
            val cheeseBurgerButton: ImageButton = findViewById(R.id.chesseBurgerButton)
            val cheeseBurgerTextView: TextView = findViewById(R.id.cheeseBurgerTextView)
            val doubleCheeseBurgerTextView: TextView = findViewById(R.id.doubleCheeseBurgerTextView)
            val doubleCheeseBurgerButton: ImageButton = findViewById(R.id.doubleCheeseBurgerButton)
            val inputEditText: EditText = findViewById(R.id.inputEditText)

        //FILL THE PRICE BOXES
            cheeseBurgerTextView.setText("Cheese Burger\n\n\n" + cheesePrice + "$")
            doubleCheeseBurgerTextView.setText("Double Cheese Burger\n\n" + doubleCheesePrice + "$")

        //CALCULATE
            cheeseBurgerButton.setOnClickListener{
                moneyAmount = scanMoneyAmount(inputEditText)
                resultTextView.setText(generateResultString("Cheese Burger", cheesePrice))
            }

            doubleCheeseBurgerButton.setOnClickListener {

                moneyAmount = scanMoneyAmount(inputEditText)
                resultTextView.setText(generateResultString("Doube Cheese Burger", doubleCheesePrice))
            }
    }


    fun generateResultString(productName: String, price:Int) :String{
        //VARIABLES
            var result = moneyAmount/price
            var remainder = moneyAmount%price
            var resultString: StringBuilder = java.lang.StringBuilder()

        //IF YOU CAN BUY AT LEAST ONE
        if (result > 0) {
            resultString.append("You can buy " + result + " " + productName + " " + " with this amount of money ")
            if(remainder>0){
                resultString.append("and you will have " + remainder + "$ left over.")
            }
            else{
                resultString.append( ".")

            }
        }
        //IF YOU CANNOT BUY
        else{
            resultString.append( "Unfortunately, you can't buy a "+ productName +" with that much money.")
            if(moneyAmount >= cheesePrice){
                remainder = moneyAmount%cheesePrice
                result = moneyAmount/cheesePrice
                resultString.append( " But you can buy "+ result +" Cheese Burger")
                if(remainder > 0){
                    resultString.append(" and have "+ remainder +"$ left.")
                }
                else{
                    resultString.append( ".")
                }
            }
        }

        return resultString.toString()
    }

    fun scanMoneyAmount(input :EditText) :Int {
        try{
            return Integer.parseInt(input.text.toString());
        }
        catch (e: Exception) {
            return 0
        }
    }
}