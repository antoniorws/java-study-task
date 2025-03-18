package repository;

import java.util.List;

import domain.BaseTask;

public interface TaskRepository extends GenericDAO<BaseTask, Long> {

	List<BaseTask> visualizarTudo();
	int getIndex(Long id);
	List<BaseTask> tasksExpiramHoje();
}
