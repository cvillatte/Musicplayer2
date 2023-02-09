package com.example.musicplayer2.res

import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun providesRetrofitt(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit{
        return Retrofit.Builder()
            .baseUrl(ItunesAPI.BASE_URL)
            .addConverterFactroy(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor) : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .readTimeout( 30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
    }
    @Singleton
    @Provides
    fun provideItunesAPI(retrofit: Retrofit) : ItunesAPI {
        return retrofit.create(ItunesAPI::class.java)
    }
    )
}