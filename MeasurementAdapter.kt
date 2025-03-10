package com.example.tension

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.BaseAdapter

class MeasurementAdapter(private val context: Context, private val measurements: List<Measurement>) : BaseAdapter() {
    override fun getCount(): Int = measurements.size
    override fun getItem(position: Int): Any = measurements[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false)
        val measurement = measurements[position]

        val text1 = view.findViewById<TextView>(android.R.id.text1)
        val text2 = view.findViewById<TextView>(android.R.id.text2)

        text1.text = "${measurement.systolic}/${measurement.diastolic} mmHg, ${measurement.pulse} bpm"
        text2.text = measurement.timestamp

        return view
    }
}
