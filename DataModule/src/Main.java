import Entity.Answer;
import Entity.Question;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by Luyao-Li on 2017/1/24.
 */
public class Main {
    public static  Configuration configuration ;
    public static SessionFactory sessionFactory ;
    public static Session session ;
    public static Transaction tx ;
    public static void main(final String[] args) throws Exception {
        init();
        try {
            Question question=new Question();
            question.setqContent("���hffgjh ");

            question.setqVec("(1,2,3,555,16)");
           // insert(question);

            Answer answer = new Answer();
            Answer answer1=new Answer();
            Answer answer2=new Answer();
            answer.setAnsContent("�߰�����");
            answer.setAnsSrc("�ٶ�֪��");
            answer.setAnsGrade(0.6);
            answer1.setAnsContent("����");
            answer1.setAnsSrc("�ѹ�");
            answer1.setAnsGrade(0.5);
            answer2.setAnsContent("��������");
            answer2.setAnsSrc("֪��");
            answer2.setAnsGrade(0.4);

            question.getAnswerSet().add(answer);
            question.getAnswerSet().add(answer1);
            question.getAnswerSet().add(answer2);
            answer.setQuestion(question);
            answer1.setQuestion(question);
            answer2.setQuestion(question);
            insert(question);


            System.out.println("Success");
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();

        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }

    public static void init(){
         configuration = new Configuration().configure("/hibernate.cfg.xml");
         sessionFactory = configuration.buildSessionFactory();


    }
    @Before
    public static void ready() throws Exception{

        session = sessionFactory.openSession();
        tx = session.beginTransaction();

    }
    @Test
    public static void  insert(Question question) throws Exception{
        ready();
        session.save(question);
        tx.commit();
        session.close();
    }
    @Test
    public static void  insert(Answer answer)throws Exception{
        ready();
        session.save(answer);
        tx.commit();
        session.close();
    }
    @Test
    public static void update(){

    }


}