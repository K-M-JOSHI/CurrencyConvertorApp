package com.promact.curcon

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.widget.CompoundButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import android.view.View.OnFocusChangeListener



class MainActivity : AppCompatActivity(), OnClickListener {

    private val fromTo: HashMap<String, List<Double>> = hashMapOf(
            "INR" to listOf(1.000,0.0155,0.0608,0.0058,0.8941,3.9019,1.6932,0.0145),
            "USD" to listOf(64.2903,1.0000,3.9126,0.376,57.4481,250.8708,108.9071,0.9339),
            "MYR" to listOf(16.4344,0.2555,1.0000,0.0961,14.6633,64.1226,27.8328,0.2388),
            "BHD" to listOf(170.895,2.6595,10.4095,1.0000,152.6186,666.9613,289.5963,2.4839),
            "RUB" to listOf(1.1197,0.01742,0.0682,0.0065,1.0000,4.3702,1.8977,0.0163),
            "HUF" to listOf(0.2561,0.0032,0.0156,0.0014,0.2288,1.0000,0.4344,0.0037),
            "JPY" to listOf(0.587, 0.0091, 0.0358, 0.0034, 0.5221, 2.2851,1.0000, 0.0085),
            "CHF" to listOf(68.7123,1.0706,4.1875,0.4025,61.2213,267.7758,116.6162,1.0000)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateBtnJapaneseYen.setOnClickListener(this)
        calculateBtnIndianRupee.setOnClickListener(this)
        calculateBtnUSDollar.setOnClickListener(this)
        calculateBtnMalaysianRinggit.setOnClickListener(this)
        calculateBtnBahrainiDinar.setOnClickListener(this)
        calculateBtnRussianRuble.setOnClickListener(this)
        calculateBtnHungarianForint.setOnClickListener(this)
        calculateBtnSwissFranc.setOnClickListener(this)

        autoSwitch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener(){ compoundButton: CompoundButton, b: Boolean ->

                if(b)
                {
                        calculateBtnJapaneseYen.visibility = View.GONE
                        calculateBtnIndianRupee.visibility = View.GONE
                        calculateBtnUSDollar.visibility = View.GONE
                        calculateBtnMalaysianRinggit.visibility = View.GONE
                        calculateBtnBahrainiDinar.visibility = View.GONE
                        calculateBtnRussianRuble.visibility = View.GONE
                        calculateBtnHungarianForint.visibility = View.GONE
                        calculateBtnSwissFranc.visibility = View.GONE

                        if(indianRupee.isFocused)
                            indianRupee.addTextChangedListener(textWatcher)
                        else if(usDollar.isFocused)
                            usDollar.addTextChangedListener(textWatcher)
                        else if(malaysianRinggit.isFocused)
                            malaysianRinggit.addTextChangedListener(textWatcher)
                        else if(bahrainiDinar.isFocused)
                            bahrainiDinar.addTextChangedListener(textWatcher)
                        else if(russianRuble.isFocused)
                            russianRuble.addTextChangedListener(textWatcher)
                        else if(hungarianForint.isFocused)
                            hungarianForint.addTextChangedListener(textWatcher)
                        else if(japaneseYen.isFocused)
                            japaneseYen.addTextChangedListener(textWatcher)
                        else if(swissFranc.isFocused)
                            swissFranc.addTextChangedListener(textWatcher)

                }else{

                    calculateBtnJapaneseYen.visibility = View.VISIBLE
                    calculateBtnIndianRupee.visibility = View.VISIBLE
                    calculateBtnUSDollar.visibility = View.VISIBLE
                    calculateBtnMalaysianRinggit.visibility = View.VISIBLE
                    calculateBtnBahrainiDinar.visibility = View.VISIBLE
                    calculateBtnRussianRuble.visibility = View.VISIBLE
                    calculateBtnHungarianForint.visibility = View.VISIBLE
                    calculateBtnSwissFranc.visibility = View.VISIBLE

                    removeListener("all")
                }
        })

        indianRupee.setOnFocusChangeListener(OnFocusChangeListener { view, hasFocus ->
            if(autoSwitch.isChecked)
            {
                if (hasFocus) {
                    indianRupee.addTextChangedListener(textWatcher)
                } else {
                    indianRupee.removeTextChangedListener(textWatcher)
                }
            }
        })

        usDollar.setOnFocusChangeListener(OnFocusChangeListener { view, hasFocus ->
            if(autoSwitch.isChecked)
            {
                if (hasFocus) {
                    usDollar.addTextChangedListener(textWatcher)
                } else {
                    usDollar.removeTextChangedListener(textWatcher)
                }
            }
        })

