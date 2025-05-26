// Title: Flash Card App (Test your knowledge)
// Author: Nikyle Mazeau
// Date: 26 May 2025
// Version: 1.0

package vcmsa.ci.imad5111assignment2_nikylemazeau

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.flash_score)

        //Find UI elements by their declaring their ids that are found in your XML/Layout screen
        val theQuestion = findViewById<TextView>(R.id.thequestionsiSet)
        val True = findViewById<Button>(R.id.youchoseTrue)
        val falsee = findViewById<Button>(R.id.falseAnswer)
        val nextt = findViewById<Button>(R.id.movingontonextQuestion)
        val constructiveCriticism = findViewById<TextView>(R.id.theAnswer)

        //Define the Questions for the quiz, these are what the user will be answering
        val questions = arrayOf(
            "The Great Wall of China is visible from space.",
            "Christopher Columbus discovered America.",
            "The first Olympic Games were held in Athens Greece.",
            "Leonardo Da Vinci painted the Mona Lisa.",
            "World War II ended in 1945."
        )

        //Have the answers to the questions you set
        val answers = arrayOf(false, false, true, true, true)

        //Keep track of the current question index, this is used in the loop 
        var currentQuestionIndex = 0
        //Variable to keep track of the score which will later be moved to the review screen
        val score = 0

        // Display the first Question
        theQuestion.text = questions[currentQuestionIndex]

        //Set up click listeners for the true and false buttons or what happens when the true and false buttons are clicked

        True.setOnClickListener {
            //Logic when true button is clicked
            val userAnswer = true
            val correctAnswer = answers[currentQuestionIndex]
            //If the users answer is correct
            if (userAnswer == correctAnswer) {
                constructiveCriticism.text = "Correct!"//Tell the user their answer is Correct
                score + 1 //increase score for a correct answer
            } else {
                constructiveCriticism.text = "Incorrect!"//Tell the user their answer is Incorrect
            }

            falsee.setOnClickListener {
                //Logic when false button is clicked
                val userAnswer = false
                val correctAnswer = answers[currentQuestionIndex]
                //Logic for when the users answer is correct or incorrect
                if (userAnswer == correctAnswer) {
                    constructiveCriticism.text = "Correct!"//Tell the user their answer is Correct
                    score + 1//Increase score if answer is Correct
                } else {
                    constructiveCriticism.text = "Incorrect!"//Tell the user their answer is Incorrect
                }
            }

            nextt.setOnClickListener {

                //Logic when the next button is clicked
                currentQuestionIndex++

                if (currentQuestionIndex < questions.size) {
                    //Display the next question when clicked
                    theQuestion.text = questions[currentQuestionIndex]
                    //Reset the feedback and next button
                    constructiveCriticism.text = ""
                } else {
                    //When all questions are answered, navigate to the Score Screen
                    val intent = Intent(this, MainActivity3::class.java)
                    //This will pass the final score the user gets to our review screen so we can offer a personalised review based on how mush the user scored
                    intent.putExtra("Score", score) //This is what we used to find the users score based on how many they got right or wrong
                    //This will pass the array with the questions to the score screen for review
                    intent.putStringArrayListExtra("questionsList", ArrayList(questions.toList())) //This is converting our array to a list of strings
                    //This will pass the array with the answers to our score screen for review
                    intent.putExtra("answersArray", answers)
                    //Start the score screen and the user will be taken to the 3rd xml for review
                    startActivity(intent)
                    //finish()

                }

            }

        }
    }
}
