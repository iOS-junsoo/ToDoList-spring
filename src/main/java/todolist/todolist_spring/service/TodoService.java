package todolist.todolist_spring.service;

import org.springframework.transaction.annotation.Transactional;
import todolist.todolist_spring.domain.Todo;
import todolist.todolist_spring.repository.TodoRepository;

import java.util.List;
import java.util.Optional;


@Transactional
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo addTodo(String title, String description) {
        Todo todo = new Todo(null, title, description);
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo completeTodo(Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);

        if (optionalTodo.isPresent()) { //해당 아이디를 가진 투두가 있다면 완료 조치
            Todo todo = optionalTodo.get();
            todo.setCompleted(true);
            return todo;
//            return todoRepository.save(todo);
        } else {
            return null;
        }
    }

    public void deleteTodoById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        todoRepository.deleteById(id);
    }
}
