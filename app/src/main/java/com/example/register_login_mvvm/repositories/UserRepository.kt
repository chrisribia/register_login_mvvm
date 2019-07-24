package com.example.register_login_mvvm.repositories

import com.example.register_login_mvvm.data.entities.AppDatabase
import com.example.register_login_mvvm.data.entities.User
import com.example.register_login_mvvm.data.network.MyApi
import com.example.register_login_mvvm.data.network.SafeApiResponse
import com.example.register_login_mvvm.data.network.responses.AuthResponse

class UserRepository(
    val api : MyApi,
    val db : AppDatabase
) : SafeApiResponse() {

suspend fun userLogin(email : String, password: String): AuthResponse{
    return apiRequest{api.userLogin(email,password)}
}


    suspend fun userRegister(email: String,name: String,password: String): AuthResponse{
        return apiRequest { api.userregister(name,email,password) }
    }
    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getuser()

}