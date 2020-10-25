package bunkou.tms.HomeWork8

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import bunkou.tms.HomeWork8.dao.Bakedao
import bunkou.tms.HomeWork8.entity.Bake

@Database(entities = arrayOf(Bake::class), version = 1)

abstract class BakeDb : RoomDatabase() {

    abstract fun bakedao(): Bakedao
}

object Db {

    fun getDB(ctx: Context) =
        Room.databaseBuilder(ctx, BakeDb::class.java, "BakeDataBase").build()

}