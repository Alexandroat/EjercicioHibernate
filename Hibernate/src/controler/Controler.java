package controler;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import model.Answer;
import model.Question;
import view.View;

public class Controler implements ActionListener {
	private View window;
	private HibernateHelper hibernateHelper;

	public Controler(View window, HibernateHelper hibernateHelper) {
		this.window = window;
		this.hibernateHelper = hibernateHelper;

		this.window.getSaveBtn().addActionListener(this);
		this.window.getBtnSearch().addActionListener(this);
	}

	public void iniciarVista() throws InterruptedException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					window.getFrame().setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Iterator itr = null;
		if (window.getSaveBtn() == e.getSource()) {
			System.out.println("Guardando...");
			Question question = hibernateHelper.addQuestion(window
					.getTextPregunta().getText(), window.getCategoriaSelect());

			if (!window.getRespuesta1().getText().equals("")) {
				hibernateHelper.addAnswer(question, window.getRespuesta1()
						.getText(), window.getCheckBox1().isSelected());
				System.out.println("pregunta1");
			}

			if (!window.getRespuesta2().getText().equals("")) {

				hibernateHelper.addAnswer(question, window.getRespuesta2()
						.getText(), window.getCheckBox2().isSelected());
				System.out.println("pregunta2");
			}

			if (!window.getRespuesta3().getText().equals("")) {

				hibernateHelper.addAnswer(question, window.getRespuesta3()
						.getText(), window.getCheckBox3().isSelected());
				System.out.println("pregunta3");
			}

			if (!window.getRespuesta4().getText().equals("")) {

				hibernateHelper.addAnswer(question, window.getRespuesta4()
						.getText(), window.getCheckBox4().isSelected());
				System.out.println("pregunta4");
			}

			System.out.println("Terminado");
		}
		if (window.getBtnSearch() == e.getSource()) {
			int idQuestion = Integer.parseInt(window.getIdQuestion().getText());
			window.getModPregunta().setText(
					hibernateHelper.getQuestion(idQuestion).getText());
			itr = hibernateHelper.getAnswer(idQuestion).iterator();
			while (itr.hasNext()) {
				Answer answer = (Answer) itr.next();
				System.out.println(answer.getText());
			}

			try {
				window.getModResp1().setText(
						hibernateHelper.getAnswer(idQuestion).get(0).getText());

				window.getModResp2().setText(
						hibernateHelper.getAnswer(idQuestion).get(1).getText());

				window.getModResp3().setText(
						hibernateHelper.getAnswer(idQuestion).get(2).getText());

				window.getModResp4().setText(
						hibernateHelper.getAnswer(idQuestion).get(3).getText());
			} catch (Exception ex) {
				window.getModResp1().setText("");
				window.getModResp2().setText("");
				window.getModResp3().setText("");
				window.getModResp4().setText("");
			}
		}

		if (window.getBtnDelete() == e.getSource()) {
			System.out.println("Eliminando..");
			int idQuestion = Integer.parseInt(window.getIdQuestion().getText());
			try {
				while (itr.hasNext()) {
					Answer answer = (Answer) itr.next();
					hibernateHelper.deleteAnswer(answer.getIdAnswer());
					System.out.println("Eliminada respuesta");
				}

				hibernateHelper.deleteQuestion(idQuestion);
				System.out.println("Eliminada pregunta");
			} catch (Exception ex) {

			}
		}

		if (window.getBtnModify() == e.getSource()) {

			System.out.println("Guardando cambios ...");
			int idQuestion = Integer.parseInt(window.getIdQuestion().getText());
			Question question = new Question();
			try {
				int i = 0;
				while (itr.hasNext()) {
					Answer answer = (Answer) itr.next();
					switch (i) {
					case 0:
						answer.setText(window.getRespuesta1().getText());
						break;
					case 1:
						answer.setText(window.getRespuesta2().getText());
						break;
					case 2:
						answer.setText(window.getRespuesta3().getText());
						break;
					case 3:
						answer.setText(window.getRespuesta4().getText());
						break;

					default:
						break;
					}

					hibernateHelper.updateAnswer(answer);
					i++;
				}
				question = (Question) hibernateHelper.getQuestion(idQuestion);
				question.setText(window.getModPregunta().toString());
				hibernateHelper.updateQuestion(question);
				System.out.println("Terminado");
			} catch (Exception ex) {

			}
		}

	}

}
