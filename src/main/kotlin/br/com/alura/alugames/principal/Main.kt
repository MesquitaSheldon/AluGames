package org.example.br.com.alura.alugames.principal

import org.example.br.com.alura.alugames.modelo.InfoJogo
import org.example.br.com.alura.alugames.modelo.Jogo
import org.example.br.com.alura.alugames.servicos.ConsumoApi
import java.util.*

fun main() {
    val leitura = Scanner(System.`in`)
    println("Escreva o código de jogo:")
    val busca = leitura.nextLine()

    val apiBusca = ConsumoApi()
    val informacaoJogo = apiBusca.buscaJogo(busca) ?: return

    var meuJogo: Jogo? = null
    val resultado = runCatching {
        meuJogo = Jogo(
            informacaoJogo.info.title,
            informacaoJogo.info.thumb
        )
    }

    resultado.onFailure {
        println("Jogo inexistente ou formato inválido. Tente outro ID.")
    }

    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada para" +
                "'${meuJogo?.titulo}'? S/N")
        val opcao = leitura.nextLine()
        if(opcao.equals("S", true)) {
            println("Insira a descrição desejada:")
            val descPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descPersonalizada
        } else {
            meuJogo?.descricao = meuJogo.titulo
        }

        println(meuJogo)
    }

    resultado.onFailure {
        println("Jogo não encontrado!")
    }

}