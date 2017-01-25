package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Luyao-Li on 2017/1/25.
 */
public class AnswerDAO {

    private SessionFactory sessionFactory;
    private Session session;

    public AnswerDAO(){
        Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
        this.sessionFactory = configuration.buildSessionFactory();
        this.session = sessionFactory.openSession();
    }


}
