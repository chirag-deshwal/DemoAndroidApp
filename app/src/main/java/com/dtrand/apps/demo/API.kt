package com.dtrand.apps.demo

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


class API {

    class Modal(var fileSizeBytes : Int, var url : String)

  interface Callback {
        @GET("/woof.json")
        fun  fetch() : Call<Modal>

        @POST("/woof")
        fun sent(@Body requestBody: Modal) : Call<Modal>

    }

}