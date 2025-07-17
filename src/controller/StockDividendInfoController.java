package controller;

import java.util.List;

import model.MainModel;
import view.MainView;

public class StockDividendInfoController {

	MainModel mainModel;
	MainView mainView;

	public StockDividendInfoController(MainModel mainModel, MainView mainView) {
		this.mainModel = mainModel;
		this.mainView = mainView;
	}

	public void getDate() {
		List<String> cashDvdList = mainModel.getStockDividendInfoModel().getApi("dvdnBasDt", "삼성전자");
		
	}

}
