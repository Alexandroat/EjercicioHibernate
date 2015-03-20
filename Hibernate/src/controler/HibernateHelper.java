package controler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import model.Answer;
import model.Question;
import model.SessionFactoryUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateHelper {
	private SessionFactory sesion;

	public HibernateHelper() {
		sesion = SessionFactoryUtil.getSessionFactory();
	}

	public Question addQuestion(String text, String category) {
		Question last = getLastQuestion();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Question question = new Question(last.getIdQuestion() + 1, text,
				category, new HashSet<Answer>(0));
		session.save(question);
		tx.commit();
		session.close();
		return question;
	}

	public void addAnswer(Question question, String text, boolean isCorrect) {
		Answer last = getLastAnswer();

		int id = (last.getIdAnswer() + 1);
		Answer answer = new Answer(id, question, text, isCorrect);
		Session session = sesion.openSession();
		// HashSet<Answer> answers = new HashSet<Answer>();
		Transaction tx = session.beginTransaction();

		// answers.add(answer);
		// question.setAnswers(answers);
		session.save(answer);
		tx.commit();
		session.close();
		System.out.println("finish add answer");
	}

	public Question getQuestion(int id) {
		Session session = sesion.openSession();
		// Transaction tx = session.beginTransaction();
		Question question = new Question();
		try {
			question = (Question) session.load(Question.class, id);
			System.out.println(question.getText());

		} catch (Exception e) {

		} finally {
			session.close();
		}

		// System.out.println(question.getText());
		return question;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Answer> getAnswer(int idQuestion) {
		Session session = sesion.openSession();
		ArrayList<Answer> answers = null;
		try {
			answers = new ArrayList<Answer>();
			// Transaction tx = session.beginTransaction();
			List<Answer> result = (List<Answer>) session.createQuery(
					"from Answer as a where a.question.idQuestion = "
							+ idQuestion).list();

			for (Answer evento : result) {
				answers.add(evento);
			}
		} catch (Exception e) {

		} finally {
			session.close();
		}

		return answers;
	}

	public Question getLastQuestion() {
		Session session = sesion.openSession();

		Query query = session
				.createQuery("from Question order by idQuestion DESC");
		query.setMaxResults(1);
		Question last = (Question) query.uniqueResult();
		session.close();

		return last;

	}

	public Answer getLastAnswer() {
		Session session = sesion.openSession();

		Query query = session.createQuery("from Answer order by idAnswer DESC");
		query.setMaxResults(1);
		Answer last = (Answer) query.uniqueResult();
		session.close();

		return last;

	}

	public void deleteAnswer(int id) {
		Session session = sesion.openSession();
		Answer answer = (Answer) session.get(Answer.class, id);
		if (answer != null)
			session.delete(answer);
		session.close();
	}

	public void deleteQuestion(int id) {
		Session session = sesion.openSession();
		Question question = (Question) session.get(Question.class, id);
		if (question != null)
			session.delete(question);
		session.close();
	}

	public void updateAnswer(Answer answer) {
		Session session = sesion.openSession();
		Answer oldAnswer = (Answer) session.get(Answer.class,
				answer.getIdAnswer());
		if (oldAnswer != null)
			session.update(answer);
		session.close();
	}
	
	public void updateQuestion(Question question) {
		Session session = sesion.openSession();
		Question oldQuestion = (Question) session.get(Question.class,
				question.getIdQuestion());
		if (oldQuestion != null)
			session.update(question);
		session.close();
	}

}