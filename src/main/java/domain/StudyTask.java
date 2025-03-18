package domain;

import java.time.LocalDate;

public class StudyTask extends BaseTask {

	private static final String TIPO = "STUDY";
	
	public StudyTask() {
	}
	
	public StudyTask(String titulo, String descricao, LocalDate prazo) {
		super(titulo, descricao, prazo);
	}

	@Override
	public String getTipo() {
		return TIPO;
	}
}
