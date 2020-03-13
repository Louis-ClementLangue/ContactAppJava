package service;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * @author Philippe Duval
 * 
 *         the purpose of this class is to hold the Stage that is given to us
 *         by JavaFX, and ensure that we will always use this stage, and not a
 *         new stage that is not displayed already
 */

public class StageService {

	private StageService() {
	}

	private static class StageServiceHolder {
		private static final StageService INSTANCE = new StageService();
	}

	public static StageService getInstance() {
		return StageServiceHolder.INSTANCE;
	}

	private Stage primaryStage;

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void closeStage() {
		primaryStage.fireEvent(new WindowEvent(primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST));

	}

}
