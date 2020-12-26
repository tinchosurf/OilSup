package com.ellocorui.oilsup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.text.Editable
import android.widget.SeekBar
import android.widget.Toast
import com.ellocorui.oilsup.databinding.ActivityMainBinding


class MainActivity() : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val bba :Editable?= binding.eTBomba.text
        val rpm1 :Editable?= binding.eTRPM1.text
        val rpm2 :Editable?= binding.eTRPM2.text


        var brutIniEf1: Double
        var brutFinEf1: Double
        var brutIniEf2: Double
        var brutFinEf2: Double





        binding.sBarEf1.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {}

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {


                if (validacion ()) {

                    brutIniEf1 = ((rpm1.toString().toDouble() * bba.toString().toDouble()) / 100)
                    brutIniEf1 *= binding.sBarEf1.progress.toDouble() / 100

                    println("$brutIniEf1")

                    binding.tVBrutaIniEf1.text = brutIniEf1.toString()

                    brutFinEf1 = ((rpm2.toString().toDouble() * bba.toString().toDouble()) / 100)
                    brutFinEf1 *= binding.sBarEf1.progress.toDouble() / 100

                    println("$brutFinEf1")

                    binding.tVBrutaFinEf1.text = brutFinEf1.toString()

                    binding.tvEf1.text = binding.sBarEf1.progress.toString()


                    Toast.makeText(applicationContext, "Eficiencia 1 ${binding.sBarEf1.progress}", Toast.LENGTH_SHORT).show()
                }
            }

            private fun validacion(): Boolean {
                var validate = true

                if (bba?.isEmpty() == true) {
                     binding.eTBomba.setError("Completar tipo de Bomba")
                        validate = false
                }
                if (rpm1?.isEmpty() == true) { binding.eTRPM1.setError("Completar RPM Inicial")
                    validate = false
                }
                if (rpm2?.isEmpty() == true ) { binding.eTRPM2.setError("Completar RPM Final")
                    validate = false
                }

                return validate
            }

        })


        binding.sBarEf2.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {}

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

                if(validacion()) {

                    brutIniEf2 = ((rpm1.toString().toDouble() * bba.toString().toDouble()) / 100)
                    brutIniEf2 *= binding.sBarEf2.progress.toDouble() / 100

                    println("$brutIniEf2")

                    binding.tVBrutaIniEf2.text = brutIniEf2.toString()

                    brutFinEf2 = ((rpm2.toString().toDouble() * bba.toString().toDouble()) / 100)
                    brutFinEf2 *= binding.sBarEf2.progress.toDouble() / 100

                    println("$brutFinEf2")

                    binding.tVBrutaFinEf2.text = brutFinEf2.toString()

                    binding.tvEf2.text = binding.sBarEf2.progress.toString()

                    Toast.makeText(applicationContext, "Eficiencia 2  ${binding.sBarEf2.progress}", Toast.LENGTH_SHORT).show()
                }

            }


            private fun validacion(): Boolean {
                var validate = true

                if (bba?.isEmpty() == true ) { binding.eTBomba.setError("Completar tipo de Bomba")
                    validate = false
                }
                if (rpm1?.isEmpty() == true ) { binding.eTRPM1.setError("Completar RPM Inicial")
                    validate = false
                }
                if (rpm2?.isEmpty() == true ) { binding.eTRPM2.setError("Completar RPM Final")
                    validate = false
                }

                return validate
            }
        })




    }


}