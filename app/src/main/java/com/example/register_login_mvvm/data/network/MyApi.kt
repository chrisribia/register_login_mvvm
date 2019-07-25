package com.example.register_login_mvvm.data.network


import com.example.mvvm.data.ui.data.network.NetworkConnectionInterceptor
import com.example.register_login_mvvm.data.network.responses.AuthResponse
import com.example.register_login_mvvm.data.network.responses.QuotesResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface MyApi {

    @FormUrlEncoded
    @POST("userlogin")
    suspend fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ) : Response<AuthResponse>


    @FormUrlEncoded
    @POST("createuser")
    suspend fun userregister(
        @Field("name") username: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<AuthResponse>


    @GET("allquotes")
    suspend fun getQuotes() : Response<QuotesResponse>

    companion object{
        operator fun invoke(
            networkConnectionInterceptor : NetworkConnectionInterceptor
        ) : MyApi{

            val okkHttpClient = OkHttpClient.Builder()
                .addInterceptor( networkConnectionInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okkHttpClient)
                .baseUrl("http://192.168.1.54/MyApi/public/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi ::class.java)
        }
    }
}