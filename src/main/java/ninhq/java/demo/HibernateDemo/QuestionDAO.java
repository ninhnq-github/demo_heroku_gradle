package ninhq.java.demo.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class QuestionDAO
{
    public static List<QuestionEntity> getAll()
    {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<QuestionEntity> mlist = new ArrayList<>();
        try{
            /*
            session.save(new QuestionEntity()); // save to insert new object to db table
            session.update(new QuestionEntity()); // update object properties to db table
            session.delete(new QuestionEntity()); // delete object in db table
             */
            // Hibernate query
            String query = "FROM ";
            Query<QuestionEntity> questionEntityQuery = session.createQuery("FROM QuestionEntity");
            mlist = questionEntityQuery.getResultList();
            transaction.commit();
        }
        catch (Exception e){

        }
        finally {
            session.close();
        }
        return mlist;
    }
}
