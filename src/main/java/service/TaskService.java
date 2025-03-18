package service;

import java.util.List;

import domain.BaseTask;

public interface TaskService extends GenericService<BaseTask, Long> {

	List<BaseTask> visualizarTudo();
	List<BaseTask> tasksExpiramHoje();
}
