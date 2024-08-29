package todolist.todolist_spring;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import todolist.todolist_spring.repository.JpaTodoRepository;
import todolist.todolist_spring.repository.TodoRepository;
import todolist.todolist_spring.service.TodoService;

@Configuration
public class SpringConfig {
//    private EntityManager entityManager;
//
//    public SpringConfig(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    private final TodoRepository todoRepository;

    @Autowired
    public SpringConfig(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @Bean
    public TodoService todoService(){
        return new TodoService(todoRepository);
    }

//    @Bean
//    public TodoRepository todoRepository(){
//        return new JpaTodoRepository(entityManager);
//    }
}
