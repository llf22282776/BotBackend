package Entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Luyao-Li on 2017/1/24.
 */
//@Entity
//@Table(name = "answer", schema = "botbackend", catalog = "")
public class Answer implements Serializable {
    private int ansId;
    private String ansContent;
    private String ansSrc;
    private Double ansGrade;
    private Question question;

//    @Id
//    @Column(name = "AnsID")
    public int getAnsId() {
        return ansId;
    }

    public void setAnsId(int ansId) {
        this.ansId = ansId;
    }

//    @Basic
//    @Column(name = "AnsContent")
    public String getAnsContent() {
        return ansContent;
    }

    public void setAnsContent(String ansContent) {
        this.ansContent = ansContent;
    }

//    @Basic
//    @Column(name = "AnsSrc")
    public String getAnsSrc() {
        return ansSrc;
    }

    public void setAnsSrc(String ansSrc) {
        this.ansSrc = ansSrc;
    }

//    @Basic
//    @Column(name = "AnsGrade")
    public Double getAnsGrade() {
        return ansGrade;
    }

    public void setAnsGrade(Double ansGrade) {
        this.ansGrade = ansGrade;
    }

//    @ManyToOne(targetEntity = Question.class)
//    @JoinColumn(name = "Question_QID")
    public Question getQuestion(){
        return question;
    }
    public void setQuestion(Question question){
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer that = (Answer) o;

        if (ansId != that.ansId) return false;
        if (ansContent != null ? !ansContent.equals(that.ansContent) : that.ansContent != null) return false;
        if (ansSrc != null ? !ansSrc.equals(that.ansSrc) : that.ansSrc != null) return false;
        if (ansGrade != null ? !ansGrade.equals(that.ansGrade) : that.ansGrade != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ansId;
        result = 31 * result + (ansContent != null ? ansContent.hashCode() : 0);
        result = 31 * result + (ansSrc != null ? ansSrc.hashCode() : 0);
        result = 31 * result + (ansGrade != null ? ansGrade.hashCode() : 0);
        return result;
    }
}
