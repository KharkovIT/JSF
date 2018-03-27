package entity;


import lombok.Getter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @Column(name = "id")
    private @Getter int id;
    @Column(name = "label")
    private @Getter String label;
    @Column(name = "type")
    private @Getter Type type;
    @Column(name = "required")
    private @Getter boolean required;
    @Column(name = "active")
    private @Getter boolean active;
    @Column(name = "idAdmin")
    private @Getter int idAdmin;

    public Question setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
        return this;
    }



    public Question setId(int id) {
        this.id = id;
        return this;
    }

    public Question setLabel(String label) {
        this.label = label;
        return this;
    }

    public Question setType(Type type) {
        this.type = type;
        return this;
    }

    public Question setRequired(boolean required) {
        this.required = required;
        return this;
    }

    public Question setActive(boolean active) {
        this.active = active;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id ;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, label, type, required, active);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", type=" + type +
                ", required=" + required +
                ", active=" + active +
                '}';
    }
}
