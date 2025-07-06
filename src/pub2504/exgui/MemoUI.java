package pub2504.exgui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class MemoUI extends JFrame {

	MemoModel memoModel;
	JList<Memo> memoList;
	
	JMenu fileMenu;
	JMenu infoMenu;
	JMenuItem fileMenuItemOpen;
	JMenuItem fileMenuItemSave;
	JTextArea memoTextArea;
	JTextField memoTextField;
	
	JButton addButton;
	JButton editButton;
	JButton deleteButton;

	public MemoUI() {
	}

	public MemoUI(MemoModel memoModel) throws HeadlessException {
		this.memoModel = memoModel;

		setTitle("메모장 프로그램");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JMenuBar jMenuBar = new JMenuBar();
		fileMenu = new JMenu("파일");
		infoMenu = new JMenu("정보");
		fileMenuItemOpen = new JMenuItem("열기");
		fileMenuItemSave = new JMenuItem("저장");

		fileMenu.add(fileMenuItemOpen);
		fileMenu.add(fileMenuItemSave);
		jMenuBar.add(fileMenu);
		jMenuBar.add(infoMenu);
		
		memoModel.memoListModel = new DefaultListModel<Memo>();
        memoList = new JList<Memo>(memoModel.memoListModel);
        memoList.setPreferredSize(new Dimension(250, 600));
        memoList.setBackground(Color.GRAY);
        memoList.setFont(new Font("굴림", Font.BOLD, 20));
        memoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(memoList);

        memoTextArea = new JTextArea();
        memoTextArea.setBackground(Color.BLACK);
        memoTextArea.setForeground(Color.WHITE);
        memoTextArea.setFont(new Font("굴림", Font.BOLD, 20));        
        JScrollPane textScrollPane = new JScrollPane(memoTextArea);
        
        JPanel centerPanel = new JPanel(new BorderLayout());
        memoTextField = new JTextField();
        memoTextField.setBackground(Color.BLACK);
        memoTextField.setForeground(Color.WHITE);
        memoTextField.setFont(new Font("굴림", Font.BOLD, 20));
        centerPanel.add(memoTextField, BorderLayout.NORTH);
        centerPanel.add(textScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("메모 등록");
        editButton = new JButton("메모 수정");
        deleteButton = new JButton("메모 삭제");
        
        addButtons(buttonPanel, addButton, editButton, deleteButton);

        add(jMenuBar, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        add(listScrollPane, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
        
	}
	
	 // 패널에 버튼 추가
    private void addButtons(JPanel jpanel, JButton... jbuttons) {
       for (JButton jbutton : jbuttons) {
          jpanel.add(jbutton);
       }
    } // addButtons

}
