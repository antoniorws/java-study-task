package controller;

import java.util.List;

import domain.BaseTask;
import service.TaskService;
import service.impl.TaskServiceImpl;

public class TaskController {
	
	private TaskService service = new TaskServiceImpl();;
	
	public TaskController() {
	}

	public void criar(BaseTask t) throws Exception {
		service.criar(t);
	}

	
	public int editar(Long v, BaseTask t) {
		return service.editar(v, t);
	}

	
	public int remover(Long v) {
		return service.remover(v);
	}

	
	public BaseTask visualizar(Long v) {
		return service.visualizar(v);
	}
	
	public List<BaseTask> visualizarTudo(){
		return service.visualizarTudo();
	}
	
	public List<BaseTask> tasksExpiramHoje() {
		return service.tasksExpiramHoje();
	}
}
