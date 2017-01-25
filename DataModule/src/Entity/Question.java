package Entity;

//import javax.persistence.*;
//import java.util.HashSet;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Luyao-Li on 2017/1/24.
 */
//@Entity
//@Table(name = "question", schema = "botbackend", catalog = "")
public class Question implements Serializable{
    private int qid;
    private String qContent;
    private String qVec;
    private Set<Answer> answerSet=new HashSet<>();
//    @Basic
//    @Column(name = "QContent")
    public  Set<Answer>   getAnswerSet() {
        return answerSet;
    }

    public void setAnswerSet( Set<Answer>   answerSet) {
        this.answerSet = answerSet;
    }

//    @Id
//    @Column(name = "QID")
    public int getQid() {
        return qid;
    }
    public void setQid(int qid) {
        this.qid = qid;
    }

//    @Basic
//    @Column(name = "QContent")
    public String getqContent() {
        return qContent;
    }
    public void setqContent(String qContent) {
        this.qContent = qContent;
    }

//    @Basic
//    @Column(name = "QVec")
    public String getqVec() {
        return qVec;
    }
    public void setqVec(String qVec) {
        this.qVec = qVec;
    }

//    @OneToMany(targetEntity = Answer.class, mappedBy = "question")
//    public Set<Answer> getAnswers(){
//        return answers;
//    }
//
//    public void setAnswers(Answer answer){
//        this.answers.add(answer);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question that = (Question) o;

        if (qid != that.qid) return false;
        if (qContent != null ? !qContent.equals(that.qContent) : that.qContent != null) return false;
        if (qVec != null ? !qVec.equals(that.qVec) : that.qVec != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = qid;
        result = 31 * result + (qContent != null ? qContent.hashCode() : 0);
        result = 31 * result + (qVec != null ? qVec.hashCode() : 0);
        return result;
    }
}
