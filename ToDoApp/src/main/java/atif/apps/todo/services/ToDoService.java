package atif.apps.todo.services;

import java.util.List;

import atif.apps.todo.entities.ToDo;

public interface ToDoService {
	ToDo addToDoItem(String todoDesc);
	ToDo updateToDoStatus(long id, boolean isCompleted);
	void delete(Integer id);
	List<ToDo> getAllToDoItems();
	List<ToDo> getToDoItemsByCompletedStatus(String status);
}