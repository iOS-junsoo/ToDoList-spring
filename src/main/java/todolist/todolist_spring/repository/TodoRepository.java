//Repository Interface - 인타터페이스로 정의하는 이유는 유연성과 확장성을 제공하며, 코드의 유지보수성과 테스트 용이성을 높여주기 때문이다.
// 또한, 스프링과 같은 프레임워크에서는 인터페이스를 사용하여 구현체를 자동으로 생성하거나, 필요한 부분에서 쉽게 교체할 수 있게 도와준다.
package todolist.todolist_spring.repository;

import todolist.todolist_spring.domain.Todo;
import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    Todo save(Todo todo);               // 할 일 저장
    Optional<Todo> findById(Long id);   // ID로 할 일 찾기
    List<Todo> findAll();               // 모든 할 일 조회
    void deleteById(Long id);           // ID로 할 일 삭제
}
