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
        // �������ݿ������������ģ��ѵ��������м��㣬���ص÷ֳ�����ֵ��ǰ�˸�����
        return null;
    }

    public Vector<QApair> getQAPair(List<Question> questions){
        // �õ����е÷ָ�����ֵ��QA��
        return null;
    }

    public void updateQA(int qid, Answer answer){
        // �����ʴ��

    }

}
