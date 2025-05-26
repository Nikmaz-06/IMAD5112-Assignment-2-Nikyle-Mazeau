// Title: Flash Card App (Test your knowledge)
// Author: Nikyle Mazeau
// Date: 26 May 2025
// Version: 1.0


package vcmsa.ci.imad5111assignment2_nikylemazeau

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {
    //  Assigning the arrays from the previous screen for our review button
    private var questions: ArrayList<String>? = null
    private var answers: BooleanArray? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.score_screen)

        //Declare the text views and buttons with specific variables here
        val youScored = findViewById<TextView>(R.id.yourScore)
        val advice = findViewById<TextView>(R.id.constructiveCriticism)
        val reviewYourself = findViewById<Button>(R.id.Review)
        val yourExit = findViewById<Button>(R.id.exitPlan)
        val linearLayoutReviewContent = findViewById<LinearLayout>(R.id.linearlayoutReviewContent)

        //Get the score passed from the Flash Score screen/MainActivity2
        val score = intent.getIntExtra("score", 0)//score is the variable we used to see how many questions the user got correct, and 0 is the default value set if nothing is found
        val totalQuestions = 5 //We know our quiz size consists of 5 Questions

        //Get the questions and Answers arrays that we used in MainActivity 2
        questions = intent.getStringArrayListExtra("questionsList")
        answers = intent.getBooleanArrayExtra("answersArray")

        //This will display the users final score in the Text View
        youScored.text = "Your Score: $score / $totalQuestions"

        //Give the user Advice or "Constructive Criticism" based on what they Scored
        if (score >= 3){//If the user scored 3 exactly or more, this will be displayed (higher scores)
            advice.text = "Great Job!!!"
        }else {//If the user scored less than 3 and not exactly 3, this will be displayed (lower scores)
            advice.text = "Keep Practicing!!!"
        }

        //Set the click listener and logic for the review button here so the user can see the questions and their corresponding answers
        reviewYourself.setOnClickListener {
            linearLayoutReviewContent.removeAllViews()

            if (questions != null && answers != null){
                //This will loop through the questions and answers from the arrays and display them to the user so they can review their answers and see how they performed
                for (i in questions!!.indices){
                    val questionText = questions!![i]
                    val correctAnswer = if (answers!![i]) "True" else "False"
                    //This will present the questions to the user in the review
                    val questionTextView = TextView(this)
                    questionTextView.text = "Q${i + 1}: $questionText"
                    //This will present the answers to the user in the review
                    val yourAnswers = TextView(this)
                    yourAnswers.text = "Correct Answer: $correctAnswer"
                    //This adds the text views to the scroll view which allows the user to see the questions and corresponding answers
                    linearLayoutReviewContent.addView(questionTextView)
                    linearLayoutReviewContent.addView(yourAnswers)
                }
            }else{
                //This pops up when theirs no data gathered to display
                Toast.makeText(this, "Review data not avaliable.", Toast.LENGTH_SHORT).show()

            }
        }

        //Set the click listener for the Exit button which closes the entire app when the user is done
        yourExit.setOnClickListener {
            //Terminates the app when clicked
            finishAffinity()
        }
    }
}



