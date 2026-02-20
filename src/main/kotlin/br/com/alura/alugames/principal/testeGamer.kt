package br.com.alura.alugames.principal

import org.example.br.com.alura.alugames.modelo.Gamer

fun main(){
    val gamer1 = Gamer(nome = "Gamer 1",
        email = "Gamer 1 email")
    println(gamer1)

    val gamer2 = Gamer(nome = "Gamer 2",
        email = "Gamer 2 email",
        dataNascimento = "13/01/2000",
        usuario = "Ratchü")

    println(gamer2)

    gamer1.let{
        it.dataNascimento = "18/09/2000"
        it.usuario = "Jacque Skywalker"
        it.idInterno = "Jacque Skywalker12523"
    }

    println(gamer1)

}
