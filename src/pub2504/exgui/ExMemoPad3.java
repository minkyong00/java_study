package pub2504.exgui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import pub2504.network.Data;

// 과제 : GUI 메모장 프로그램 (V3, V4) ~ 7/6, 능력단위평가 대체

// [구조 변경] 
// 1) Memo.java 클래스 생성 // 제목, 내용
// 2) Map<String, String>을 List<Memo> 구조로 변경
// 3) 파일 > 새메모, 열기, 저장 메뉴 구조를 파일 > 저장, 열기 구조로 변경

// [기능 추가]
// 1) 파일 > 저장 : 현재 메모 내용을 "C:\\pub2504\\memojson\\memo_년월일시분초.json"형태로 저장
// 2) 파일 > 열기 : 기존 메모파일을 열기 JFileChooser

// [네트워크 버젼]
// Json Server에 memo.json 추가해서 네트워크 버젼 구현 (ExMemopad4.java)

public class ExMemoPad3 extends JFrame {
   
   private static final long serialVersionUID = 328940723948793L;

    private ListModel<Memo> memoListModel = null;
    private JList<Memo> memoList = null;
    private JTextArea memoTextArea = null;
    private JTextField memoTextField = null;
    private List<Memo> inputMemoList = null;

    private void init() {
       
       inputMemoList = new ArrayList<Memo>();

       setTitle("메모장 프로그램");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        JMenuBar jMenuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("파일");
        JMenu infoMenu = new JMenu("정보");
        JMenuItem fileMenuItemNew = new JMenuItem("새메모");
        JMenuItem fileMenuItemOpen = new JMenuItem("열기");
        JMenuItem fileMenuItemSave = new JMenuItem("저장");
//        fileMenu.add(fileMenuItemNew);
        fileMenu.add(fileMenuItemOpen);
        fileMenu.add(fileMenuItemSave);
        jMenuBar.add(fileMenu);
        jMenuBar.add(infoMenu);
        
        JFrame jframe = this;
        
        // 정보 메뉴에 리스너 추가
        infoMenu.addMenuListener(new MenuListener() {
         // 정보 선택 시 메세지창 보여줌
         @Override
         public void menuSelected(MenuEvent e) {
            JLabel message = new JLabel("Copyright 2025 minkyoung");
            message.setHorizontalAlignment(SwingConstants.CENTER);
            JOptionPane.showMessageDialog(jframe, message);
         }
         @Override
         public void menuDeselected(MenuEvent e) {
         }
         @Override
         public void menuCanceled(MenuEvent e) {
         }
      });
        
        // 저장 클릭 시 파일 json형태로 저장
        fileMenuItemSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFile(inputMemoList);
			}
		});
        
        fileMenuItemOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
        
        memoListModel = new DefaultListModel<Memo>();
        memoList = new JList<Memo>(memoListModel);
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
        JButton addButton = new JButton("메모 등록");
        JButton editButton = new JButton("메모 수정");
        JButton deleteButton = new JButton("메모 삭제");

        addButtons(buttonPanel, addButton, editButton, deleteButton);

        addActionListener(addButton, editButton, deleteButton);
        
        memoList.addListSelectionListener(e -> displaySelectedMemo());

        add(jMenuBar, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        add(listScrollPane, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
        
    } // init

    // 메모 등록 메소드
    private void addMemo() {
       String memoTitle = memoTextField.getText().trim();
        if (memoTitle.isEmpty()) {
           JOptionPane.showMessageDialog(this, "메모 제목을 입력하세요.");
           return;
        }
        
        // 동일한 제목 등록 불가
    		for(Memo memo : inputMemoList) {
        		if (memo.getTitle().equals(memoTitle)) {
        			JOptionPane.showMessageDialog(this, "메모 제목 중복입니다!");
        			return;
        		}
        	}
        
        String memoContent = memoTextArea.getText().trim();
        if (!memoContent.isEmpty()) {
        	
        	// 메모 객체 생성
        	Memo newMemo = new Memo(memoTitle, memoContent);
        	inputMemoList.add(newMemo);
        	
        	// ListModel에 addElement없으므로 DefaultListModel<Memo> 형변환함
        	((DefaultListModel<Memo>) memoListModel).addElement(newMemo);
        	
        	memoTextArea.setText("");
            memoTextField.setText("");
            JOptionPane.showMessageDialog(this, "메모가 등록되었습니다.");
        } else {
            JOptionPane.showMessageDialog(this, "메모 내용을 입력하세요.");
        }
    } // addMemo

    // 메모 수정 메서드
    private void editMemo() {
        int selectedIndex = memoList.getSelectedIndex();
        if (selectedIndex != -1) {
           String memoTitle = memoTextField.getText().trim();
            if (memoTitle.isEmpty()) {
               JOptionPane.showMessageDialog(this, "메모 제목을 입력하세요.");
               return;
            }           
            String memoContent = memoTextArea.getText().trim();
            System.out.println(memoTitle + memoContent);
            if (!memoContent.isEmpty()) {
            	Memo newMemo = inputMemoList.get(selectedIndex);
            	newMemo.setTitle(memoTitle);
            	newMemo.setContent(memoContent);
            	inputMemoList.set(selectedIndex, newMemo);
            	((DefaultListModel<Memo>)memoListModel).set(selectedIndex, newMemo);
                JOptionPane.showMessageDialog(this, "메모가 수정되었습니다.");
            } else {
                JOptionPane.showMessageDialog(this, "메모 내용을 입력하세요.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "수정할 메모를 선택하세요.");
        }
    } // editMemo

    // 메모 삭제 메서드
    private void deleteMemo() {
        int selectedIndex = memoList.getSelectedIndex();
        if (selectedIndex != -1) {
        	inputMemoList.remove(selectedIndex);
            ((DefaultListModel<Memo>) memoListModel).remove(selectedIndex);
            memoTextField.setText("");
            memoTextArea.setText("");
            JOptionPane.showMessageDialog(this, "메모가 삭제되었습니다.");
        } else {
            JOptionPane.showMessageDialog(this, "삭제할 메모를 선택하세요.");
        }
    } // deleteMemo

    // 선택된 메모를 화면에 표시
    private void displaySelectedMemo() {
        int selectedIndex = memoList.getSelectedIndex();
        if (selectedIndex != -1) {
        	memoTextField.setText(inputMemoList.get(selectedIndex).getTitle());
        	memoTextArea.setText(inputMemoList.get(selectedIndex).getContent());
        }
    } // displaySelectedMemo
    
    // 버튼에 리스너 추가
    private void addActionListener(JButton... jbuttons) {
       for (JButton jbutton : jbuttons) {
          jbutton.addActionListener(e -> {
             switch (((JButton)e.getSource()).getText()) {
                case "메모 등록" : addMemo(); break;  
                case "메모 수정" : editMemo(); break;  
                case "메모 삭제" : deleteMemo();
             }
          });
       }
    } // addActionListener
    
    // 패널에 버튼 추가
    private void addButtons(JPanel jpanel, JButton... jbuttons) {
       for (JButton jbutton : jbuttons) {
          jpanel.add(jbutton);
       }
    } // addButtons
    
    // 메모리스트 C:\\pub2504\\memojson\\memo_년월일시분초.json 형태로 저장
    private void saveFile(List<Memo> inputmemoList) {
    	new File("C:\\pub2504\\memojson").mkdir();
    	
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	
    	// List<Memo> -> json문자열
    	String memo = gson.toJson(inputmemoList);
    	
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("YYMMddHHmmss");
    	
    	PrintWriter pw = null;
    	try {
    		
    		if(memo.isEmpty()) {
    			JOptionPane.showMessageDialog(this, "저장할 json파일이 없습니다!");
    			return;
    		}
    		
    		pw = new PrintWriter("C:\\pub2504\\memojson\\memo_" + sdf.format(date) + ".json");
    		pw.append(memo);
    		pw.flush();
    		
    		JOptionPane.showMessageDialog(this, "memo_" + sdf.format(date) + ".json 파일 저장 완료!");
    		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
    	
    } // saveFile
    
    // 파일 열기
    public void openFile() {
    	JFileChooser chooseFile = new JFileChooser();
    	int returnVal = chooseFile.showOpenDialog(this);
    	if(returnVal == JFileChooser.APPROVE_OPTION) {
    		System.out.println(chooseFile.getSelectedFile());
    		
    		JsonReader reader = null;
    		String title = null;
    		String content = null;
    		
    		try {
    			// gson의 jsonreader로 json 파일 읽어옴
    			reader = new JsonReader(new FileReader(chooseFile.getSelectedFile()));
    			// json 배열 시작 [
    			reader.beginArray();
    			while(reader.hasNext()) { // 배열 다음 요소가 있는 경우
    				reader.beginObject(); // 객체 시작 {
    				
    				while(reader.hasNext()) { // 객체 다음 요소 있는 경우
    					String name = reader.nextName(); // key값
    					if(name.equals("title")) { // key값이 title이면
    						title = reader.nextString(); // String 다음 토큰 value을 title에 넣음
    					} else if(name.equals("content")) { // key값이 content이면
    						content = reader.nextString(); // String 다음 토큰 value을 content에 넣음
    					} else {
    						reader.skipValue(); // 다음 value로 스킵
    					}
    				}
    				reader.endObject(); // 객체 끝 }
    				
    				// 객체 하나가 끝날 때마다
    				// UI에 반영될 memoListModel에 memo객체를 넣음
    				((DefaultListModel<Memo>)memoListModel).addElement(new Memo(title, content));
    				
    				// 불러온 파일의 선택하면 파일이 보여지게 하기 위해
    				// 실제 데이터 리스트 inputMemoList에 memo객체를 넣음
    				inputMemoList.add(new Memo(title, content));
    			}
    			reader.endArray(); // 배열 끝 ]
    			
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
    	}
    	
    	
    } // openFile

    public static void main(String[] args) {
        new ExMemoPad3().init();
    }
    
}
