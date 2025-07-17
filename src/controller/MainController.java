package controller;

import model.MainModel;
import view.MainView;

public class MainController {

	MainView mainView;
	MainModel mainModel;
	StockInfoController stockInfoController;
	StockDividendInfoController stockDividendInfoController;

	public MainController(MainView mainView, MainModel mainModel) {
		this.mainModel = mainModel;
		this.mainView = mainView;

		this.stockDividendInfoController = new StockDividendInfoController(mainModel, mainView);
		stockDividendInfoController.getDate();

	}

	public StockInfoController getStockInfoController() {
		return stockInfoController;
	}

	public StockDividendInfoController getStockDividendInfoController() {
		return stockDividendInfoController;
	}

}
