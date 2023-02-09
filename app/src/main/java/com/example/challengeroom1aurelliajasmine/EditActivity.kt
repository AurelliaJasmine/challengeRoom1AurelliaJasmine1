package com.example.challengeroom1aurelliajasmine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.challengeroom1aurelliajasmine.room.Constant
import com.example.challengeroom1aurelliajasmine.room.dbsmksa
import com.example.challengeroom1aurelliajasmine.room.tbsiswa
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditActivity : AppCompatActivity() {

    val db by lazy { dbsmksa(this) }
    private var tbsiswaNis: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        setupView()
        setupListener()
        tbsiswaNis = intent.getIntExtra("intent_nis",0)
        Toast.makeText(this, tbsiswaNis.toString(), Toast.LENGTH_SHORT).show()
    }

    fun setupView(){
        val intentType = intent.getIntExtra("intent_nis",0)
        when(intentType) {
            Constant.TYPE_CREATE -> {
            }
            Constant.TYPE_READ -> {
                button_save.visibility = View.GONE
            }
        }
    }

    fun setupListener() {
        button_save.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.tbsiswaDAO().addTbsiswa(
                    tbsiswa (0,edit_nama.text.toString(),edit_kelas.text.toString(),edit_alamat.text.toString())
                )
                finish()
            }
        }
    }
}