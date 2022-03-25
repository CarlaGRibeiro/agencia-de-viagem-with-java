//Para registrar viagens e para uso do administrador da agência ou Gerente do bd.
package tardis.agencia;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "viagens")
public class Viagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (nullable = false, unique = true, length = 6)
	private long id;

	@Column(name = "NomeSobrenome", nullable = false, unique = false, length = 30)
	private String NomeSobrenome;

	@Column(name = "Origem", nullable = false, unique = true, length = 15)
	private String Origem;

	@Column(name = "Destino", nullable = false, unique = false, length = 15)
	private String Destino;
	
	@Column(name = "DataHoraViagem", nullable = false, unique = true, length = 20)
	@DateTimeFormat (pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime DataHoraViagem;
	
	

	
	public Viagem() {
	}




	public Viagem(long id, String nomeSobrenome, String origem, String destino, LocalDateTime dataHoraViagem) {
		super();
		this.id = id;
		this.NomeSobrenome = nomeSobrenome;
		this.Origem = origem;
		this.Destino = destino;
		this.DataHoraViagem = dataHoraViagem;
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getNomeSobrenome() {
		return NomeSobrenome;
	}




	public void setNomeSobrenome(String nomeSobrenome) {
		NomeSobrenome = nomeSobrenome;
	}




	public String getOrigem() {
		return Origem;
	}




	public void setOrigem(String origem) {
		Origem = origem;
	}




	public String getDestino() {
		return Destino;
	}




	public void setDestino(String destino) {
		Destino = destino;
	}




	public LocalDateTime getDataHoraViagem() {
		return DataHoraViagem;
	}




	public void setDataHoraViagem(LocalDateTime dataHoraViagem) {
		DataHoraViagem = dataHoraViagem;
	}
	
	

}

