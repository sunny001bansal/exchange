package com.sunny.usdpln.di.modules

import android.text.format.DateUtils
import com.google.gson.Gson
import com.sunny.usdpln.network.APIService
import com.sunny.usdpln.repository.MyRepository
import com.sunny.usdpln.repository.impl.MyRepositoryImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideGsonConvertorFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .connectTimeout(DateUtils.MINUTE_IN_MILLIS, TimeUnit.MILLISECONDS)
            .writeTimeout(DateUtils.MINUTE_IN_MILLIS, TimeUnit.MILLISECONDS)
            .readTimeout(DateUtils.MINUTE_IN_MILLIS, TimeUnit.MILLISECONDS)
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(interceptor)
        return client.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        mFactory: GsonConverterFactory,
        mClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .client(mClient)
        .baseUrl("https://api.exchangeratesapi.io")
        .addConverterFactory(mFactory)
        .build()

    @Provides
    @Singleton
    fun provideApiService(mRetrofit: Retrofit): APIService =
        mRetrofit.create(APIService::class.java)

    @Provides
    @Singleton
    fun provideApiRepository(mApiService: APIService): MyRepository = MyRepositoryImpl(mApiService)
}