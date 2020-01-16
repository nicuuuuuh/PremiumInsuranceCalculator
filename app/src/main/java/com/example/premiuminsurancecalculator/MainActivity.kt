package com.example.premiuminsurancecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.premiuminsurancecalculator.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        Toast.makeText(this, "Position =" + position, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerAge.onItemSelectedListener = this

        buttonCalculate.setOnClickListener() {
            calculatePremium()
        }
    }

    private fun calculatePremium() {
        val position = spinnerAge.selectedItemPosition
        val gender = radioGroupGender.checkedRadioButtonId
        var fee = 0
        if (position == 0) {
            fee += 60
        } else if (position == 1) {
            fee += 70
        } else if (position == 2) {
            fee += 90
        } else if (position == 3) {
            fee += 120
        } else if (position == 4) {
            fee += 150
        } else if (position == 5) {
            fee += 150
        }
        if (gender == R.id.radioButtonMale) {
            if (position == 0) {
                fee += 0
            } else if (position == 1) {
                fee += 50
            } else if (position == 2) {
                fee += 100
            } else if (position == 3) {
                fee += 150
            } else if (position == 4) {
                fee += 200
            } else if (position == 5) {
                fee += 200
            }
        }

        if (checkBoxYes.isChecked) {
            if (position == 0) {
                fee+=0
            } else if (position == 1) {
                fee += 100
            } else if (position == 2) {
                fee += 150
            } else if (position == 3) {
                fee += 200
            } else if (position == 4) {
                fee += 250
            } else if (position == 5) {
                fee += 300
            }
        }

        textViewInsurance.text="Insurance Premium : RM "+fee
    }
}
