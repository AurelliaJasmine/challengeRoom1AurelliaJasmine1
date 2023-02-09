package com.example.challengeroom1aurelliajasmine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeroom1aurelliajasmine.room.tbsiswa
import kotlinx.android.synthetic.main.adapter_main.view.*

class MainAdapter (private val siswa: ArrayList<tbsiswa>, private val listener: OnAdapterListener)
    : RecyclerView.Adapter <MainAdapter.MainViewHolder>() {
    class MainViewHolder (val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_main,parent,false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val tbsiswa = siswa[position]
        holder.view.text_title.text = tbsiswa.nama
        holder.view.text_title.setOnClickListener{
            listener.onCLick(tbsiswa)
        }

    }

    override fun getItemCount() = siswa.size

    fun setData(list: List<tbsiswa>) {
        siswa.clear()
        siswa.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onCLick(tbsiswa: tbsiswa)
    }
}