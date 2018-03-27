package entity;

import lombok.Getter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "options", schema = "public")
public class Option  {
    @Id
    @Column(name = "idQuestion")
    private int idQuestion;
    @Column(name = "option")
    private String option;

    public String getOption() {
        return option;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public Option setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
        return this;
    }

    public Option setOption(String option) {
        this.option = option;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option1 = (Option) o;
        return idQuestion == option1.idQuestion &&
                Objects.equals(option, option1.option);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idQuestion, option);
    }

    @Override
    public String toString() {
        return "Option{" +
                "idQuestion=" + idQuestion +
                ", option='" + option + '\'' +
                '}';
    }
}
