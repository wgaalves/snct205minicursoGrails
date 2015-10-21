package br.com.snct2015.grails

class Pessoa extends Usuario {

    String nome
    Date dataNasc
    String cpf
    String telefone
    String email

    static constraints = {
    }
}
