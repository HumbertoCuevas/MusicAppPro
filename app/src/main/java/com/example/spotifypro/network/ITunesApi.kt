package com.example.spotifypro.network
import com.example.spotifypro.model.ITunesResponse
import retrofit2.http.GET
import retrofit2.http.Query

//archivo para la consulta de infromacion (local o internet)

interface ITunesApi {
    //indicar metodo http a usar
    @GET("search")

    //meetodo para obtener la informacion con la URL del API
    fun obtenerAlbumGenero(

        @Query("term") genero : String,
        @Query("country") pais : String,
        @Query("media") media : String,
        @Query("entity") entidad : String,
        @Query("limit") limite : Int,
    ) : retrofit2.Call<ITunesResponse>



}