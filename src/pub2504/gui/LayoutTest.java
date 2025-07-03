package pub2504.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class LayoutTest {
	
	public static void main(String[] args) {
		
		// Component라는 타이틀을 가진 JFrame 생성
		JFrame frame = new JFrame("Layout");
		
		// X버튼 누르면 닫히도록 하는 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JFrame 사이즈 (가로 800px, 세로 600px)
		frame.setSize(800, 600);
		
		// 탭패널 생성
		JTabbedPane tabbedPane = new JTabbedPane();
		
		// FlowLayout : 좌>우, 상>하로 추가한 순서대로 배치, 미설정시 기본 레이아웃
		JPanel flowLayoutPanel = new JPanel(new FlowLayout());
		for(int i=1; i<=100; i++) {
			flowLayoutPanel.add(new JButton("버튼"+i));
		}
		tabbedPane.add("flowLayout", flowLayoutPanel);
		
		// BorderLayout : 동/서/남/북/중앙에 배치, 컴포넌트들이 각 영역을 모두 채움
		JPanel borderLayoutPannel = new JPanel(new BorderLayout());
		borderLayoutPannel.add(new JButton("NORTH"), BorderLayout.NORTH);
		borderLayoutPannel.add(new JButton("SOUTH"), BorderLayout.SOUTH);
		borderLayoutPannel.add(new JButton("WEST"), BorderLayout.WEST);
		borderLayoutPannel.add(new JButton("EAST"), BorderLayout.EAST);
		borderLayoutPannel.add(new JButton("CENTER"), BorderLayout.CENTER);
		tabbedPane.addTab("BorderLayout", borderLayoutPannel);
		
		// GridLayout : 행열구조(격자) 배치, 각 배치영역의 크기가 동일, 컴포넌트가 영역을 모두 채움
		JPanel gridLayoutPanel = new JPanel(new GridLayout(2, 3));
		for(int i=1; i<=6; i++) {
			gridLayoutPanel.add(new JButton("버튼"+i));
		}
		tabbedPane.addTab("GridLayout", gridLayoutPanel);
		
		// 
		
		frame.add(tabbedPane);
		frame.setVisible(true);
		
	} // main

} // class
