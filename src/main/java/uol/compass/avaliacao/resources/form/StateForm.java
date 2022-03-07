package uol.compass.avaliacao.resources.form;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import uol.compass.avaliacao.config.validacao.MismatchInformationException;
import uol.compass.avaliacao.entities.State;
import uol.compass.avaliacao.entities.Regions;

public class StateForm {

	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	private Regions regiao;
	@NotNull
	private int populacao;
	@NotNull
	@NotEmpty
	private String capital;
	@NotNull
	private double area;
	@NotNull
	private LocalDate dataDeFundacao;
	@NotNull
	private int tempoDesdeFundacao;

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

	public State converter() {
		if (Period.between(this.dataDeFundacao, LocalDate.now()).getYears() == this.tempoDesdeFundacao) {
			return new State(nome, regiao, populacao, capital, area, dataDeFundacao, tempoDesdeFundacao);
		} else {
			throw new MismatchInformationException();
		}
	}
}
