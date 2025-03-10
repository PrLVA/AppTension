package com.example.tension

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var systolicInput: EditText
    private lateinit var diastolicInput: EditText
    private lateinit var pulseInput: EditText
    private lateinit var saveButton: Button
    private lateinit var listView: ListView
    private lateinit var averageText: TextView

    private val measurements = mutableListOf<Measurement>()
    private lateinit var adapter: MeasurementAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        systolicInput = findViewById(R.id.systolicInput)
        diastolicInput = findViewById(R.id.diastolicInput)
        pulseInput = findViewById(R.id.pulseInput)
        saveButton = findViewById(R.id.saveButton)
        listView = findViewById(R.id.listView)
        averageText = findViewById(R.id.averageText)

        adapter = MeasurementAdapter(this, measurements)
        listView.adapter = adapter

        saveButton.setOnClickListener {
            val timestamp = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Date())
            val systolic = systolicInput.text.toString().toIntOrNull() ?: 0
            val diastolic = diastolicInput.text.toString().toIntOrNull() ?: 0
            val pulse = pulseInput.text.toString().toIntOrNull() ?: 0

            val newMeasurement = Measurement(systolic, diastolic, pulse, timestamp)
            measurements.add(newMeasurement)
            adapter.notifyDataSetChanged()
            systolicInput.text.clear()
            diastolicInput.text.clear()
            pulseInput.text.clear()
            updateAverage()
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            measurements.removeAt(position)
            adapter.notifyDataSetChanged()
            updateAverage()
        }
    }

    private fun updateAverage() {
        if (measurements.isNotEmpty()) {
            val avgSystolic = measurements.map { it.systolic }.average().toInt()
            val avgDiastolic = measurements.map { it.diastolic }.average().toInt()
            val status = getBloodPressureStatus(avgSystolic, avgDiastolic)
            averageText.text = "Promedio: $avgSystolic/$avgDiastolic mmHg ($status)"
        } else {
            averageText.text = ""
        }
    }

    private fun getBloodPressureStatus(systolic: Int, diastolic: Int): String {
        return when {
            systolic < 90 || diastolic < 60 -> "Baja"
            systolic in 90..120 && diastolic in 60..80 -> "Normal"
            else -> "Alta"
        }
    }
}

data class Measurement(val systolic: Int, val diastolic: Int, val pulse: Int, val timestamp: String)
