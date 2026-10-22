package com.example.spotifypro.model

//Archivo para recibir la respuesta de confirmacion del api

data class ITunesResponse(

    val resultCount : Int,
    val results : List<Album>
)
