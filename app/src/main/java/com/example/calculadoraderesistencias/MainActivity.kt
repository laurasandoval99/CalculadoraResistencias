package com.example.calculadoraderesistencias

import android.os.Bundle
import android.text.Html
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoraderesistencias.databinding.ActivityMainBinding
import kotlin.math.pow


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        //action bar
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.title= Html.fromHtml("<font color=\"black\">" + getString(R.string.app_name)+ "</font>")
        supportActionBar!!.setIcon(R.mipmap.ic_launcher)

        val firstly: Spinner = findViewById(R.id.primera_spinner)
        ArrayAdapter.createFromResource(
                this,
                R.array.resiscolors,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            firstly.adapter = adapter
        }

        val secondly: Spinner = findViewById(R.id.segundo_spinner)
        ArrayAdapter.createFromResource(
                this,
                R.array.resiscolors,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            secondly.adapter = adapter
        }

        val thirdly: Spinner = findViewById(R.id.tercero_spinner)
        ArrayAdapter.createFromResource(
                this,
                R.array.resiscolors1,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            thirdly.adapter = adapter
        }

        val fourthly: Spinner = findViewById(R.id.cuarto_spinner)
        ArrayAdapter.createFromResource(
                this,
                R.array.tolerance,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            fourthly.adapter = adapter
        }



        mainBinding.saveButton.setOnClickListener {

            val firstly1 = mainBinding.primeraSpinner.selectedItemPosition
            val secondly2 = mainBinding.segundoSpinner.selectedItemPosition
            val thirdly3 = mainBinding.terceroSpinner.selectedItemPosition
            val fourthly4 = mainBinding.cuartoSpinner.selectedItemPosition

           // saveUser(firstly1,secondly2)

            if (firstly1 == 0)
            {
                Toast.makeText(this, getString(R.string.first), Toast.LENGTH_SHORT).show()
            }
            else
            {
                if (secondly2 == 0)
                {
                    Toast.makeText(this, getString(R.string.second1), Toast.LENGTH_SHORT).show()
                }
                else
                {
                    if (thirdly3 == 0)
                    {
                        Toast.makeText(this, getString(R.string.multi), Toast.LENGTH_SHORT).show()
                    }
                    else
                    {
                        if (fourthly4 == 0)
                        {
                            Toast.makeText(this, getString(R.string.tole), Toast.LENGTH_SHORT).show()
                        }
                        else
                        {
                            if (fourthly4 == 1) {
                                val value1 = "5% de tolerancia"
                                val value2 = (secondly2-1).toString()
                                val value0 = (firstly1-1).toString()
                                val result0 = value0 + value2
                                //val value3 = thirdly3
                                if ((thirdly3-1)==10)
                                {
                                    var result1 = result0.toFloat() *0.1
                                    val value4 = result1.toString() + "Ω"
                                    saveUser(value4, value1)
                                }
                                else if ((thirdly3-1)==11)
                                {
                                    var result1 = result0.toFloat() *0.01
                                    val value4 = result1.toString() + "Ω"
                                    saveUser(value4, value1)
                                }
                                else
                                {
                                    var result1 = result0.toInt() * 10.0.pow((thirdly3 - 1).toDouble())
                                    if (result1 / 1000 >= 1 && result1 / 1000 < 1000) {
                                        result1 /= 1000
                                        val value4 = result1.toString() + "KΩ"
                                        saveUser(value4, value1)
                                    } else if (result1 / 1000000 >= 1) {
                                        result1 /= 1000000
                                        val value4 = result1.toString() + "MΩ"
                                        saveUser(value4, value1)
                                    } else {
                                        val value4 = result1.toString() + "Ω"
                                        saveUser(value4, value1)
                                    }
                                }
                            }
                            else {
                                val value1 = "10% de tolerancia"
                                val value2 = (secondly2-1).toString()
                                val value0 = (firstly1-1).toString()
                                val result0 = value0 + value2
                                //val value3 = thirdly3
                                if ((thirdly3-1)==10)
                                {
                                    var result1 = result0.toFloat() *0.1
                                    val value4 = result1.toString() + "Ω"
                                    saveUser(value4, value1)
                                }
                                else if ((thirdly3-1)==11)
                                {
                                    var result1 = result0.toFloat() *0.01
                                    val value4 = result1.toString() + "Ω"
                                    saveUser(value4, value1)
                                }
                                else {

                                    var result1 = result0.toInt() * 10.0.pow((thirdly3 - 1).toDouble())
                                    if (result1 / 1000 >= 1 && result1 / 1000 < 1000) {
                                        result1 /= 1000
                                        val value4 = result1.toString() + "KΩ"
                                        saveUser(value4, value1)
                                    } else if (result1 / 1000000 >= 1) {
                                        result1 /= 1000000
                                        val value4 = result1.toString() + "MΩ"
                                        saveUser(value4, value1)
                                    } else {
                                        val value4 = result1.toString() + "Ω"
                                        saveUser(value4, value1)
                                    }
                                }
                            }

                        }


                    }

                }

            }


        }
    }

    private fun saveUser(value4: String, value1: String) {
        val newUser = User(value4, value1)
        mainBinding.infoTextView.text =  newUser.value4 +", +/- "+ newUser.value1
        }

}