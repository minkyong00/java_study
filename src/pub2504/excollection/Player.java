package pub2504.excollection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

	private String name; // 이름
	private List<Card> cardList; // 카드
	private Map<Integer, Integer> numCountMap;
	private Map<String, Integer> patternCountMap;
	
	public Player() {
	}

	public Player(String name, List<Card> cardList) {
		this.name = name;
		this.cardList = cardList;
		this.numCountMap = new HashMap<Integer, Integer>();
		this.patternCountMap = new HashMap<String, Integer>();
		for(int i=2; i<15; i++) {
			// 초기화
			numCountMap.put(i, 0);
			patternCountMap.put("♥", 0);
			patternCountMap.put("♠", 0);
			patternCountMap.put("♣", 0);
			patternCountMap.put("◆", 0);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getCardList() {
		return cardList;
	}

	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}

	public Map<Integer, Integer> getNumCountMap() {
		return numCountMap;
	}

	public void setNumCountMap(Map<Integer, Integer> numCountMap) {
		this.numCountMap = numCountMap;
	}

	public Map<String, Integer> getPatternCountMap() {
		return patternCountMap;
	}

	public void setPatternCountMap(Map<String, Integer> patternCountMap) {
		this.patternCountMap = patternCountMap;
	}

	@Override
	public String toString() {
		return name + " " + cardList + "\n" + numCountMap + "\n" + patternCountMap;
	}
	
	

	
}
