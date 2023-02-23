package com.example.simulasiupk_desianasf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter_bbi (private val dataSet: MutableList<DataBBI>):
    RecyclerView.Adapter<adapter_bbi.BBIViewHolder>() {
    class BBIViewHolder(view:View):RecyclerView.ViewHolder(view){

        val nama = view.findViewById<TextView>(R.id.tvNama)
        val tbadan = view.findViewById<TextView>(R.id.tvTbdn)
        val hasil = view.findViewById<TextView>(R.id.tvHasilnya)
        val hapus = view.findViewById<TextView>(R.id.tvNama)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BBIViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.adapter_bbi,parent,false
        )
        return BBIViewHolder(view)
    }

    override fun onBindViewHolder(holder: BBIViewHolder, position: Int) {
        val data = dataSet[position]
        holder.nama.text = dataSet[position].nama
        holder.tbadan.text = dataSet[position].tb
        holder.hasil.text = dataSet[position].hasil
        holder.hapus.setOnClickListener {
            dataSet.removeAt(position)
            notifyItemRangeRemoved(position,dataSet.size)
            notifyDataSetChanged()

        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}