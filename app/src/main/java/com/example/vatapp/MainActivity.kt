package com.example.vatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vatapp.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.button.setOnClickListener {
            calculateVat()
        }


    }
    private fun calculateVat() {
        val stringInTextField = binding.editTextText.text.toString()
        val cost = stringInTextField.toDouble()

        val userchoice = binding.radioGroup.checkedRadioButtonId

        val vatPercentage = when(userchoice){
            R.id.r10 -> 0.10
            R.id.r15 -> 0.15
            else -> 0.20
        }

        val vat = vatPercentage * cost
        var total = cost + vat


        val roundedVat = binding.swich.isChecked

        if (roundedVat){
            total = kotlin.math.ceil(total)
        }

        // Total Formatting
        val formattedTotal = NumberFormat.getCurrencyInstance().format(total)
        binding.totalAmountext.text = getString(R.string.total_amount, formattedTotal)

    }

}