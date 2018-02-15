package com.promact.curcon

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal


class MainActivity : AppCompatActivity() {

    private val yenTo: HashMap<String, Double> = hashMapOf("indian_rupee" to 0.587,
            "us_dollar" to 0.0091,
            "malaysian_ringgit" to 0.0358,
            "bahraini_dinar" to 0.0034,
            "russian_ruble" to 0.5221,
            "hungarian_forint" to 2.2851,
            "swiss_franc" to 0.0085
            )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateBtn.setOnClickListener(){

            if(japaneseYenInput.text.toString().toDoubleOrNull() != null)
            {
                indianRupee.setText(BigDecimal(japaneseYenInput.text.toString().toDouble() * yenTo["indian_rupee"]!!).setScale(4, BigDecimal.ROUND_HALF_EVEN).toString())
                usDollar.setText(BigDecimal(japaneseYenInput.text.toString().toDouble() * yenTo["us_dollar"]!!).setScale(4, BigDecimal.ROUND_HALF_EVEN).toString())
                malaysianRinggit.setText(BigDecimal(japaneseYenInput.text.toString().toDouble() * yenTo["malaysian_ringgit"]!!).setScale(4, BigDecimal.ROUND_HALF_EVEN).toString())
                bahrainiDinar.setText(BigDecimal(japaneseYenInput.text.toString().toDouble() * yenTo["bahraini_dinar"]!!).setScale(4, BigDecimal.ROUND_HALF_EVEN).toString())
                russianRuble.setText(BigDecimal(japaneseYenInput.text.toString().toDouble() * yenTo["russian_ruble"]!!).setScale(4, BigDecimal.ROUND_HALF_EVEN).toString())
                hungarianForint.setText(BigDecimal(japaneseYenInput.text.toString().toDouble() * yenTo["hungarian_forint"]!!).setScale(4, BigDecimal.ROUND_HALF_EVEN).toString())
                swissFranc.setText(BigDecimal(japaneseYenInput.text.toString().toDouble() * yenTo["swiss_franc"]!!).setScale(4, BigDecimal.ROUND_HALF_EVEN).toString())
            }
            else
            {
                Toast.makeText(applicationContext,"Please Enter Amount", Toast.LENGTH_LONG).show()
                indianRupee.text=""
                usDollar.text=""
                malaysianRinggit.text=""
                bahrainiDinar.text=""
                russianRuble.text=""
                hungarianForint.text=""
                swissFranc.text=""
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_clear -> {
            Toast.makeText(applicationContext,"Cleared", Toast.LENGTH_LONG).show()

           // Snackbar.make(findViewById(R.id.content),"Cleared",Snackbar.LENGTH_SHORT).show()
            japaneseYenInput.text.clear()
            indianRupee.text=""
            usDollar.text=""
            malaysianRinggit.text=""
            bahrainiDinar.text=""
            russianRuble.text=""
            hungarianForint.text=""
            swissFranc.text=""
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}
