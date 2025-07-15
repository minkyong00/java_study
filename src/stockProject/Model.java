package stockProject;

import javax.swing.DefaultListModel;

public class Model {

	DefaultListModel<JsonStock> jsonStockList = new DefaultListModel<JsonStock>(); // json 데이터
	DefaultListModel<StockInfo> stockInfoList = new DefaultListModel<StockInfo>(); // isin코드, 시가총액 데이터 등,,
	DefaultListModel<StockDividendInfo> stockDividendInfoList = new DefaultListModel<StockDividendInfo>(); // 배당금 데이터

	public Model() {
		addList();
	}
	
	public DefaultListModel<JsonStock> getJsonStockList() {
		return jsonStockList;
	}

	public void setJsonStockList(DefaultListModel<JsonStock> jsonStockList) {
		this.jsonStockList = jsonStockList;
	}

	public DefaultListModel<StockInfo> getStockInfoList() {
		return stockInfoList;
	}

	public void setStockInfoList(DefaultListModel<StockInfo> stockInfoList) {
		this.stockInfoList = stockInfoList;
	}

	public DefaultListModel<StockDividendInfo> getStockDividendInfoList() {
		return stockDividendInfoList;
	}

	public void setStockDividendInfoList(DefaultListModel<StockDividendInfo> stockDividendInfoList) {
		this.stockDividendInfoList = stockDividendInfoList;
	}

	public void addList() {
		JsonStock jsonStock = new JsonStock(
				1, "삼성전자", true, 2
			);
			
			jsonStockList.addElement(jsonStock);
	}
	
}
