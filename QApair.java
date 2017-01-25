package dao;

import entity.Answer;
import entity.Question;

import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * Created by Luyao-Li on 2017/1/25.
 */
public class QApair {
    Question question;
    Vector<Answer> answers = new Vector<>();

    public QApair(Question question, Set<Answer> answers){
        this.question = question;
        for(Answer ans:answers){
            this.answers.add(ans);
        }
    }

    public List<Question> getSimilarQuestions(Question question){
        // 遍历数据库中问题表，根据模型训练结果进行计算，返回得分超过阈值的前八个问题
        return null;
    }

    public Vector<QApair> getQAPair(List<Question> questions){
        // 得到所有得分高于阈值的QA对
        return null;
    }

    public void updateQA(int qid, Answer answer){
        // 更新问答对

    }

}
