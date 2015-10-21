package br.com.snct2015.grails

import grails.transaction.Transactional

@Transactional
class PessoaService {

    def salvarPessoa(Pessoa pessoa) {
        pessoa.save(flush: true,failOnError: true)
        return  pessoa

    }
}
