package com.ahmet.tamplate

import com.info.retrofitkullanimi.RetrofitClient

class ApiUtils {

    companion object {

        val BASE_URL =
            "https://api.themoviedb.org/3/"

        fun getKategorilerDaoInterface(): KategorilerDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(KategorilerDaoInterface::class.java)
        }
        fun getDetaylarDaoInterface(): DetaylarDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(DetaylarDaoInterface::class.java)
        }
    }}