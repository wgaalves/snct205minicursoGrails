package br.com.snct2015.grails

class Endereco {

    static  belongsTo = [pessoa:Pessoa]

    String rua
    String bairro
    String cidade
    String ceṕ

    static constraints = {
    }
}
