package tardis.agencia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (unique = true, length = 6)
	private long id;

	@Column(name = "Nome", nullable = false, unique = false, length = 15)
	private String Nome;

	@Column(name = "Sobrenome", nullable = false, unique = false, length = 15)
	private String Sobrenome;

	@Column(name = "Email", nullable = false, unique = true, length = 60)
	private String Email;

	@Column(name = "CPF", nullable = false, unique = true, length = 15)
	private String CPF;

	@Column(name = "Endereço", nullable = false, unique = false, length = 30)
	private String Endereco;

	@Column(name = "Numero", nullable = false, unique = false, length = 7)
	private String Numero;

	@Column(name = "Complemento", nullable = false, unique = false, length = 20)
	private String Complemento;

	@Column(name = "Bairro", nullable = false, unique = false, length = 20)
	private String Bairro;

	@Column(name = "Cidade", nullable = false, unique = false, length = 25)
	private String Cidade;

	@Column(name = "Estado", nullable = false, unique = false, length = 20)
	private String Estado;

	@Column(name = "Pais", nullable = false, unique = false, length = 15)
	private String Pais;

	@Column(name = "Senha", nullable = false, unique = false, length = 20)
	private String Senha;
	
	
	
	public Usuario() {
	}



	public Usuario(long id, String nome, String sobrenome, String email, String cPF, String endereco,
			String numero, String complemento, String bairro, String cidade, String estado, String pais, String senha) {
		super();
		this.id = id;
		this.Nome = nome;
		this.Sobrenome = sobrenome;
		this.Email = email;
		this.CPF = cPF;
		this.Endereco = endereco;
		this.Numero = numero;
		this.Complemento = complemento;
		this.Bairro = bairro;
		this.Cidade = cidade;
		this.Estado = estado;
		this.Pais = pais;
		this.Senha = senha;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNome() {
		return Nome;
	}



	public void setNome(String nome) {
		Nome = nome;
	}



	public String getSobrenome() {
		return Sobrenome;
	}



	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	public String getCPF() {
		return CPF;
	}



	public void setCPF(String cPF) {
		CPF = cPF;
	}



	public String getEndereco() {
		return Endereco;
	}



	public void setEndereco(String endereco) {
		Endereco = endereco;
	}



	public String getNumero() {
		return Numero;
	}



	public void setNumero(String numero) {
		Numero = numero;
	}



	public String getComplemento() {
		return Complemento;
	}



	public void setComplemento(String complemento) {
		Complemento = complemento;
	}



	public String getBairro() {
		return Bairro;
	}



	public void setBairro(String bairro) {
		Bairro = bairro;
	}



	public String getCidade() {
		return Cidade;
	}



	public void setCidade(String cidade) {
		Cidade = cidade;
	}



	public String getEstado() {
		return Estado;
	}



	public void setEstado(String estado) {
		Estado = estado;
	}



	public String getPais() {
		return Pais;
	}



	public void setPais(String pais) {
		Pais = pais;
	}



	public String getSenha() {
		return Senha;
	}



	public void setSenha(String senha) {
		Senha = senha;
	}




	

	
	
}
