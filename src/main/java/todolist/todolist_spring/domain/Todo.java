//Domain - 해당 패키지는 객체를 생성하는 곳입니다.
package todolist.todolist_spring.domain;

import jakarta.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //

    private Long id;           // 할 일의 고유 ID
    private String title;      // 할 일의 제목
    private String description; // 할 일의 설명 (옵션)
    private boolean completed;  // 완료 여부

    public Todo(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = false; // 처음 생성할 때는 미완료 상태로 설정
    }

    public Todo() {
        //entity는 기본 생성자가 있어한다는 요구가 있음.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

