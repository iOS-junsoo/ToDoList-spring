package todolist.todolist_spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import todolist.todolist_spring.domain.Todo;
import todolist.todolist_spring.repository.TodoRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest //통합 테스트를 위한 어노테이션 (해당 어노테이션을 붙이면 실제 DB와 연결한다.)
@Transactional
public class TodoServiceIntegrationTest {
    @Autowired
    TodoService todoService;
    @Autowired
    TodoRepository todoRepository;

    @Test
    @Commit //실제로 DB에 저장하고 싶을 때 사용
    void addTodo_Test() {
        //given - 무엇인가 주어졌고

        //when - 그걸 받아서 실행했을 때
        Todo savedTodo = todoService.addTodo("스프링 프로젝트", "스프링이용해서 프론트와 연동하기");

        //then - 어떤 결과가 나와야한다.
        assertEquals("스프링 프로젝트", savedTodo.getTitle());
    }

    @Test
    @Commit
    void getAllTodos_Test() {
        //given - 무엇인가 주어졌고
        Todo todo1 = new Todo(null, "스프링 프로젝트", "스프링으로 투두리스트 만들기!");
        Todo todo2 = new Todo(null, "ios 프로젝트", "ios로 투두리스트 만들기!");
        todoRepository.save(todo1);
        todoRepository.save(todo2);

        //when - 그걸 받아서 실행했을 때

        //then - 어떤 결과가 나와야한다.
        assertThat(todoService.getAllTodos().size()).isEqualTo(2);
    }

    @Test
    @Commit
    void completeTodo_Test() {
        //given - 무엇인가 주어졌고
        Todo todo = new Todo(null, "스프링 프로젝트1", "스프링으로 투두리스트 만들기!1");
        todoRepository.save(todo);


        //when - 그걸 받아서 실행했을 때
        todoService.completeTodo(todo.getId());

        //then - 어떤 결과가 나와야한다.
//        System.out.println(todo.isCompleted());
        assertThat(todo.isCompleted()).isTrue();
    }

    @Test
    @Commit
    void deleteTodoById_Test() {
        //given - 무엇인가 주어졌고
        Todo todo = new Todo(null, "스프링 프로젝트", "스프링으로 투두리스트 만들기!");
        todoRepository.save(todo);

        //when - 그걸 받아서 실행했을 때

        todoService.deleteTodoById(todo.getId());

        //then - 어떤 결과가 나와야한다.
        assertThat(todoService.getAllTodos().size()).isEqualTo(0);
    }
}
