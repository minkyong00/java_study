package controller;

import model.MainModel;
import model.StockInfoModel;
import view.MainView;

public class StockInfoController {

	MainModel mainModel;
	MainView mainView;

	public StockInfoController(MainModel mainModel, MainView mainView) {
		super();
		this.mainModel = mainModel;
		this.mainView = mainView;
	}

	public void getTable() {

		mainModel.getStockInfoModel().getStockInfoList();
	}

}
