package com.utils

class UIStatesealedtask {

    object LOADING : UIState()
    data class SUCCESS(val response: List<SchoolsItem>) : UIState()
    data class ERROR(val error: Exception) : UIState()
}