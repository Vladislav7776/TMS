package bunkou.tms.HomeWork8.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "bake_table")
data class Bake(

    @ColumnInfo(name = "bake_name")
    val name: String,
    @ColumnInfo(name = "bake_maxSpeed")
    val maxSpeed: Int,
    @ColumnInfo(name = "bake_weight")
    val weight: Double,
    @ColumnInfo(name = "bake_price")
    val price: Double,
    @ColumnInfo(name = "bake_photoUrl")
    val photoUrl: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}


