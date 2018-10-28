package application;

import java.text.ParseException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ResController {
	@FXML
	private TextField widthText;
	@FXML
	private TextField heightText;
	private boolean ok = false;
	
	public ResController() {
		
	}
	
	public void setWidth(double width) {
		widthText.setText(""+width);
	}
	
	public void setHeight(double height) {
		heightText.setText(""+height);
	}
	
	public double getWidth() {
		double width = 0;
		try {
			width = Console.String2Double(widthText.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return width;
	}
	
	public double getHeight() {
		double height = 0;
		try {
			height = Console.String2Double(heightText.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return height;
	}
	
	public boolean getOk() {
		return ok;
	}
	
	@FXML
	private void doOK(ActionEvent e) {
		ok = true;
		closeDialog();
	}

	public void closeDialog() {
		Stage win = (Stage)widthText.getScene().getWindow();
		win.close();
	}
	@FXML
	private void doCancel(ActionEvent e) {
		closeDialog();
	}
}
