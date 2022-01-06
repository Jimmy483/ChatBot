package sample;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main implements  ActionListener{
    JButton btnSend=new JButton();
    TextField message=new TextField();
    TextArea textArea=new TextArea();
    Label title=new Label();
    public static void main(String[] args) {
        new Main();
    }


    public Main(){



            JFrame frame=new JFrame();
            frame.setTitle("Chat by Gmi");
            frame.setSize(500,500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel=new JPanel();
            panel.setLayout(null);
            frame.add(panel,BorderLayout.CENTER);

            title.setText("Chat with Bot");
            title.setBounds(130,20,200,50);
            title.setForeground(Color.pink);
            title.setFont(new Font("Arial",Font.BOLD,30));
            panel.add(title);


            textArea.setBounds(40,80,390,300);
            textArea.setEditable(false);
//            textArea.addKeyListener(new KeyListener() {
//                @Override
//                public void keyTyped(KeyEvent e) {
//                    e.consume();
//                }
//
//                @Override
//                public void keyPressed(KeyEvent e) {
//
//                }
//
//                @Override
//                public void keyReleased(KeyEvent e) {
//
//                }
//            });
            panel.add(textArea);


            message.setBounds(40,400,330,30);
            message.setFont(new Font("Arial",Font.PLAIN,20));
            panel.add(message);


            btnSend.setText("Send");
            btnSend.setBackground(Color.GREEN);
            btnSend.setBounds(380,400,80,30);
            btnSend.setBorder(new RoundedBorder(10));
            btnSend.addActionListener(this);
            panel.add(btnSend);


            frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String mes=message.getText();
        if(message.getText().length()>10){

            boolean check=true;
            String mess=mes;

            while(check){
                if(mess.length()<20){
                    textArea.append(mess + "\n");
                    check=false;
                }
                else {
                    textArea.append(mess.substring(0, 20) + "\n");
                    mess = mess.substring(20);

                    if (mess.length() < 1) {
                        check = false;
                    }
                }


            }
        }
        else {
            textArea.append(mes + "\n");
        }

        message.setText("");


    }
}
