package entity;


import lombok.Getter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "responses")
public class Response {
    @Id
    @Column(name = "id")
    private @Getter int id;
    @Column(name = "idQuestion")
    private @Getter int idQuestion;
    @Column(name = "answer")
    private @Getter String answer;

    public Response setId(int id) {
        this.id = id;
        return this;
    }

    public Response setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
        return this;
    }

    public Response setAnswer(String answer) {
        this.answer = answer;
        return this;
    }
}
