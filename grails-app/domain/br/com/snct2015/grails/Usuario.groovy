package br.com.snct2015.grails

class Usuario implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String username
	String password
	String codigoConfirmacao = null
	boolean enabled = false
	boolean accountExpired = false
	boolean accountLocked = false
	boolean passwordExpired = false

	@Override
	int hashCode() {
		username?.hashCode() ?: 0
	}

	@Override
	boolean equals(other) {
		is(other) || (other instanceof Usuario && other.username == username)
	}

	@Override
	String toString() {
		username
	}

	Set<Role> getAuthorities() {
		UsuarioRole.findAllByUsuario(this)*.role
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}
}
