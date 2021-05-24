/**
 * This class defines the application entry point and renders
 * the user login screen.
 */

import ui.Login;

public class App {

	public static void main(String[] args) {
		try {
			Login frame = new Login();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
