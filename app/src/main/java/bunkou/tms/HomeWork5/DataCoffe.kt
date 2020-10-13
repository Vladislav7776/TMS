package bunkou.tms.HomeWork5

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataCoffe(
    val sort: String,
    val price: Double,
    val imageURL: String
) : Parcelable {

}
