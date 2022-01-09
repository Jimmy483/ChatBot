package sample;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Main implements  ActionListener {
    JButton btnSend=new JButton();
    TextField message=new TextField();
    TextArea textArea=new TextArea();
    Label title=new Label();
    String[] arr={"Hi","Nice to meet you","I love you too","My name is Borat and i am from Kazakhstan. My neighbours are noisy and always try to copy me"};

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
            float a=textArea.getAlignmentX();
            float b=textArea.getWidth();
        System.out.println(a + "" +b);
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
            message.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode()==10){
                        enter();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });
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

    public void enter(){

        String mes=message.getText();
        if(mes.equals("")){
            return;
        }
        if(message.getText().length()>20){

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
        Random rn=new Random();
        int num=rn.nextInt(4);
        //aligning bot message to right
        for(int i=0;i<60;i++){
            textArea.append(" ");
        }

        //aligning message to right for short sentences
        if(arr[num].length()<40){
            for(int j=0;j<(40-arr[num].length());j++){
                textArea.append(" ");
            }
        }

        int leng=arr[num].length();
//        for(int i=0;i<leng;i++){
//
//            textArea.append(arr[num].substring(i,i+1));
//            System.out.println(textArea.getCursor().toString());
//
//        }
//        int changeWidth=textArea.getWidth()/2;
//        boolean check=true;
//
//        if(leng*30>changeWidth){
//            while(leng*30>=changeWidth){
//                textArea.append(arr[num].substring(0,changeWidth/30));
//                arr[num]=arr[num].substring(changeWidth/30,leng);
//                if(arr[num].length()<changeWidth/30){
//                    textArea.append(arr[num]);
//                }
//                leng=leng-(int)(changeWidth/30);
//
//            }
//            textArea.append("\n");
//        }

        //textArea.append("\n");
        //textArea.append(arr[num] + "\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        enter();

    }
}
