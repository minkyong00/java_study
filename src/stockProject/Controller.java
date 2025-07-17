package stockProject;

public class Controller {
	
	Model model;
	View view;
	
	public Controller() {
	}

		
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}



//	StockAPI_2 stockAPI_2;
	
	
	public void initEvent() {
		EventGetStockInfo.getStockInfo();
	}

}
