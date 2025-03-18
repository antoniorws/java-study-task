package domain;

import java.time.LocalDate;

public class PersonalTask extends BaseTask {

	private static final String TIPO = "PERSONAL";
	
	public PersonalTask() {
	}
	
	public PersonalTask(String titulo, String descricao, LocalDate prazo) {
		super(titulo, descricao, prazo);
	}

	@Override
	public String getTipo() {
		return TIPO;
	}
}
