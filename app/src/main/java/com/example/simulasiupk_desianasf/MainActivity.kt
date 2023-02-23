package com.example.simulasiupk_desianasf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var nama : EditText
    private lateinit var Tb : EditText
    private lateinit var Lk : RadioButton
    private lateinit var Pr : RadioButton
    private lateinit var hasil : TextView
    private lateinit var cek : Button
    private lateinit var reset : Button
    private lateinit var simpan : Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: LinearLayoutManager

    private var TB: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nama = findViewById(R.id.etNama)
        Tb = findViewById(R.id.etTB)
        Lk = findViewById(R.id.rbLk2)
        Pr = findViewById(R.id.rbPR)
        hasil = findViewById(R.id.tvHasil)
        cek = findViewById(R.id.btCek)
        reset = findViewById(R.id.btReset)
        simpan = findViewById(R.id.btSimpan)
        recyclerView = findViewById(R.id.listData)

        val data = mutableListOf<DataBBI>()
        viewManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerAdapter = adapter_bbi(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager


        simpan.setOnClickListener {
            val namaa = nama.text.toString()
            val tbadan = Tb.text.toString()
            val hasill = hasil.text.toString()

            val databbi = DataBBI(namaa, tbadan, hasill)
            data.add(databbi)
            recyclerAdapter.notifyDataSetChanged()
        }
        cek.setOnClickListener {
            var TinggiBadan = Tb.text.toString().toInt()

            if (Lk.isChecked) {
                TB = (TinggiBadan - 100) - ((TinggiBadan - 100) * 10 / 100)
                hasil.setText(TB.toString() + "Kg")
            } else {
                TB = (TinggiBadan - 100) - ((TinggiBadan - 100) * 15 / 100)
                hasil.setText(TB.toString() + "Kg")
            }
            reset.setOnClickListener {
                hasil.text = 0.toString()
                nama.text.clear()
                Tb.text.clear()
            }
        }
    }
}