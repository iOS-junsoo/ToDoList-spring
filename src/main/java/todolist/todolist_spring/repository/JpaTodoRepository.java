package todolist.todolist_spring.repository;

import jakarta.persistence.EntityManager;
import todolist.todolist_spring.domain.Todo;


import java.util.List;
import java.util.Optional;

public class JpaTodoRepository implements TodoRepository{

    private final EntityManager entityManager;
    public JpaTodoRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Todo save(Todo todo) {
        entityManager.persist(todo);
        return todo;
    }

    @Override
    public Optional<Todo> findById(Long id) {
        Todo todo = entityManager.find(Todo.class, id);
        return Optional.ofNullable(todo);
    }

    @Override
    public List<Todo> findAll() {
        return entityManager.createQuery("select t from Todo t", Todo.class).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Todo todo = entityManager.find(Todo.class, id);

        if (todo != null) {
            entityManager.remove(todo);
        } else {
            throw new IllegalArgumentException("Todo with id " + id + " not found");
        }
    }
}
