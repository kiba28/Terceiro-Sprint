package uol.compass.avaliacao.resources.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import uol.compass.avaliacao.entities.State;
import uol.compass.avaliacao.repositories.StateRepository;

public class UpdateStateForm {

	@NotNull
	private int populacao;
	@NotNull
	@NotEmpty
	private String capital;
	@NotNull
	private double area;

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

	public State atualizar(Long id, StateRepository estadoRespository) {
		State state = estadoRespository.getById(id);
		state.setPopulacao(this.populacao);
		state.setCapital(this.capital);
		state.setArea(this.area);

		return state;
	}
}
