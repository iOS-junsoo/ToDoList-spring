package todolist.todolist_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import todolist.todolist_spring.domain.Todo;
import todolist.todolist_spring.repository.TodoRepository;
import todolist.todolist_spring.service.TodoService;

import java.util.List;

//@RequestBody: HTTP 요청의 **본문(body)**에 포함된 JSON 데이터를 자바 객체로 변환하여 메서드 파라미터로 전달합니다.
//@PathVariable: URL 경로에 있는 값을 메서드 파라미터로 전달합니다. 예를 들어, /{id}와 같이 경로에 포함된 변수 값을 추출합니다.
//@RequestParam: URL의 쿼리 파라미터를 메서드 파라미터로 전달합니다. 예를 들어, ?key=value와 같은 쿼리 파라미터 값을 가져옵니다.


@RestController //앱과 연동하기에 RESTAPI
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public Todo crateTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo.getTitle(), todo.getDescription());
    }

    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @PutMapping("/{id}/complete") //아이디도 변경 됨.
    public  Todo completeTodo(@PathVariable Long id) {
        return todoService.completeTodo(id);
    }

    @DeleteMapping("/{id}/delete")
    public  void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodoById(id);
    }


}
