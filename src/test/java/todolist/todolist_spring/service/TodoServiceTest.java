package todolist.todolist_spring.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import todolist.todolist_spring.domain.Todo;
import todolist.todolist_spring.repository.MemoryTodoRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TodoServiceTest {

    TodoService todoService;
    MemoryTodoRepository memoryTodoRepository;

    @BeforeEach
    public void beforeEach() {
        memoryTodoRepository = new MemoryTodoRepository();
        todoService = new TodoService(memoryTodoRepository);
    }

    @AfterEach
    public void afterEach() {
        memoryTodoRepository.clearToDoList();
    }

    @Test
    void addTodo_Test() {
        //given - 무엇인가 주어졌고

        //when - 그걸 받아서 실행했을 때
        Todo savedTodo = todoService.addTodo("스프링 프로젝트", "스프링이용해서 프론트와 연동하기");

        //then - 어떤 결과가 나와야한다.
        assertEquals("스프링 프로젝트", savedTodo.getTitle());
    }

    @Test
    void getAllTodos_Test() {
        //given - 무엇인가 주어졌고
        Todo todo1 = new Todo(null, "스프링 프로젝트", "스프링으로 투두리스트 만들기!");
        Todo todo2 = new Todo(null, "ios 프로젝트", "ios로 투두리스트 만들기!");
        memoryTodoRepository.save(todo1);
        memoryTodoRepository.save(todo2);

        //when - 그걸 받아서 실행했을 때

        //then - 어떤 결과가 나와야한다.
        assertThat(todoService.getAllTodos().size()).isEqualTo(2);
    }

    @Test
    void completeTodo_Test() {
        //given - 무엇인가 주어졌고
        Todo todo = new Todo(null, "스프링 프로젝트", "스프링으로 투두리스트 만들기!");
        memoryTodoRepository.save(todo);


        //when - 그걸 받아서 실행했을 때
        todoService.completeTodo(todo.getId());

        //then - 어떤 결과가 나와야한다.
//        System.out.println(todo.isCompleted());
        assertThat(todo.isCompleted()).isTrue();
    }

    @Test
    void deleteTodoById_Test() {
        //given - 무엇인가 주어졌고
        Todo todo = new Todo(null, "스프링 프로젝트", "스프링으로 투두리스트 만들기!");
        memoryTodoRepository.save(todo);

        System.out.println("삭제 전:" + todoService.getAllTodos());

        //when - 그걸 받아서 실행했을 때
        todoService.deleteTodoById(todo.getId());

        System.out.println("삭제 후:" + todoService.getAllTodos());

        //then - 어떤 결과가 나와야한다.
        assertThat(todoService.getAllTodos().size()).isEqualTo(0);
    }
}