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


        /* var bba=0 */
        val bba :Editable?= binding.eTBomba.text



        /* var rpm1 = 0 */
        val rpm1 :Editable?= binding.eTRPM1.text

        /* var rpm2 = 0 */
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



                brutIniEf1= ((rpm1.toString().toDouble() * bba.toString().toDouble()) / 100)
                brutIniEf1 *= binding.sBarEf1.progress.toDouble() / 100

                println("$brutIniEf1")

                binding.tVBrutaIniEf1.text = brutIniEf1.toString()

                brutFinEf1= ((rpm2.toString().toDouble() * bba.toString().toDouble()) / 100)
                brutFinEf1 *= binding.sBarEf1.progress.toDouble() / 100

                println("$brutFinEf1")

                binding.tVBrutaFinEf1.text = brutFinEf1.toString()

                 Toast.makeText(applicationContext,"Rango barra 1 ${binding.sBarEf1.progress}", Toast.LENGTH_SHORT).show()
            }

        })


        binding.sBarEf2.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {}

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

                brutIniEf2= ((rpm1.toString().toDouble() * bba.toString().toDouble()) / 100)
                brutIniEf2 *= binding.sBarEf2.progress.toDouble() / 100

                println("$brutIniEf2")

                binding.tVBrutaIniEf2.text = brutIniEf2.toString()

                brutFinEf2= ((rpm2.toString().toDouble() * bba.toString().toDouble()) / 100)
                brutFinEf2 *= binding.sBarEf2.progress.toDouble() / 100

                println("$brutFinEf2")

                binding.tVBrutaFinEf2.text = brutFinEf2.toString()

                Toast.makeText(applicationContext, "Rango barra 2  ${binding.sBarEf2.progress}", Toast.LENGTH_SHORT).show()


            }

        })


    }




}