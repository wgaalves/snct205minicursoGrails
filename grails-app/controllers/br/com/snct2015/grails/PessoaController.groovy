package br.com.snct2015.grails

class PessoaController {
    def pessoaService

    def index() { }


    def cadastro(){}

    def salvar(){
        def pessoa = new Pessoa(params)
        pessoa.codigoConfirmacao = UUID.randomUUID().toString()
        def pessoaSalva = pessoaService.salvarPessoa(pessoa)
        enviarEmail(pessoaSalva)

        redirect(controller: 'pessoa' , action: 'index')


    }

    def enviarEmail(pessoa){
        mailService.sendMail {
            to pessoa.email //pode ser lista de emails ou 1 email
            subject "confirmacao de Email"
            html g.render(template: "confirmacao", model: [code:code])

        }
    }
}
