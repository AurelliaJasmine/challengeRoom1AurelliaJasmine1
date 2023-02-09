package com.example.challengeroom1aurelliajasmine.room

import androidx.room.*

@Dao
interface tbsiswaDAO {
    @Insert
    fun addTbsiswa(tbsiswa: tbsiswa)

    @Update
    fun updateTbsiswa(tbsiswa: tbsiswa)

    @Delete
    fun deleteTbsiswa(tbsiswa: tbsiswa)

    @Query("SELECT*FROM tbsiswa ORDER BY nis ASC")
    fun getTbsiswa(): List<tbsiswa>

    @Query("SELECT*FROM tbsiswa WHERE nis=:note_nis")
    fun getsiswa(note_nis: Int): List<tbsiswa>
}