package gui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import controller.TaskController;
import domain.BaseTask;
import domain.PersonalTask;
import domain.StudyTask;
import domain.WorkTask;

public class MainTask {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		TaskController controller = new TaskController();
		
		System.out.println("AdaTask é um aplicativo de console para gerenciamento de tarefas.");
		System.out.println("Escolha uma das opções disponíveis:");
		int menu = 0;
		while(menu != 9) {
			System.out.println("====================================");
			System.out.println("1 - criar uma tarefa");
			System.out.println("2 - editar uma tarefa");
			System.out.println("3 - remover uma tarefa");
			System.out.println("4 - visualizar uma tarefa");
			System.out.println("5 - visualizar tarefas que expiram hoje");
			System.out.println("9 - Sair do aplicativo");
			System.out.println("====================================");
			menu = leia.nextInt();
			
			switch (menu) {
			case 1: {
				BaseTask task;
				System.out.println("Digite o título da tarefa:");
				String titulo = leia.next();
				System.out.println("Digite a descrição da tarefa:");
				String descricao = leia.next();
		        System.out.println("Digite o tipo da task: \nP - Pessoa\nE - Estudo\nT - Trabalho");
		        String tipo = leia.next();
		        System.out.println("Digite o prazo da tarefa:\nex:ano-mês-dia");
				String prazoString = leia.next();
				LocalDate prazo = LocalDate.parse(prazoString);
		        if(tipo.equals("P")) {
		        	task = new PersonalTask(titulo, descricao, prazo);
		        }else if(tipo.equals("E")) {
		        	task = new StudyTask(titulo, descricao, prazo);
		        }else {
		        	task = new WorkTask(titulo, descricao, prazo);
		        }
		        try {
					controller.criar(task);
				} catch (Exception e) {
					System.out.println("====================================");
					System.out.println(e.getMessage());
				}
				break;
			}
			case 2: {
				Long idTaskLong = removerEditarVisualizar(leia, controller, "editar");
				BaseTask taskEdit = controller.visualizar(idTaskLong);
				if(taskEdit != null) {
					System.out.println("Digite o novo título:");
					String novoTitulo = leia.next();
					System.out.println("Digite a nova descrição:");
					String novaDescricao = leia.next();
					System.out.println("Digite o novo prazo:\nex:ano-mês-dia");
					String novoPrazoString = leia.next();
					LocalDate novoPrazo = LocalDate.parse(novoPrazoString);
					taskEdit.setDescricao(novaDescricao);
					taskEdit.setPrazo(novoPrazo);
					taskEdit.setTitulo(novoTitulo);
					if(controller.editar(idTaskLong, taskEdit) == 0) {
						System.out.println("Tarefa editada com sucesso!!!");
					}else {
						System.out.println("Não foi possível editar a tarefa!");
					}
				}else {
					System.out.println("ID incorreto!");
				}
				break;
			}
			case 3: {
				Long idTaskLong = removerEditarVisualizar(leia, controller, "remover");
				BaseTask taskR = controller.visualizar(idTaskLong);
				if(taskR != null) {
					if(controller.remover(idTaskLong) == 0) {
						System.out.println("Tarefa removida com sucesso!!!");
					}else {
						System.out.println("Não foi possível remover a tarefa!");
					}
				}else {
					System.out.println("ID incorreto!");
				}
				break;
			}
			case 4: {
				Long idTaskLong = removerEditarVisualizar(leia, controller, "visualizar");
				BaseTask task = controller.visualizar(idTaskLong);
				System.out.println(task.toString());
				break;
			}
			case 5: {
				List<BaseTask> tasks = controller.tasksExpiramHoje();
 				for(BaseTask task : tasks) {
					System.out.println(task.toString());
					System.out.println("====================================");
				}
 				break;
			}
			default:
				System.out.println("====================================");
				System.out.println("Não existe este valor no menu");
			}
		}
		System.out.println("Até a proxima!");
		
	}

	private static Long removerEditarVisualizar(Scanner leia, TaskController controller, String acao) {
		List<BaseTask> tasks = controller.visualizarTudo();
		System.out.println("====================================");
		for(BaseTask task : tasks) {
			System.out.println("ID: " + task.getId() + ", Título: " + task.getTitulo());
		}
		System.out.println("====================================");
		System.out.println("Digite o id da task que deseja " + acao + ":");
		String idTask = leia.next();
		Long idTaskLong = Long.parseLong(idTask);
		return idTaskLong;
	}

}
