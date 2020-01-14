package learn.nbcc.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

val tag = "MainActivity"

class MainActivity : AppCompatActivity() {
    lateinit var diceImage : ImageView
    lateinit var diceImage2 : ImageView
    lateinit var diceImage3 : ImageView


    override fun onResume() {
        super.onResume()
        Log.d(tag, "In OnCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "In OnDestroy")
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "In OnStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "In OnPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "In OnRestart")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(tag, "In OnCreate")

        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)
        diceImage3 = findViewById(R.id.dice_image3)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            diceImage.setImageResource(rollDice())
            diceImage2.setImageResource(rollDice())
            diceImage3.setImageResource(rollDice())
        }

        //val countUpButton: Button = findViewById(R.id.count_up_button)
        //countUpButton.setOnClickListener { countUp() }
    }

//    private fun countUp() {
//
//        var resultText: TextView = findViewById(R.id.result_text)
//
//        if(resultText.text.toString().equals("Hello World!")){
//            resultText.text = "1"
//        }else{
//            var num: Int = Integer.parseInt(resultText.text.toString())
//            if(num < 6){
//                num++
//                resultText.text = num.toString()
//            }
//        }
//    }

    private fun rollDice(): Int {
       // val resultText: TextView = findViewById(R.id.result_text)
       // val randomInt = Random().nextInt(6) + 1

        //val diceImage: ImageView = findViewById(R.id.dice_image) declared at the top

//        val drawableResource = when (randomInt) {
//            1 -> R.drawable.dice_1
//            2 -> R.drawable.dice_2
//            3 -> R.drawable.dice_3
//            4 -> R.drawable.dice_4
//            5 -> R.drawable.dice_5
//            else -> R.drawable.dice_6
//        }

        //shorter syntaxis
        return when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //diceImage.setImageResource(resId)

//        resultText.text = randomInt.toString()

        //resultText.text = "Dice Rolled!"

//        Toast.makeText(this, "button clicked",
//            Toast.LENGTH_SHORT).show()
    }



}
