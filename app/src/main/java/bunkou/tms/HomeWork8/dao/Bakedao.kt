package bunkou.tms.HomeWork8.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import bunkou.tms.HomeWork8.entity.Bake


@Dao
interface Bakedao {

    @Insert
    suspend fun addBake(bake: Bake)

    @Delete
    suspend fun deleteBake(bake: Bake)

    @Query("SELECT* FROM bake_table")
    suspend fun allbake_table(): List<Bake>

    @Query(" DELETE FROM bake_table WHERE id=:id")
    suspend fun deletePersonById(id: Int)

    @Query("SELECT * FROM bake_table WHERE bake_maxSpeed>:maxSpeed")
    suspend fun highest_Speed(maxSpeed: Int): List<Bake>

    @Query("SELECT * FROM bake_table WHERE bake_price>:price")
    suspend fun highest_Price(price: Int): List<Bake>

    @Query("SELECT * FROM bake_table WHERE bake_weight>:weight")
    suspend fun highest_weight(weight: Int): List<Bake>

    @Query("DELETE FROM bake_table")
    suspend fun clearDatabase()

}