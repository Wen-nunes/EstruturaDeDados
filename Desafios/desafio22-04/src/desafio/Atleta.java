package desafio;
import java.util.Objects;


public class Atleta {
	public String fone;
	public String nome;
	public String apelido;
	public String dataDeNascimento;
	public String pontuacao;
	
	public Atleta() {
		
	}

	public Atleta(String fone, String nome, String apelido, String dataDeNascimento, String pontuacao) {
		super();
		this.fone = fone;
		this.nome = nome;
		this.apelido = apelido;
		this.dataDeNascimento = dataDeNascimento;
		this.pontuacao = pontuacao;
	}

	@Override
	public String toString() {
		return "Atleta [fone=" + fone + ", nome=" + nome + ", apelido=" + apelido + ", dataDeNascimento="
				+ dataDeNascimento + ", pontuacao=" + pontuacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atleta other = (Atleta) obj;
		return Objects.equals(nome, other.nome);
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(String pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	

}
