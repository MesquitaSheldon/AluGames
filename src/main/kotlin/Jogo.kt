package org.example

import com.google.gson.annotations.SerializedName

class Jogo (@SerializedName("title") val titulo:String,
            @SerializedName("thumb") val capa:String,
            val descricao: String){

    override fun toString(): String {
        return "Meu Jogo = $titulo\n," +
                "capa = $capa,\n" +
                "descricao = $descricao."
    }
}