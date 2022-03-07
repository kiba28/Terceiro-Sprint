package uol.compass.avaliacao.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class State implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	@Enumerated(EnumType.STRING)
	private Regions regiao;
	private int populacao;
	private String capital;
	private double area;
	private LocalDate dataDeFundacao;
	private int tempoDesdeFundacao;

	public State() {
	}

	public State(String nome, Regions regiao, int populacao, String capital, double area, LocalDate dataDeFundacao,
			int tempoDesdeFundacao) {
		this.nome = nome;
		this.regiao = regiao;
		this.populacao = populacao;
		this.capital = capital;
		this.area = area;
		this.dataDeFundacao = dataDeFundacao;
		this.tempoDesdeFundacao = tempoDesdeFundacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Regions getRegiao() {
		return regiao;
	}

	public void setRegiao(Regions regiao) {
		this.regiao = regiao;
	}

	public int getPopulacao() {
		return populacao;
	}

	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public LocalDate getDataDeFundacao() {
		return dataDeFundacao;
	}

	public void setDataDeFundacao(LocalDate dataDeFundacao) {
		this.dataDeFundacao = dataDeFundacao;
	}

	public int getTempoDesdeFundacao() {
		return tempoDesdeFundacao;
	}

	public void setTempoDesdeFundacao(int tempoDesdeFundacao) {
		this.tempoDesdeFundacao = tempoDesdeFundacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(area, id, populacao, regiao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		return Double.doubleToLongBits(area) == Double.doubleToLongBits(other.area) && id == other.id
				&& populacao == other.populacao && regiao == other.regiao;
	}

}
