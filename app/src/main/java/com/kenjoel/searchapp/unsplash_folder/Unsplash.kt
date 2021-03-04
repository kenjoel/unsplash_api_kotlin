package com.kenjoel.searchapp.unsplash_folder

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Unsplash(
    val id:Int,
    val description:String,
    val user: User,
    val urls: Urls
    ): Parcelable {


    @Parcelize
    class User(
        val name: String,
        val username : String
    ): Parcelable {
        val attribution get() = "https://unsplash.com/$username?utm_source=search_app&utm_medium=referral"

    }


    @Parcelize
    class Urls(
        val raw:String,
        val full:String,
        val regular:String,
        val small:String,
        val thumb: String
    ): Parcelable {

    }
}
