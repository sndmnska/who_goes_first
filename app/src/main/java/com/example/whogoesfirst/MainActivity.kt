package com.example.whogoesfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

private const val TAG = "WHO_GOES_FIRST"

class MainActivity : AppCompatActivity() {
    private lateinit var teamOneInput: EditText
    private lateinit var teamTwoInput: EditText
    private lateinit var randomSelectButton: Button
    private lateinit var resultString: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        teamOneInput = findViewById(R.id.team1EditText)
        teamTwoInput = findViewById(R.id.team2EditText)
        randomSelectButton = findViewById(R.id.randomSelectButton)
        resultString = findViewById(R.id.resultString)


        //        -	Add a click event listener to the Select Random Team button
        randomSelectButton.setOnClickListener {
            chooseRandomTeam()
        }


//        -	When the button is clicked, read both the team names from the EditText widgets
//        -	Check that the user has typed something into both EditText widgets
//        o	If they haven't, use a Toast to remind them to fill in both EditText widgets
//        o	If they have entered two names, randomly select one of the two team names, and display it in the result TextView


    }

    private fun chooseRandomTeam() {
        val teamOne = teamOneInput.text.toString()
        val teamTwo = teamTwoInput.text.toString()
        when {
            teamOne.isBlank() || teamTwo.isBlank() -> {
                Log.d(TAG, "There was at least one blank field.")
                Toast.makeText(
                    this,
                    getString(R.string.blank_field_error),
                    Toast.LENGTH_SHORT
                ).show()

                // reset result string to Default
                resultString.text = getString(R.string.resultDefaultString)
            }
            else -> {
                // Choose a team at random
                val chosenTeam = listOf(teamOne, teamTwo).random()

                // the chosenTeam is presented in the resultString
                resultString.text = getString(R.string.resultString, chosenTeam)

            }
        }
    }


}