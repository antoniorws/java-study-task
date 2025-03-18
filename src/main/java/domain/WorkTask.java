package domain;

import java.time.LocalDate;

public class WorkTask extends BaseTask {

	private static final String TIPO = "WORK";
	
	public WorkTask() {	
	}
	
	public WorkTask(String titulo, String descricao, LocalDate prazo) {
		super(titulo, descricao, prazo);
	}

	@Override
	public String getTipo() {
		return TIPO;
	}
}
