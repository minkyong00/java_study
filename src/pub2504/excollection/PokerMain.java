package pub2504.excollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerMain {
	
	public static void main(String[] args) {
		// 플레이어 5명 객체 생성
		// 7개 카드 객체 랜덤 부여, 중복없이 
		// 숫자(A, 2, 3 ... 10, J, Q, K) 
		// 무늬(하트, 클로버, 다이아몬드, 스페이드) 
		// 카드 총 52장(무늬4개씩 13장)
		
		
		// 플레이어 5명
		List<Player> playerList = Arrays.asList(
			new Player("홍길동", Collections.EMPTY_LIST),
			new Player("강감찬", Collections.EMPTY_LIST),
			new Player("장보고", Collections.EMPTY_LIST),
			new Player("권율", Collections.EMPTY_LIST),
			new Player("최영", Collections.EMPTY_LIST)
		);
//		System.out.println(playerList);
		
		// 카드 52장
		// 숫자 1~14
		List<Integer> numList = new ArrayList<Integer>();
		for(int i=2; i<15; i++) {
			numList.add(i);
		}
		
		// 무늬 4개
		List<String> patternList = new ArrayList<String>();
		patternList.add("♥");
		patternList.add("♠");
		patternList.add("♣");
		patternList.add("◆");
	
		// 카드 52장
		List<Card> allcardList = new ArrayList<Card>();
	
		int numListSize = numList.size();
		int patternSize = patternList.size();
		for(int i=0; i<numListSize; i++) {
			for(int j=0; j<patternSize; j++) {
				allcardList.add(new Card(numList.get(i), patternList.get(j)));
			}
		}
		
		// 카드 섞는다
		Collections.shuffle(allcardList);
//		System.out.println(allcardList);
		
		// 카드를 7장씩 나눠준다
		for(int i=0; i<playerList.size(); i++) {
			playerList.get(i).setCardList(allcardList.subList((i*7), (i*7)+7));
		}
//		System.out.println(playerList);
		
		// 플레이어가 가진 7장의 카드에서 모양별 개수, 숫자별 개수 추출해서 저장
		// 2=0, 3=1, ... 14=0
	      for (int i=0; i<playerList.size(); i++) {
	         Player player = playerList.get(i);
	         for (Card card : playerList.get(i).getCardList()) {
	            player.getNumCountMap().put(card.getNumber(), 
	                  player.getNumCountMap().get(card.getNumber()) + 1);
	            player.getPatternCountMap().put(card.getPattern(), 
	                  player.getPatternCountMap().get(card.getPattern()) + 1);
	         }
	      }
	      
	      playerList.stream().forEach(player -> {
	          System.out.println(player);
	          printResult(player);
	       });

	} // main
	
	private static void printResult(Player player) {
	      String resultStr = "";
	      if (PokerRule.isRoyalStraightFlush(player)) resultStr = "[로열스트레이트플러시]";
	      else if (PokerRule.isStraightFlush(player)) resultStr = "[스트레이트플러시]";
	      else if (PokerRule.isFourCard(player)) resultStr = "[포카드]";
	      else if (PokerRule.isFullHouse(player)) resultStr = "[풀하우스]";
	      else if (PokerRule.isFlush(player)) resultStr = "[플러시]";
	      else if (PokerRule.isStraight(player)) resultStr = "[스트레이트]";
	      else if (PokerRule.isTriple(player)) resultStr = "[트리플]\";\r\n"
	      		+ "      else if (PokerRule.isTwoPair(player)) resultStr = \"[투 페어]\";\r\n"
	      		+ "      else if (PokerRule.isOnePair(player)) resultStr = \"[원 페어]\";\r\n"
	      		+ "      else resultStr = \"[족보 없음]\";\r\n"
	      		+ "      System.out.println(resultStr+\"\\n\");\r\n";

	}      		
} // class
