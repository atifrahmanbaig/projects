package atif.apps.todo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import atif.apps.todo.entities.ToDo;

public interface ToDoRepository extends CrudRepository<ToDo, Integer> 
{
	List<ToDo> findByCompleted(boolean isCompleted);
	ToDo findOneById(long id);
}