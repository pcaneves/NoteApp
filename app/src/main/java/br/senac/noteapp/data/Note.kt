package br.senac.noteapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity =  transforma uma classe em uma tabela
@Entity
data class Note(
    //@PrimaryKey = determina a proxima coluna como chave primaria
    //autoGenerate = determina que o campo de chave primaria sera gerada automaticamanete
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var title: String,
    //@ColumnInfo =  para renomear uma coluna
    //exemplo - @ColumnInfo(name = "description")
    var desc: String
    )
