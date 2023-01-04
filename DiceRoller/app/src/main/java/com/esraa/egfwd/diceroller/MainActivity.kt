package com.esraa.egfwd.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.esraa.egfwd.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rollButton.setOnClickListener{
            rollDice()
            }
    }

    private fun rollDice() {
        val randomInt = Random.nextInt(6)+1

        val diceImageSource = resources.getIdentifier("dice_$randomInt", "drawable", this.packageName)

//        when(randomInt){
//            1-> diceImageSource = R.drawable.dice_1
//            2-> diceImageSource = R.drawable.dice_2
//            3-> diceImageSource = R.drawable.dice_3
//            4-> diceImageSource = R.drawable.dice_4
//            5-> diceImageSource = R.drawable.dice_5
//            6-> diceImageSource = R.drawable.dice_6
//        }
         binding.diceImage.setImageResource(diceImageSource)
    }
}