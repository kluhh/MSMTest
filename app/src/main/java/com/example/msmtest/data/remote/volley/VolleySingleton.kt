package com.example.msmtest.data.remote.volley

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

/*
The RequestQueue object in Volley is a core component responsible
for managing and handling network requests in an Android application.
It acts as a queue that holds the network requests and dispatches them to the network for execution.
*/

object VolleySingleton {
    private var requestQueue: RequestQueue? = null

    fun getRequestQueue(context: Context): RequestQueue {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.applicationContext)
        }
        return requestQueue!!
    }
}
