package vcmsa.ci.genapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {


    private var yearInput: EditText? = null
    private var genTxt: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        yearInput = findViewById(R.id.yearInput)
        genTxt = findViewById(R.id.genTxt)

        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnExit = findViewById<Button>(R.id.btnExit)


        btnCheck.setOnClickListener {
            checkGeneration()

        }
        btnClear.setOnClickListener {
            yearInput?.text?.clear()
            genTxt?.text = ""
        }

        btnExit.setOnClickListener {
            finishAffinity()
            exitProcess(1)
        }
    }

    private fun isNotEmpty(): Boolean {
        var b = true
        if (yearInput?.text.toString().trim().isEmpty()) {
            yearInput?.error = "Input required"
            b = false
        }
        return b
    }


    private fun checkGeneration() {

        if (isNotEmpty()) {
            when (yearInput?.text.toString().trim().toInt()) {
                in 1901..1927 -> genTxt?.text = "The Greatest Generation"
                in 1928..1945 -> genTxt?.text = "the Silent Generation"
                in 1946..1980 -> genTxt?.text = "The Baby Boomer Generation"
                in 1981..1994 -> genTxt?.text = "Generation X"
                in 1995..2012 -> genTxt?.text = "Millennials"
                in 2013..2025 -> genTxt?.text = "Generation Alpha"

                else -> {
                    genTxt?.text = "Alien Your birth year is INVALID"
                }
            }

        }

    }
}