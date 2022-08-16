package kotlinsports.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken

internal const val apiDateFormat = "yyyy-MM-dd'T'HH:mm:ss"
val gsonDefault: Gson = GsonBuilder()
    .setDateFormat(apiDateFormat)
    .create()
