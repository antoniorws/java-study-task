package repository.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domain.BaseTask;
import repository.TaskRepository;

public class TaskRepositoryImpl implements TaskRepository{

	private static List<BaseTask> baseDados = new ArrayList<>();
	
	@Override
	public void criar(BaseTask t) {
		baseDados.add(t);
	}

	@Override
	public int editar(Long v, BaseTask t) {
		int index = this.getIndex(v);
		if(index != -1) {
			baseDados.get(index).setDescricao(t.getDescricao());
			baseDados.get(index).setPrazo(t.getPrazo());
			baseDados.get(index).setTitulo(t.getTitulo());
			return 0;
		}
		return -1;
	}

	@Override
	public int remover(Long v) {
		if(baseDados.remove(this.visualizar(v))) 
			return 0;
		
		return -1;
		
	}

	@Override
	public BaseTask visualizar(Long v) {
		for(int i = 0; i < this.baseDados.size(); i++) {
			BaseTask task = this.baseDados.get(i);
			if(task.getId().equals(v)) {
				return task;
			}
		}
		return null;
	}

	@Override
	public List<BaseTask> visualizarTudo() {
		return this.baseDados;
	}

	@Override
	public int getIndex(Long id) {
		for(int i = 0; i < this.baseDados.size(); i++) {
			BaseTask task = this.baseDados.get(i);
			if(task.getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public List<BaseTask> tasksExpiramHoje() {
		List<BaseTask> tasks = new ArrayList<>();
		for(BaseTask task : this.baseDados) {
			if(task.getPrazo().isEqual(LocalDate.now())) {
				tasks.add(task);
			}
		}
		return tasks;
	}
}
