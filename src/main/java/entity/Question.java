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

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;

    }



    public void setId(int id) {
        this.id = id;

    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setType(Type type) {
        this.type = type;

    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public void setActive(boolean active) {
        this.active = active;
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
