package com.littlelemon.stocklookup.network

import com.littlelemon.stocklookup.model.Stock
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

// Add interceptor for the API key
val client = OkHttpClient.Builder().addInterceptor { chain ->
    val request = chain.request().newBuilder()
        .addHeader("X-RapidAPI-Key", "a324abea73mshe578368a310e386p1c7d4bjsn8b2a6cc0d4a7")
        .addHeader("X-RapidAPI-Host", "yh-finance.p.rapidapi.com")
        .build()
    chain.proceed(request)
}.build()

val retrofit = Retrofit.Builder()
    .baseUrl("https://yh-finance.p.rapidapi.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .client(client)
    .build()

// Retrofit Service Interface
interface StockApiService {
    @GET("stock/v3/get-historical-data")
    suspend fun getStockData(
        @Query("symbol") symbol: String,
        @Query("region") region: String = "US"
    ): Stock
}

// Singleton object to access Retrofit
object StockApi {
    val retrofitService: StockApiService by lazy {
        retrofit.create(StockApiService::class.java)
    }
}
