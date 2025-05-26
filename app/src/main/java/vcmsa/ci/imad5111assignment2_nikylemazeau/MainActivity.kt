// References

// Title: Flash Card App (Test your knowledge)
// Author: Nikyle Mazeau
// Date: 26 May 2025
// Version: 1.0

// Title: Kotlin if ... Else
// Author: w3schools
// Date: 31 March 2025
// Version: 1.0
// Avaliable: https://www.w3schools.com/kotlin/kotlin_conditions.php

// Title: Kotlin Arrays
// Author: w3schools
// Date: 14 April 2025
// Version: 1.0
// Avaliable: https://www.w3schools.com/kotlin/kotlin_arrays.php

// Title: Kotlin For Loop
// Author: w3schools
// Date: 13 May April 2025
// Version: 1.0
// Avaliable: https://www.w3schools.com/kotlin/kotlin_for_loop.php

// Title: IMAD5112 Student Manual
// Author: IIE Varsity College
// Date: 19 February 2025
// Avaliable: https://advtechonline.sharepoint.com/:w:/r/sites/TertiaryStudents/_layouts/15/Doc.aspx?sourcedoc=%7BA1FF62F0-8E1A-47BC-99BD-CA07AE24427D%7D&file=IMAD5112_MM.docx&action=default&mobileredirect=true


package vcmsa.ci.imad5111assignment2_nikylemazeau

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.welcome)

        //Link the variable to the ID in XML
        val starttheQuiz = findViewById<Button>(R.id.StartQuiz)

        starttheQuiz.setOnClickListener {

        //Will open the 2nd XML when button is clicked
        val intent = Intent(this, MainActivity2::class.java )

            //Start the flash flash_score.xml screen
            startActivity(intent)
        }
    }
}