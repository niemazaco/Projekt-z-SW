import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class Board {

    static final int MIN=0;
    static final int MAX=100;
    static final int FPS=15;

    static JSlider potencjometr1=new JSlider(JSlider.HORIZONTAL,MIN,MAX,FPS);

    static JPanel led0=new JPanel();
    static JPanel led1=new JPanel();
    static JPanel led2=new JPanel();
    static JPanel led3=new JPanel();
    static JPanel led4=new JPanel();
    static JPanel led5=new JPanel();
    static JPanel led6=new JPanel();
    static JPanel led7=new JPanel();

    static JTextArea tks1;
    static JTextArea tks2;

    static JButton s1;
    static JButton s2;
    static JButton s3;
    static JButton s4;
    static JButton s5;
    static JButton s6;
    static JButton s7;
    static JButton s8;

    static JPanel rbg_diod;

    public Board(){


        JFrame jFrame=new JFrame("Płytka ewaluacyjna");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800,500);
        jFrame.setLayout(new GridLayout(3,2));
        jFrame.setBackground(Color.RED);

        JTextArea tekst1=new JTextArea("");
        JPanel tekst2=new JPanel();
        tekst2.setBackground(Color.cyan);
        tekst2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tekst2.setLayout(new GridLayout(2,0));
        tks1=new JTextArea("");
        tks1.setFont(new Font("LCD",Font.PLAIN,40));
        tks2=new JTextArea("");
        tks2.setFont(new Font("",Font.PLAIN,40));
        tekst2.add(tks1);
        tekst2.add(tks2);
        tks1.setBackground(Color.cyan);
        tks2.setBackground(Color.cyan);


        JTextArea tekst3=new JTextArea("");
        JPanel tekst4=new JPanel();
        tekst4.setLayout(new GridLayout(2,0));

        JPanel leds=new JPanel();
        leds.setBackground(Color.RED);


        led0.setBackground(Color.WHITE);
        led1.setBackground(Color.WHITE);
        led2.setBackground(Color.WHITE);
        led3.setBackground(Color.WHITE);
        led4.setBackground(Color.WHITE);
        led5.setBackground(Color.WHITE);
        led6.setBackground(Color.WHITE);
        led7.setBackground(Color.WHITE);
        led0.setPreferredSize(new Dimension(20,20));
        led1.setPreferredSize(new Dimension(20,20));
        led2.setPreferredSize(new Dimension(20,20));
        led3.setPreferredSize(new Dimension(20,20));
        led4.setPreferredSize(new Dimension(20,20));
        led5.setPreferredSize(new Dimension(20,20));
        led6.setPreferredSize(new Dimension(20,20));
        led7.setPreferredSize(new Dimension(20,20));

        led0.setBorder(BorderFactory.createLineBorder(Color.black));
        led1.setBorder(BorderFactory.createLineBorder(Color.black));
        led2.setBorder(BorderFactory.createLineBorder(Color.black));
        led3.setBorder(BorderFactory.createLineBorder(Color.black));
        led4.setBorder(BorderFactory.createLineBorder(Color.black));
        led5.setBorder(BorderFactory.createLineBorder(Color.black));
        led6.setBorder(BorderFactory.createLineBorder(Color.black));
        led7.setBorder(BorderFactory.createLineBorder(Color.black));

        JTextArea ledy=new JTextArea("LED");
        ledy.setBackground(Color.RED);
        leds.add(ledy);
        leds.add(led0);
        leds.add(led1);
        leds.add(led2);
        leds.add(led3);
        leds.add(led4);
        leds.add(led5);
        leds.add(led6);
        leds.add(led7);




        JPanel rgb=new JPanel();
        rbg_diod=new JPanel();
        rbg_diod.setBackground(Color.WHITE);
        rbg_diod.setPreferredSize(new Dimension(30,30));
        rbg_diod.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        rgb.setBackground(Color.RED);
        JTextArea rgb_text=new JTextArea("RGB");
        rgb_text.setBackground(Color.RED);
        rgb.add(rgb_text);
        rgb.add(rbg_diod);
        tekst4.add(rgb);
        tekst4.add(leds);



        JTextArea tekst5=new JTextArea("");




        JPanel tekst8=new JPanel();
        tekst1.setBackground(Color.RED);
        tekst3.setBackground(Color.RED);
        tekst4.setBackground(Color.RED);
        tekst5.setBackground(Color.RED);
        tekst8.setBackground(Color.RED);
        jFrame.add(tekst1);
        jFrame.add(tekst2);
        jFrame.add(tekst3);
        jFrame.add(tekst4);
        jFrame.add(tekst5);
        //jFrame.add(tekst6);
        //jFrame.add(tekst7);
        jFrame.add(tekst8);
        tekst8.setLayout(new GridLayout(3,0));

        JPanel empty1=new JPanel();
        JPanel empty2=new JPanel();
        JPanel empty3=new JPanel();
        empty1.setBackground(Color.RED);
        empty2.setBackground(Color.RED);
        JPanel buttons=new JPanel();
        buttons.setBackground(Color.RED);
        empty3.setBackground(Color.RED);
        tekst8.add(buttons);
        tekst8.add(empty1);
        tekst8.add(empty2);


        JSlider potencjometr2=new JSlider(JSlider.HORIZONTAL,MIN,MAX,FPS);
        potencjometr1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            }
        });
        potencjometr1.setBorder(BorderFactory.createLineBorder(Color.black));
        potencjometr2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JTextArea pot1=new JTextArea("POT1");
        JTextArea pot2=new JTextArea("POT2");
        pot1.setBackground(Color.RED);
        pot2.setBackground(Color.RED);

        empty1.add(pot1);
        empty1.add(potencjometr1);
        empty2.add(pot2);
        empty2.add(potencjometr2);


        s1=new JButton("s1");
        s2=new JButton("s2");
        s3=new JButton("s3");
        s4=new JButton("s4");
        s5=new JButton("s5");
        s6=new JButton("s6");
        s7=new JButton("s7");
        s8=new JButton("s8");
        s1.setBorder(BorderFactory.createLineBorder(Color.black));
        s2.setBorder(BorderFactory.createLineBorder(Color.black));
        s3.setBorder(BorderFactory.createLineBorder(Color.black));
        s4.setBorder(BorderFactory.createLineBorder(Color.black));
        s5.setBorder(BorderFactory.createLineBorder(Color.black));
        s6.setBorder(BorderFactory.createLineBorder(Color.black));
        s7.setBorder(BorderFactory.createLineBorder(Color.black));
        s8.setBorder(BorderFactory.createLineBorder(Color.black));

        s1.setPreferredSize(new Dimension(30,30));
        s2.setPreferredSize(new Dimension(30,30));
        s3.setPreferredSize(new Dimension(30,30));
        s4.setPreferredSize(new Dimension(30,30));
        s5.setPreferredSize(new Dimension(30,30));
        s6.setPreferredSize(new Dimension(30,30));
        s7.setPreferredSize(new Dimension(30,30));
        s8.setPreferredSize(new Dimension(30,30));

        buttons.add(s1);
        buttons.add(s2);
        buttons.add(s3);
        buttons.add(s4);
        buttons.add(s5);
        buttons.add(s6);
        buttons.add(s7);
        buttons.add(s8);

        jFrame.setResizable(true);
        jFrame.setVisible(true);
    }
    public static void main(String args[]) throws IOException {
        Board board=new Board();
        try{
            ServerSocket myServerSocket=new ServerSocket(9999);
            System.out.println("Server is waiting for connection: "+InetAddress.getLocalHost().getCanonicalHostName()+", port= "+myServerSocket.getLocalPort());
            Socket skt=myServerSocket.accept();

            BufferedReader myInput=new BufferedReader(new InputStreamReader(skt.getInputStream()));
            PrintStream myOutput=new PrintStream(skt.getOutputStream());
            String buf=myInput.readLine();
            if(buf!=null){
                System.out.println("Server read:"+buf);
                //myOutput.print("Got it");
            }

            if(buf.equals("1")){

                System.out.println("Kontrolowanie wyjscia audio hosta za pomoca potencjometru:");
                //TA CZESC JEST W MIARE ZROBIONA, PASUJE JEDYNIE POPRAWIC WYSWIETLANIE OSTATNIEJ DIODY LED,
                //ALE TO TEZ JEST OPCJONALNE



                int pot;
                String buffer1;
                int temp;
                while (true){
                    pot=potencjometr1.getValue();
                    System.out.println("Wysylam wartosc: "+pot+"\n");
                    myOutput.print(Integer.toString(pot)+"\n");
                    buffer1=myInput.readLine();
                    temp=Integer.parseInt(buffer1);
                    if(temp==100){
                        led0.setBackground(Color.GREEN);
                        led1.setBackground(Color.GREEN);
                        led2.setBackground(Color.GREEN);
                        led3.setBackground(Color.GREEN);
                        led4.setBackground(Color.GREEN);
                        led5.setBackground(Color.GREEN);
                        led6.setBackground(Color.GREEN);
                        led7.setBackground(Color.GREEN);
                    }
                    if(temp>=87.5){
                        led0.setBackground(Color.GREEN);
                        led1.setBackground(Color.GREEN);
                        led2.setBackground(Color.GREEN);
                        led3.setBackground(Color.GREEN);
                        led4.setBackground(Color.GREEN);
                        led5.setBackground(Color.GREEN);
                        led6.setBackground(Color.GREEN);
                        led7.setBackground(Color.WHITE);

                    }else if(temp>=75.0){
                        led0.setBackground(Color.GREEN);
                        led1.setBackground(Color.GREEN);
                        led2.setBackground(Color.GREEN);
                        led3.setBackground(Color.GREEN);
                        led4.setBackground(Color.GREEN);
                        led5.setBackground(Color.GREEN);
                        led6.setBackground(Color.WHITE);
                        led7.setBackground(Color.WHITE);
                    }else if(temp>=62.5){
                        led0.setBackground(Color.GREEN);
                        led1.setBackground(Color.GREEN);
                        led2.setBackground(Color.GREEN);
                        led3.setBackground(Color.GREEN);
                        led4.setBackground(Color.GREEN);
                        led5.setBackground(Color.WHITE);
                        led6.setBackground(Color.WHITE);
                        led7.setBackground(Color.WHITE);
                    }else if(temp>=50.0){
                        led0.setBackground(Color.GREEN);
                        led1.setBackground(Color.GREEN);
                        led2.setBackground(Color.GREEN);
                        led3.setBackground(Color.GREEN);
                        led4.setBackground(Color.WHITE);
                        led5.setBackground(Color.WHITE);
                        led6.setBackground(Color.WHITE);
                        led7.setBackground(Color.WHITE);
                    }else if(temp>=37.5){
                        led0.setBackground(Color.GREEN);
                        led1.setBackground(Color.GREEN);
                        led2.setBackground(Color.GREEN);
                        led3.setBackground(Color.WHITE);
                        led4.setBackground(Color.WHITE);
                        led5.setBackground(Color.WHITE);
                        led6.setBackground(Color.WHITE);
                        led7.setBackground(Color.WHITE);
                    }else if(temp>=25.0){
                        led0.setBackground(Color.GREEN);
                        led1.setBackground(Color.GREEN);
                        led2.setBackground(Color.WHITE);
                        led3.setBackground(Color.WHITE);
                        led4.setBackground(Color.WHITE);
                        led5.setBackground(Color.WHITE);
                        led6.setBackground(Color.WHITE);
                        led7.setBackground(Color.WHITE);
                    }else if(temp>=12.5){
                        led0.setBackground(Color.GREEN);
                        led1.setBackground(Color.WHITE);
                        led2.setBackground(Color.WHITE);
                        led3.setBackground(Color.WHITE);
                        led4.setBackground(Color.WHITE);
                        led5.setBackground(Color.WHITE);
                        led6.setBackground(Color.WHITE);
                        led7.setBackground(Color.WHITE);
                    }else{
                        led0.setBackground(Color.WHITE);
                        led1.setBackground(Color.WHITE);
                        led2.setBackground(Color.WHITE);
                        led3.setBackground(Color.WHITE);
                        led4.setBackground(Color.WHITE);
                        led5.setBackground(Color.WHITE);
                        led6.setBackground(Color.WHITE);
                        led7.setBackground(Color.WHITE);
                    }
                    Thread.sleep(100);
                }

            }else if(buf.equals("3")){

                /* WYSWIETLANIE OBCIAZENIA SYSTEMU HOSTA:*/
                //TA STRONA ROWNIEZ NIE WYMAGA JAKIS WIELKICH MODYFIKACJI
                //GLOWNIE PASUJE PO STRONIE KLIENTA DOSTOWSOWAC POBIERANIE WARTOSCI


                String buffer1;
                String buffer2;
                String buffer3;

                while(true){

                    buffer1=myInput.readLine();
                    tks1.setText("Temperatura(C)");
                    tks2.setText(String.valueOf(buffer1));

                    buffer2=myInput.readLine();
                    tks1.setText("%RAM");
                    tks2.setText(String.valueOf(buffer2));

                    buffer3=myInput.readLine();
                    tks1.setText("%CPU");
                    tks2.setText(String.valueOf(buffer3));
                }

            }else if(buf.equals("4")){

                /* KlAWISZE SKRÓTU:*/
                //TEN ELEMENT PO TEJ STRONIE NIE WYMAGA WIELKICH MODYFIKACJI OPROCZ ZMIAN NAPISOW
                //PO STRONIE HOSTA PASOWALOBY ZROBIC JAKIES KONKRETNE AKCJI NP. URUCHOMIENIE FIREFOXA, ITD.



                String bufor1;
                int temp;
                //String buffer1,buffer2,buffer3,buffer4,buffer5,buffer6,buffer7,buffer8;
                s1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        myOutput.print(1+"\n");
                    }
                });
                s2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        myOutput.print(2+"\n");
                    }
                });
                s3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        myOutput.print(3+"\n");
                    }
                });
                s4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        myOutput.print(4+"\n");
                    }
                });
                s5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        myOutput.print(5+"\n");
                    }
                });
                s6.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        myOutput.print(6+"\n");
                    }
                });
                s7.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        myOutput.print(7+"\n");
                    }
                });
                s8.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        myOutput.print(8+"\n");
                    }
                });
                /////////
                ////////
                while(true){
                    bufor1=myInput.readLine();
                    temp=Integer.parseInt(bufor1);
                    if(temp==1){
                        tks1.setText("Klawisz S1");
                        tks2.setText("Google");
                    }else if(temp==2){
                        tks1.setText("Klawisz S2");
                        tks2.setText("elf2.pk.edu.pl");
                    }else if(temp==3){
                        tks1.setText("Klawisz S3");
                        tks2.setText("Github");
                    }else if(temp==4){
                        tks1.setText("Klawisz S4");
                        tks2.setText("pk.edu.pl");
                    }else if(temp==5){
                        tks1.setText("Klawisz S5");
                        tks2.setText("Youtube");
                    }else if(temp==6){
                        tks1.setText("Klawisz S6");
                        tks2.setText("Nasa");
                    }else if(temp==7){
                        tks1.setText("Klawisz S7");
                        tks2.setText("AND-TECH.pl");
                    }else if(temp==8){
                        tks1.setText("Klawisz S8");
                        tks2.setText("Centrum rowerowe");
                    }
                }

            }else if(buf.equals("5")){

                //PO TEJ STRONIE RACZEJ NIE TRZEBA MODYFIKACJI
                //GLOWNE ZMIANY MUSZA ZAJSC W POBIERANIU USREDNIONYCH BARW PO STRONIE KLIENTA
                /*WYSWIETLANIE KOLORU NA RGB*/



                String buffer1,buffer2,buffer3;
                int temp1,temp2,temp3;
                while (true){
                    buffer1=myInput.readLine();
                    temp1=Integer.parseInt(buffer1);
                    buffer2=myInput.readLine();
                    temp2=Integer.parseInt(buffer2);
                    buffer3=myInput.readLine();
                    temp3=Integer.parseInt(buffer3);
                    rbg_diod.setBackground(new Color(temp1,temp2,temp3));
                }
            }
            skt.close();
            System.out.println("Server is exiting!");
        }catch (IOException | InterruptedException exc){
            exc.printStackTrace();
            System.out.println("Error!");
        }
    }

    void write(PrintWriter output,String message){
        System.out.println("Sending: "+message);
        output.println(message);
    }
}
