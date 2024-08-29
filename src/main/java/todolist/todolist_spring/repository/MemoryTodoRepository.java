package todolist.todolist_spring.repository;

import org.springframework.stereotype.Repository;
import todolist.todolist_spring.domain.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Repository
public class MemoryTodoRepository implements TodoRepository {

    private List<Todo> todoList = new ArrayList<>(); //
    private Long nextId = 0L; // 할 일 ID를 생성할 때 사용

    @Override
    public Todo save(Todo todo) {
        todo.setId(++nextId); //ID 생성해서 객체에 저장
        todoList.add(todo); //todo 객체를 리스트에 저장
        return todo;
    }

    @Override
    public Optional<Todo> findById(Long id) {
        return todoList.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(todoList);
        //todoList 리스트를 복사하여 반환
    }

    @Override
    public void deleteById(Long id) {
        todoList.removeIf(todo -> todo.getId().equals(id));
        //removeIf 괄호 내부의 값이 true라면 해당 값을 삭제하는 것이다.
        //따라서 todo값을 넣고 그 값에서 id가 입력된 id와 같다면 삭제를 하는 구문이다.
    }

    public void clearToDoList() {
        todoList.clear();
    }
}
