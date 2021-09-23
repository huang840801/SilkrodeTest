package com.guanhong.silkrodetest

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Users(

    val users: List<User>
)

data class User(

    @SerializedName("login") val name: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    val id: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(avatarUrl)
        parcel.writeString(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}
