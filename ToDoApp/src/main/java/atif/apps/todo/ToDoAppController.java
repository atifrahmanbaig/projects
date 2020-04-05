package atif.apps.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import atif.apps.todo.entities.ToDo;
import atif.apps.todo.services.ToDoService;

@RestController
public class ToDoAppController {
	
	@Autowired
	ToDoService service;
	
	@GetMapping(value="/todos")
	public List<ToDo> getAll() {
		return service.getAllToDoItems();
	}

	@GetMapping(value="/todos", params = "isCompleted")
	public List<ToDo> getToDoIteams(@RequestParam("isCompleted") String status) {
		return service.getToDoItemsByCompletedStatus(status);
	}

	@GetMapping("/todos/{description}")
	public ToDo addToDo(@PathVariable String description) {
		return service.addToDoItem(description);
	}

	@PostMapping("/todos/{description}")
	public ToDo addToDoItem(@PathVariable String description) {
		return service.addToDoItem(description);
	}

	@PutMapping(value="/todos/{id}", params = "isCompleted")
	public ToDo updateToDoStatus(@PathVariable Long id, @RequestParam("isCompleted") Boolean isCompleted) {
		return service.updateToDoStatus(id, isCompleted);
	}

	@DeleteMapping(value="/todos/{id}")
	public void deleteToDo(@PathVariable Integer id) {
		service.delete(id);
	}

}