        malaysianRinggit.setOnFocusChangeListener(OnFocusChangeListener { view, hasFocus ->
            if(autoSwitch.isChecked)
            {
                if (hasFocus) {
                    malaysianRinggit.addTextChangedListener(textWatcher)
                } else {
                    malaysianRinggit.removeTextChangedListener(textWatcher)
                }
            }
        })



        bahrainiDinar.setOnFocusChangeListener(OnFocusChangeListener { view, hasFocus ->
            if(autoSwitch.isChecked)
            {
                if (hasFocus) {
                    bahrainiDinar.addTextChangedListener(textWatcher)
                } else {
                    bahrainiDinar.removeTextChangedListener(textWatcher)
                }
            }
        })
        russianRuble.setOnFocusChangeListener(OnFocusChangeListener { view, hasFocus ->
            if(autoSwitch.isChecked)
            {
                if (hasFocus) {
                    russianRuble.addTextChangedListener(textWatcher)
                } else {
                    russianRuble.removeTextChangedListener(textWatcher)
                }
            }
        })
        hungarianForint.setOnFocusChangeListener(OnFocusChangeListener { view, hasFocus ->
            if(autoSwitch.isChecked)
            {
                if (hasFocus) {
                    hungarianForint.addTextChangedListener(textWatcher)
                } else {
                    hungarianForint.removeTextChangedListener(textWatcher)
                }
            }
        })
        japaneseYen.setOnFocusChangeListener(OnFocusChangeListener { view, hasFocus ->
            if(autoSwitch.isChecked)
            {
                if (hasFocus) {
                    japaneseYen.addTextChangedListener(textWatcher)
                } else {
                    japaneseYen.removeTextChangedListener(textWatcher)
                }
            }
        })
        swissFranc.setOnFocusChangeListener(OnFocusChangeListener { view, hasFocus ->
            if(autoSwitch.isChecked)
            {
                if (hasFocus) {
                    swissFranc.addTextChangedListener(textWatcher)
                } else {
                    swissFranc.removeTextChangedListener(textWatcher)
                }
            }
        })

    }

    fun removeListener(from: String){
        if(!from.equals("INR"))
            indianRupee.removeTextChangedListener(textWatcher)
        if(!from.equals("USD"))
            usDollar.removeTextChangedListener(textWatcher)
        if(!from.equals("MYR"))
            malaysianRinggit.removeTextChangedListener(textWatcher)
        if(!from.equals("BHD"))
            bahrainiDinar.removeTextChangedListener(textWatcher)
        if(!from.equals("RUB"))
            russianRuble.removeTextChangedListener(textWatcher)
        if(!from.equals("HUF"))
            hungarianForint.removeTextChangedListener(textWatcher)
        if(!from.equals("JPY"))
            japaneseYen.removeTextChangedListener(textWatcher)
        if(!from.equals("CHF"))
            swissFranc.removeTextChangedListener(textWatcher)
    }

    var textWatcher = object : TextWatcher {

        override fun afterTextChanged(s: Editable) {}

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            if(s.toString().toDoubleOrNull() != null && indianRupee.isFocused) {
                convert("INR",s.toString().toDoubleOrNull()!!)
            }else if(s.toString().toDoubleOrNull() != null && usDollar.isFocused){

                convert("USD",s.toString().toDoubleOrNull()!!)
            }
            else if(s.toString().toDoubleOrNull() != null && malaysianRinggit.isFocused){

                convert("MYR",s.toString().toDoubleOrNull()!!)
            }
            else if(s.toString().toDoubleOrNull() != null && bahrainiDinar.isFocused){

                convert("BHD",s.toString().toDoubleOrNull()!!)
            }
            else if(s.toString().toDoubleOrNull() != null && russianRuble.isFocused){

                convert("RUB",s.toString().toDoubleOrNull()!!)
            }
            else if(s.toString().toDoubleOrNull() != null && hungarianForint.isFocused){

                convert("HUF",s.toString().toDoubleOrNull()!!)
            }
            else if(s.toString().toDoubleOrNull() != null && japaneseYen.isFocused){

                convert("JPY",s.toString().toDoubleOrNull()!!)
            }
            else if(s.toString().toDoubleOrNull() != null && swissFranc.isFocused){

                convert("CHF",s.toString().toDoubleOrNull()!!)
            }
            else {
                clear("null")

            }
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.getId()) {
                R.id.calculateBtnIndianRupee -> if(indianRupee.text.toString().toDoubleOrNull() != null) {
                    convert("INR",indianRupee.text.toString().toDoubleOrNull()!!)
                } else {
                    clear("null")
                }
                R.id.calculateBtnUSDollar -> if(usDollar.text.toString().toDoubleOrNull() != null) {
                    convert("USD",usDollar.text.toString().toDoubleOrNull()!!)
                } else {
                    clear("null")
                }
                R.id.calculateBtnMalaysianRinggit -> if(malaysianRinggit.text.toString().toDoubleOrNull() != null) {
                    convert("MYR",malaysianRinggit.text.toString().toDoubleOrNull()!!)
                } else {
                    clear("null")
                }
                R.id.calculateBtnBahrainiDinar -> if(bahrainiDinar.text.toString().toDoubleOrNull() != null) {
                    convert("BHD",bahrainiDinar.text.toString().toDoubleOrNull()!!)
                } else {
                    clear("null")
                }
                R.id.calculateBtnRussianRuble -> if(russianRuble.text.toString().toDoubleOrNull() != null) {
                    convert("RUB",russianRuble.text.toString().toDoubleOrNull()!!)
                } else {
                    clear("null")
                }
                R.id.calculateBtnHungarianForint -> if(hungarianForint.text.toString().toDoubleOrNull() != null) {
                    convert("HUF",hungarianForint.text.toString().toDoubleOrNull()!!)
                } else {
                    clear("null")
                }
                R.id.calculateBtnJapaneseYen -> if(japaneseYen.text.toString().toDoubleOrNull() != null) {
                    convert("JPY", japaneseYen.text.toString().toDoubleOrNull()!!)
                }else {
                    clear("null")
                }
                R.id.calculateBtnSwissFranc -> if(swissFranc.text.toString().toDoubleOrNull() != null) {
                    convert("CHF",swissFranc.text.toString().toDoubleOrNull()!!)
                } else {
                    clear("null")
                }
                else -> {

                }
            }
        }
    }

    fun convert(from: String,baseValue: Double){

        if(!from.equals("INR"))
           indianRupee.setText(BigDecimal(baseValue * fromTo[from]!![0]).setScale(4, BigDecimal.ROUND_HALF_EVEN).toString())
        if(!from.equals("USD"))
           usDollar.setText(BigDecimal(baseValue * fromTo[from]!![1]).setScale(4, BigDecimal.ROUND_HALF_EVEN).toString())
        if(!from.equals("MYR"))
           malaysianRinggit.setText(BigDecimal(baseValue * fromTo[from]!![2]).setScale(4, BigDecimal.ROUND_HALF_EVEN).toString())
        if(!from.equals("BHD"))
           bahrainiDinar.setText(BigDecimal(baseValue * fromTo[from]!![3]).setScale(4, BigDecimal.ROUND_HALF_EVEN).toString())
        if(!from.equals("RUB"))
           russianRuble.setText(BigDecimal(baseValue * fromTo[from]!![4]).setScale(4, BigDecimal.ROUND_HALF_EVEN).toString())
        if(!from.equals("HUF"))
           hungarianForint.setText(BigDecimal(baseValue * fromTo[from]!![5]).setScale(4, BigDecimal.ROUND_HALF_EVEN).toString())
        if(!from.equals("JPY"))
           japaneseYen.setText(BigDecimal(baseValue * fromTo[from]!![6]).setScale(4, BigDecimal.ROUND_HALF_EVEN).toString())
        if(!from.equals("CHF"))
           swissFranc.setText(BigDecimal(baseValue * fromTo[from]!![7]).setScale(4, BigDecimal.ROUND_HALF_EVEN).toString())
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_clear -> {

            autoSwitch.setChecked(false)
            japaneseYen.requestFocus()
            clear("btn")
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    fun clear(from: String) {

        if(from.equals("btn"))
            Toast.makeText(applicationContext,"Cleared", Toast.LENGTH_LONG).show()
        else if(from.equals("null"))
            Toast.makeText(applicationContext,"Please Enter Amount", Toast.LENGTH_LONG).show()

        japaneseYen.text.clear()
        indianRupee.text.clear()
        usDollar.text.clear()
        malaysianRinggit.text.clear()
        bahrainiDinar.text.clear()
        russianRuble.text.clear()
        hungarianForint.text.clear()
        swissFranc.text.clear()
    }
}

