package uol.compass.avaliacao.resources.dto;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import uol.compass.avaliacao.entities.State;
import uol.compass.avaliacao.entities.Regions;

public class StateDto {

	private long id;
	private String nome;
	private Regions regiao;
	private int populacao;
	private String capital;
	private double area;
	private LocalDate dataDeFundacao;
	private int tempoDesdeFundacao;

	public StateDto(State state) {
		this.id = state.getId();
		this.nome = state.getNome();
		this.regiao = state.getRegiao();
		this.populacao = state.getPopulacao();
		this.capital = state.getCapital();
		this.area = state.getArea();
		this.dataDeFundacao = state.getDataDeFundacao();
		this.tempoDesdeFundacao = state.getTempoDesdeFundacao();
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

	public static Page<StateDto> converter(Page<State> states) {
		return states.map(StateDto::new);
	}

}
