package org.example.br.com.alura.alugames.servicos

import com.google.gson.Gson
import org.example.br.com.alura.alugames.modelo.InfoJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers

class ConsumoApi {
    fun buscaJogo(id: String): InfoJogo? {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        val response: HttpResponse<String> = client
            .send(request, BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()
        var meuInfoJogo:InfoJogo? = null
        val resposta = runCatching { meuInfoJogo = gson.fromJson(json, InfoJogo::class.java) }
         //= gson.fromJson(json, InfoJogo::class.java)
        resposta.onFailure { println("Jogo não encontrado. Tente outro ID.") }
        return meuInfoJogo
    }

}