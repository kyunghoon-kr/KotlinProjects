package com.example.bmicalculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 이전에 입력한 값 읽어오기
        loadData()
        resultButton.setOnClickListener {
            // 마지막에 입력한 내용 저장
            saveData(heightEditText.text.toString().toInt(), weightEditText.text.toString().toInt())

            startActivity<ResultActivity>(
                "weight" to weightEditText.text.toString() ,
                "height" to heightEditText.text.toString())
        }
    }

    private fun saveData(height: Int, weight: Int) { // 데이터 저장 메소드
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()

        editor.putInt("KEY_HEIGHT", height)
            .putInt("KEY_WEIGHT",weight)
            .apply()
    }

    private fun loadData() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val height = pref.getInt("KEY_HEIGHT", 0)
        val weight = pref.getInt("KEY_WEIGHT", 0)

        if(height!= 0 && weight!= 0)
        {
            heightEditText.setText(height.toString())
            weightEditText.setText(weight.toString())
        }
    }


}




