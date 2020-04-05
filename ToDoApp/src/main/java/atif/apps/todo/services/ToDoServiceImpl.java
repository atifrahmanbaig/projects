package atif.apps.todo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atif.apps.todo.dao.ToDoRepository;
import atif.apps.todo.entities.ToDo;

@Service
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	ToDoRepository toDoRepository;
	
	public ToDo addToDoItem(String description) {
		ToDo task = new ToDo();
		task.setDescription(description);
		task = toDoRepository.save(task);
		System.out.println("ToDo Item Saved ("+ task.getId()+" - " + task.getDescription()+" - " + task.getCreatedOn());
		return task;
	}
	
	public ToDo updateToDoStatus(long id, boolean isComplete) {
		ToDo todoItem = toDoRepository.findOneById(id);
		todoItem.setCompleted(isComplete);
		todoItem.setCompletedOn(isComplete?new Date():null);
		toDoRepository.save(todoItem);
		return todoItem;
	}

	public void delete(Integer id) {
		toDoRepository.delete(toDoRepository.findOneById(id));
	}


	public List<ToDo> getAllToDoItems() {
		List<ToDo> list = (List<ToDo>)toDoRepository.findAll();
		System.out.println(""+ list);
		return list;
	}

	public List<ToDo> getToDoItemsByCompletedStatus(String status) {
		List<ToDo> list = null;
		if ("ALL".equalsIgnoreCase(status)) {
			list = (List<ToDo>)toDoRepository.findAll();
		} else {
			list = toDoRepository.findByCompleted("COMPLETED".equalsIgnoreCase(status));
		}
		System.out.println("status: "+ status + " - List: "+ list);
		return list;
	}

}