package com.example.challengeroom1aurelliajasmine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeroom1aurelliajasmine.room.Constant
import com.example.challengeroom1aurelliajasmine.room.dbsmksa
import com.example.challengeroom1aurelliajasmine.room.tbsiswa
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    val db by lazy { dbsmksa(this) }
    lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListener()
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val siswa = db.tbsiswaDAO().getTbsiswa()
            Log.d("MainActivity", "dbResponse: $siswa")
            withContext(Dispatchers.Main){
                mainAdapter.setData(siswa)
            }
        }
    }

    private fun setupListener() {
        button_create.setOnClickListener {
            intentEdit(0,Constant.TYPE_CREATE)
        }
    }

    fun intentEdit(tbsiswaNis: Int, intentType: Int) {
        startActivity(
            Intent(applicationContext,EditActivity::class.java)
                .putExtra("intent_nis",tbsiswaNis)
                .putExtra("intent_type",intentType)
        )
    }

    private fun setupRecyclerView(){
        mainAdapter = MainAdapter(arrayListOf(), object : MainAdapter.OnAdapterListener{
            override fun onCLick(tbsiswa: tbsiswa) {
                intentEdit(tbsiswa.nis, Constant.TYPE_READ)
            }
        })

        list_RV.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = mainAdapter
        }
    }

}
