package service.impl;

import java.time.LocalDate;
import java.util.List;

import domain.BaseTask;
import repository.TaskRepository;
import repository.impl.TaskRepositoryImpl;
import service.TaskService;

public class TaskServiceImpl implements TaskService {

	private TaskRepository repository = new TaskRepositoryImpl();
	
	public TaskServiceImpl() {
	}
	
	@Override
	public void criar(BaseTask t) throws Exception {
		validaTask(t);
		repository.criar(t);	
	}
	
	private void validaTask(BaseTask t) throws Exception {
		if(t.getPrazo().isBefore(LocalDate.now())) {
			throw new Exception("Não é possível criar tarefas no passado!");
		}
	}

	@Override
	public int editar(Long v, BaseTask t) {
		return repository.editar(v, t);
	}

	@Override
	public int remover(Long v) {
		return repository.remover(v);
	}

	@Override
	public BaseTask visualizar(Long v) {
		return repository.visualizar(v);
	}

	@Override
	public List<BaseTask> visualizarTudo() {
		return repository.visualizarTudo();
	}

	@Override
	public List<BaseTask> tasksExpiramHoje() {
		return repository.tasksExpiramHoje();
	}

}
