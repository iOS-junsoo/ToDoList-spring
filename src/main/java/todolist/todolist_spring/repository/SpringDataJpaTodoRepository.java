package todolist.todolist_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todolist.todolist_spring.domain.Todo;

public interface SpringDataJpaTodoRepository extends JpaRepository<Todo, Long>, TodoRepository{

}
