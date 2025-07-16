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



	public void initEvent() {
		EventGetStockInfo.getStockInfo();
	}

}
