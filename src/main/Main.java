package main;

import controller.MainController;
import model.MainModel;
import model.StockInfoModel;
import view.MainView;

public class Main {

	public static void main(String[] args) {
		MainView mainView = new MainView();
		mainView.initView();
		
		MainModel mainModel = new MainModel();
		MainController mainController = new MainController(mainView, mainModel);
		
	}
}
