package com.vision.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

//tools is used to remove ambiguity in the code and is used to track the changes like we wanna check how will the placeholder will look like
//tools will automatically gayab ho jaayega as the app will run

//Lets Learn More about the Gradle
//what devices runs your app
//compile to executable files
//compile all the files into apk
//Dependency management
//App signing to the google play
//Automated test


//Let learn about SDK
//Executable format for distributing Android applications


class MainActivity : AppCompatActivity() {
    private lateinit var  diceImage:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Now how to connect to the element
        //we will create a variable and also we need to define the type of the variable =Here it is of the type button and in case of text it will be of the type textView
        //To find id we use findviewbyid and provide the path..like it will be in the resource folder

        val rollButton:Button=findViewById(R.id.roll_button )
        //to set listener on the button
        rollButton.setOnClickListener {
            //to verify weather the implementation has occurred or not we can set a toast
            //context means jis app activity mein hoon uska context jiske relative mein toast show karoage here it will be the main activity
            //this here means self reference(khud ko refer kar rha hain) and in case we want to show other context we can add the context name after the this keyword
            //show function is used to make the toast visible to the user
//            Toast.makeText(this,"ButtonClicked",Toast.LENGTH_SHORT).show()
            //What if we want to change the value of the text when the button is clicked
            //we will call the method for that case
            rollDice()

        }
        diceImage=findViewById(R.id.dice_image)
    }

//    private fun rollDice() {
//        //In this function first i will access the text and then i will change the text
//        Toast.makeText(this,"Text Changed",Toast.LENGTH_LONG)
////        val resultText:TextView=findViewById(R.id.result_text)
//
//        //we want to generate a random number when the button is clicked
//        //Random is inbuilt and we want the type of integer and we need to provide the upper bound and lower bound
//        //Here it will run till 5 like the for loop in python so we need to plus one
//        //To add to the textview we nedd to add it to the text so we will store it in the variable
//        val randomInt=Random().nextInt(6)+1
//        //it will give error as the random int is in integer and the text is in string format so we need to change it to the string format
////        resultText.text=randomInt.toString()
//    }


    //This function is for the image of the dice
    private fun rollDice(){
        //Here we first accessed the image with the id and then created a random varaible for the random output and then mapped the output with the image using when condition
       //it is not the efficient way of coding as every time a diceimage is created and find view by id is called and then it is bind that many time
        //T overcome this we can define it globally
//        val diceImage:ImageView=findViewById(R.id.dice_image)

        val drawableResource=when(Random().nextInt(6)+1){
            1 ->R.drawable.dice_1
            2 ->R.drawable.dice_2
            3 ->R.drawable.dice_3
            4 ->R.drawable.dice_4
            5 ->R.drawable.dice_5
            else ->R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }
}