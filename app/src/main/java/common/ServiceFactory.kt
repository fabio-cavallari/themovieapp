package common

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object ServiceFactory {
    fun getBaseRetrofitClient(
        baseURL: String,
    ): Retrofit.Builder {
        return Retrofit.Builder()
            .client(getOKHTTPClient())
            .baseUrl(baseURL)
            .addConverterFactory(JacksonConverterFactory.create(ObjectMapper()))
    }

    private fun getOKHTTPClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(getLoggingInterceptor())
            .build()
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}