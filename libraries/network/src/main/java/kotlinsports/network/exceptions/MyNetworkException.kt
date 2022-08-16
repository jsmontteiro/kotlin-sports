package kotlinsports.network.exceptions

open class MyNetworkException(message: String? = null, cause: Throwable? = null) :
    Exception(message ?: cause?.message, cause)