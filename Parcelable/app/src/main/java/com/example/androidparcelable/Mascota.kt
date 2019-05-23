package com.example.androidparcelable

import android.os.Parcelable
import android.os.Parcel

class Mascota(var nombre: String,
              var usuario: Usuario): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readParcelable(Usuario::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeParcelable(usuario, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : android.os.Parcelable.Creator<Mascota> {
        override fun createFromParcel(parcel: Parcel): Mascota {
            return Mascota(parcel)
        }

        override fun newArray(size: Int): Array<Mascota?> {
            return arrayOfNulls(size)
        }
    }

}