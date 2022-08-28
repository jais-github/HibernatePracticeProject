package   com.practice.hibernatemap;

import java.util.ArrayList;

/*
 * In this we demonstrate OneTwoOne mapping unidirectional And Bidirectional both 
 */
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory factory = cfg.buildSessionFactory();
	        
	        //creating questions
	        
	        Question q1 = new Question();
	        q1.setQuestionId(1212);
	        q1.setQuestion("What is Java ?");
	        
	        //creating answer
	        Answer a1 = new Answer();
	        a1.setAnswerId(343);
	        a1.setAnswer("Java is a programming language");
	        a1.setQuestion(q1);
	      q1.setAnswer(a1);
	        
	      
	        
	       
	        
	      
	        
	        //creating questions
	        
	        Question q2 = new Question();
	        q2.setQuestionId(242);
	        q2.setQuestion("What is Spring ?");
	        
	        //creating answer
	        Answer a2 = new Answer();
	        a2.setAnswerId(344);
	        a2.setAnswer("Spring is a framework of Java");
	        a2.setQuestion(q2);
	        q2.setAnswer(a2);
	        
	      
			Session s = factory.openSession();
			Transaction tx = s.beginTransaction();
			
			// save
			
			s.save(q1);
			s.save(q2);
			s.save(a1);
			s.save(a2);
	        
	       
			
			s.save(q1);
			tx.commit();
			
	        //fetchinf data
	       
	        Question newQ = s.get(Question.class, 1212);
	        System.out.println(newQ.getQuestion());
	        System.out.println(newQ.getAnswer().getAnswer());
	        
			
	        s.close();
	        factory.close();
	}

}
