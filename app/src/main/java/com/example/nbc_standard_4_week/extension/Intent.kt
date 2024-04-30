package com.example.nbc_standard_4_week.extension

import android.app.Activity
import android.os.Parcelable

inline fun <reified T: Parcelable> Activity.getParcelableExtra(key:String) =
    lazy { intent.getParcelableExtra<T>(key) }