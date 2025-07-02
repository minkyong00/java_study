package pub2504.network.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class ChatClientGUI extends JFrame {
   
   public static final long serialVersionUID = 392847893232423447L;
   
   private JTextArea messageArea;
   private JTextField textField;
   private JButton exitButton;
   private ChatClient client;

   public ChatClientGUI() {
      
      super(":: Java Chatting ::");
      setSize(400, 500);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      Color backgroundColor = new Color(240, 240, 240);
      Color buttonColor = new Color(75, 75, 75);
      Color textColor = new Color(50, 50, 50);
      Font textFont = new Font("Malgun Gothic", Font.PLAIN, 14);
      Font buttonFont = new Font("Malgun Gothic", Font.BOLD, 12);

      messageArea = new JTextArea();
      messageArea.setEditable(false);
      messageArea.setBackground(backgroundColor);
      messageArea.setForeground(textColor);
      messageArea.setFont(textFont);
      JScrollPane scrollPane = new JScrollPane(messageArea);
      add(scrollPane, BorderLayout.CENTER);

      String name = JOptionPane.showInputDialog(this, "아이디를 입력하세요:", "아이디 입력", JOptionPane.PLAIN_MESSAGE);
      this.setTitle("접속자 아이디 : " + name);
      textField = new JTextField();
      textField.setFont(textFont);
      textField.setForeground(textColor);
      textField.setBackground(backgroundColor);
      textField.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String message = "[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] " + name + ": "
                  + textField.getText();
            client.sendMessage(message);
            textField.setText("");
         }
      });
      exitButton = new JButton("나가기");
      exitButton.setFont(buttonFont);
      exitButton.setBackground(buttonColor);
      exitButton.setForeground(Color.WHITE);
      exitButton.addActionListener(e -> {
         String departureMessage = name + " 님이 채팅방을 나갔습니다!";
         client.sendMessage(departureMessage);
         try {
            Thread.sleep(1000);
         } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
         }
         System.exit(0);
      });

      JPanel bottomPanel = new JPanel(new BorderLayout());
      bottomPanel.setBackground(backgroundColor);
      bottomPanel.add(textField, BorderLayout.CENTER);
      bottomPanel.add(exitButton, BorderLayout.EAST);
      add(bottomPanel, BorderLayout.SOUTH);
      try {
         this.client = new ChatClient("192.168.8.254", 5000, this::onMessageReceived);
         client.startClient();
      } catch (IOException e) {
         e.printStackTrace();
         JOptionPane.showMessageDialog(this, "Error connecting to the server", "Connection error",
               JOptionPane.ERROR_MESSAGE);
         System.exit(1);
      }
   }

   private void onMessageReceived(String message) {
      SwingUtilities.invokeLater(() -> messageArea.append(message + "\n"));
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         new ChatClientGUI().setVisible(true);
      });
   }

} // class