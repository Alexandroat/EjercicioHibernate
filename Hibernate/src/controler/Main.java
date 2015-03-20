package controler;

import view.View;

public class Main {

	public static void main(String[] args) {
		HibernateHelper hibernateHelper= new HibernateHelper();
		View view = new View();
		Controler controler = new Controler(view, hibernateHelper);
		try {
			controler.iniciarVista();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
