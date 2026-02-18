package org.example

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner


fun main() {
    val leitura = Scanner(System.`in`)
    println("Escreva o código de jogo: ")
    val busca = leitura.nextLine()

    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$busca"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()

    val response: HttpResponse<String> = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()
    //println(json)

//    Primeiro Teste
//    val meuJogo = Jogo(
//        "LEGO Batman",
//        "https://cdn.fanatical.com/production/product/400x225/105f34ca-7757-47ad-953e-7df7f016741e.jpeg",
//        "")
//
//    println(meuJogo)

    // Usando o Gson para preencher o objeto JOGO
    val gson = Gson()
    // Alterado o construtor do InfoJogo para InfoApiShark para poder
    // pegar os dados dentro do info e criar o Jogo propriamente dito
    val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
//    println(meuJogo)
    val meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
    println(meuJogo)
}