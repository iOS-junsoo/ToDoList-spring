package todolist.todolist_spring.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import todolist.todolist_spring.domain.Todo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryTodoRepositoryTest {

    MemoryTodoRepository repository = new MemoryTodoRepository();

    public void afterEach() {
        repository.clearToDoList();
    }

    @Test
    void 메모저장() {
        //given - 무엇인가 주어졌고
        Todo todo = new Todo(null, "스프링 프로젝트", "스프링으로 투두리스트 만들기!");
        //아이디 값을 null으로 해놓은 이유는 save 메소드에서 자동으로 아이디를 할당해주기 때문이다.

        //when - 그걸 받아서 실행했을 때
        repository.save(todo);

        //then - 어떤 결과가 나와야한다.
        //[1번 방법]
        Todo result = repository.findById(todo.getId()).get();
//        System.out.println("투두 제목: "+result.getTitle() + "\n투두 내용: " + result.getDescription());

        //[2번 방법]
        assertThat(todo).isEqualTo((result));
    }

    @Test
    void 메모찾기() {
        //given - 무엇인가 주어졌고
        Todo todo1 = new Todo(null, "스프링 프로젝트", "스프링으로 투두리스트 만들기!");
        Todo todo2 = new Todo(null, "ios 프로젝트", "ios로 투두리스트 만들기!");
        repository.save(todo1);
        repository.save(todo2);

        //when - 그걸 받아서 실행했을 때
        Todo result = repository.findById(todo1.getId()).get();


        //then - 어떤 결과가 나와야한다.
        assertThat(todo1).isEqualTo((result));
    }

    @Test
    void 모든메모찾기() {
        //given - 무엇인가 주어졌고
        Todo todo1 = new Todo(null, "스프링 프로젝트", "스프링으로 투두리스트 만들기!");
        Todo todo2 = new Todo(null, "ios 프로젝트", "ios로 투두리스트 만들기!");
        repository.save(todo1);
        repository.save(todo2);

        //when - 그걸 받아서 실행했을 때
        List<Todo> result = repository.findAll();

        //then - 어떤 결과가 나와야한다.
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void 메모지우기() {
        //given - 무엇인가 주어졌고
        Todo todo = new Todo(null, "스프링 프로젝트", "스프링으로 투두리스트 만들기!");
        repository.save(todo);

        //when - 그걸 받아서 실행했을 때
        repository.deleteById(todo.getId());

        List<Todo> result = repository.findAll();
        //then - 어떤 결과가 나와야한다.
        assertThat(result.isEmpty()).isTrue();
    }
}