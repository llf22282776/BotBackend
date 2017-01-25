package dao;

import entity.Answer;
import entity.Question;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Luyao-Li on 2017/1/25.
 */
public class QuestionDAO {

    private SessionFactory sessionFactory;
    private Session session;

    public QuestionDAO(){
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        this.sessionFactory = configuration.buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    public void insert(String qContent){
        try {
            Transaction tx = session.beginTransaction();
            Question question = new Question();
            question.setqContent(qContent);

            // 根据word2vec计算得到qVec***********************************************
            String qVec = "()";

            question.setqVec(qVec);
            session.save(question);
            tx.commit();
        } catch (Exception e){
            System.out.println("ERROR in QUESTION UPDATE: ");
            System.out.println(e.getMessage());}
//        }finally {
//            session.close();
//            sessionFactory.close();
//        }
    }

    public Question getQuestionByqContent(String qContent){
        List<Question> list = null;
        try{
            Criteria criteria = session.createCriteria(Question.class);
            criteria.add(Restrictions.eq("qContent", qContent));
            list = criteria.list();
            if(list.size() == 0)
                return null;
            else
                return list.get(0);
        }catch (Exception e){
            System.out.println("ERROR in QUESTION SEARCH: ");
            System.out.println(e.getMessage());}
//        }finally {
//            session.close();
//            sessionFactory.close();
//        }
        return null;
    }

    public void updateAnswer(String qContent, String ansContent, String ansSrc, double ansGrade){
        Answer answer = new Answer();
        answer.setAnsContent(ansContent);
        answer.setAnsSrc(ansSrc);
        answer.setAnsGrade(ansGrade);
        Question question_ = this.getQuestionByqContent(qContent);
        Question question = session.load(Question.class, question_.getQid());
        try {
            Transaction tx = session.beginTransaction();
            answer.setQuestion(question);
            session.save(answer);
            tx.commit();
        }catch (Exception e){
            System.out.println("ERROR in QUESTION-ANSWER UPDATE: ");
            System.out.println(e.getMessage());
        }

        try{
            Transaction tx2 = session.beginTransaction();
            question.getAnswers().add(answer);
            session.update(question);
            tx2.commit();
        }catch (Exception e){
            System.out.println("BBBBBBBBBB");
            System.out.println(e.getMessage());
            e.printStackTrace();}
//        }finally {
//            session.close();
//            sessionFactory.close();
//        }
    }

    public static void main(String[] args){
 new QuestionDAO().insert("数据库吃屎吗");
 new QuestionDAO().updateAnswer("数据库吃屎吗", "吃", "lly", 1.0);
        System.out.println(new QuestionDAO().getQuestionByqContent("数据库吃屎吗").getQid());
        for(Answer answer:new QuestionDAO().getQuestionByqContent("数据库吃屎吗").getAnswers()){
            System.out.println(answer.getAnsContent());
        }
    }

}
