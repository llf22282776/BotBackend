import entity.Answer;
import entity.Question;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * Created by Luyao-Li on 2017/1/24.
 */
public class Main {

    public static void main(final String[] args) throws Exception {
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Answer answer1 = new Answer();
            Answer answer2 = new Answer();
            Question question = new Question();
            Question question_ = session.load(Question.class, 2);
            Answer answer = session.load(Answer.class, 6);
            Answer answer_ = session.load(Answer.class, 7);

            question_.getAnswers().add(answer);
            question_.getAnswers().add(answer_);
//            session.update(question_);

            answer1.setAnsContent("�߰�����");
            answer1.setAnsSrc("�ٶ�֪��");
            answer1.setAnsGrade(0.6);
            answer1.setQuestion(question_);
//            question_.getAnswers().add(answer1);
//            session.save(answer1);

            answer2.setAnsContent("������");
            answer2.setAnsSrc("֪��");
            answer2.setAnsGrade(0.4);
            answer2.setQuestion(question_);
//            session.save(answer2);
//            answer2.setQuestion(question_);

//            session.save(answer1);
//            session.save(answer2);

//            question.setqContent("·����ش���ι���·��");
//            question.setqVec("(a��b, c)");
//            question.getAnswers().add(answer1);
//            question.getAnswers().add(answer2);
//            session.save(question);


//            tx.commit();

            for(Answer ans:question_.getAnswers()){
                System.out.println(ans.getAnsContent());
            }
            System.out.println("Success");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

}