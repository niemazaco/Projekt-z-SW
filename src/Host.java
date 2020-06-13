import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Host{
    static String userInput;

    public static void main(String args[]){
        String host;
        int port;
        if(args.length==0){
            host="localhost";
            port=9999;
        }else{
            host=args[0];
            String portStr=args[1];
            try{
                port=Integer.parseInt(portStr);
            }catch (NumberFormatException nfe){
                System.out.println("Invalid port number!");
                port=9999;
            }
        }
        try{
            System.out.println("Host attempt to connect to server:"+host+","+port);
            Socket skt=new Socket(host,port);
            BufferedReader myinput=new BufferedReader(new InputStreamReader(skt.getInputStream()));
            PrintStream myoutput=new PrintStream(skt.getOutputStream());

            Scanner scanner=new Scanner(System.in);
            System.out.println("Ktory element ukladu wybierasz:");
            int i=scanner.nextInt();
            if(i==1 || i==2){
                myoutput.print("1\n");
                //String buffer1;
                System.out.println("Wybrano projekt nr 1 i 2");
                String tmpLine = "";
                System.out.println("Dostalem sie do dzwieku!");
                while ((userInput = myinput.readLine()) != null) {
                    System.out.println(userInput);
                    try 
                    {
                        Process p = Runtime.getRuntime().exec(
                        new String[]{"amixer", "-D", "pulse", "sset", "'Master'", userInput.toString()+"%"});
                        p.waitFor();
                    } catch (IOException e) {
                        throw e;
                    }

                    
                    ProcessBuilder builder =
                        new ProcessBuilder("amixer", "-D", "pulse", "sget", "'Master'");
                        builder.inheritIO().redirectOutput(ProcessBuilder.Redirect.PIPE);
                        Process p = builder.start();
                    

                    
                    try (BufferedReader buf =
                    new BufferedReader(new InputStreamReader(p.getInputStream()))) 
                    {
                        String line;
                        while ((line = buf.readLine()) != null) {
                        if (line.contains("%]")) 
                        {
                            tmpLine=line.substring(line.indexOf("[")+1, line.indexOf("%"));
                            break;
                        }
                        }
                    }

                    p.waitFor();
                    if(tmpLine=="")
                        tmpLine="0";
                    myoutput.print(tmpLine+"\n");
                    Thread.sleep(10);

                }
                myinput.close();
                skt.close();
            }else if(i==3){
                //Wyswietlanie obciazania systemu Hosta:
                myoutput.print("3\n");

                DecimalFormat df = new DecimalFormat("##.##");
                Process temp;
                Process total;
                Process used;
                Process cpu;

                BufferedReader readerT;
                BufferedReader reader1;
                BufferedReader reader2;
                BufferedReader reader3;
                String line1;

                String line2;
                String line3;
                String line4;
                double ram;

                while(true) {

                    temp = Runtime.getRuntime().exec(new String[]{"bash", "-c", "cat /sys/class/thermal/thermal_zone0/temp"});
                    total = Runtime.getRuntime().exec(new String[]{"bash", "-c", "free | grep Mem | cut -d \" \" -f8"});
                    used = Runtime.getRuntime().exec(new String[]{"bash", "-c", "free | grep Mem | cut -d \" \" -f13"});
                    cpu = Runtime.getRuntime().exec(new String[]{"bash", "-c", "grep \'cpu \' /proc/stat | awk \'{usage=($2+$4)*100/($2+$4+$5)} END {print usage}\'"});

                    temp.waitFor();
                    readerT = new BufferedReader(new InputStreamReader(temp.getInputStream()));

                    total.waitFor();
                    reader1 = new BufferedReader(new InputStreamReader(total.getInputStream()));
                    used.waitFor();
                    reader2 = new BufferedReader(new InputStreamReader(used.getInputStream()));

                    cpu.waitFor();
                    reader3 = new BufferedReader(new InputStreamReader(cpu.getInputStream()));
                    line1 = readerT.readLine();

                    line2 = reader1.readLine();
                    line3 = reader2.readLine();
                    line4 = reader3.readLine();
                    ram = (Double.parseDouble(line2) / Double.parseDouble(line3));


                    myoutput.print(String.valueOf(Integer.parseInt(line1) / 1000) + "\n");

                    Thread.sleep(1500);
                    myoutput.print(df.format(ram) + "\n");
                    Thread.sleep(1500);
                    myoutput.print(df.format(Double.parseDouble(line4)) + "\n");
                    Thread.sleep(1500);
                }


            }else if(i==4){

                String buffer1;
                int temp;
                /*AKCJA NA PRZYCISKACH:*/
                myoutput.print("4\n");
                while(true){
                    buffer1=myinput.readLine();
                    temp=Integer.parseInt(buffer1);
                    if(temp==1){
                        try{
                            String url = "http://www.google.com";
                            Desktop.getDesktop().browse(new URL(url).toURI());
                        }
                        catch(Exception E){
                            System.err.println("Exp : "+E.getMessage());
                        }
                        myoutput.print(1+"\n");
                    }
                    else if(temp==2){
                        try{
                            String url = "http://www.elf2.pk.edu.pl";
                            Desktop.getDesktop().browse(new URL(url).toURI());
                        }
                        catch(Exception E){
                            System.err.println("Exp : "+E.getMessage());
                        }
                        myoutput.print(2+"\n");
                    }
                    else if(temp==3){
                        try{
                            String url = "http://www.github.com";
                            Desktop.getDesktop().browse(new URL(url).toURI());
                        }
                        catch(Exception E){
                            System.err.println("Exp : "+E.getMessage());
                        }
                        myoutput.print(3+"\n");
                    }
                    else if(temp==4){
                        try{
                            String url = "http://www.pk.edu.pl";
                            Desktop.getDesktop().browse(new URL(url).toURI());
                        }
                        catch(Exception E){
                            System.err.println("Exp : "+E.getMessage());
                        }
                        myoutput.print(4+"\n");
                    }
                    else if(temp==5){
                        try{
                            String url = "http://www.youtube.com";
                            Desktop.getDesktop().browse(new URL(url).toURI());
                        }
                        catch(Exception E){
                            System.err.println("Exp : "+E.getMessage());
                        }
                        myoutput.print(5+"\n");
                    }
                    else if(temp==6){
                        try{
                            String url = "http://www.nasa.gov";
                            Desktop.getDesktop().browse(new URL(url).toURI());
                        }
                        catch(Exception E){
                            System.err.println("Exp : "+E.getMessage());
                        }
                        myoutput.print(6+"\n");
                    }
                    else if(temp==7){
                        try{
                            String url = "https://and-tech.pl/zestaw-evb-5-1/";
                            Desktop.getDesktop().browse(new URL(url).toURI());
                        }
                        catch(Exception E){
                            System.err.println("Exp : "+E.getMessage());
                        }
                        myoutput.print(7+"\n");
                    }
                    else if(temp==8){
                        try{
                            String url = "https://www.centrumrowerowe.pl/rowery/";
                            Desktop.getDesktop().browse(new URL(url).toURI());
                        }
                        catch(Exception E){
                            System.err.println("Exp : "+E.getMessage());
                        }
                        myoutput.print(8+"\n");
                    }
                }
            }else if(i==5){
                myoutput.print("5\n");
                /* WYSWIETLANIE KOLORU NA RGB*/
                //Wartosci na sztywno, do modyfikacji:
                //TRZEBA POZYSKAC WARTOSC KOLOROW DO PRZESLANIA
                int SECT_SKIP=10;
                Robot robot;
                try {
                    robot=new Robot();
                    Dimension screenSize;
                    BufferedImage screen;
                    int X_RES;
                    int Y_RES;
                    int width,heigh;
                    int r,g,b;
                    int loops=0;
                    int rgb;
                    Color color;
                    BufferedImage imgSection;
                    while (true) {
                        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                        X_RES = screenSize.width;
                        Y_RES = screenSize.height;
                        screen =robot.createScreenCapture(new Rectangle(screenSize));
                        imgSection=screen.getSubimage(0,0,X_RES,Y_RES);
                        width=imgSection.getWidth();
                        heigh=imgSection.getHeight();
                        r=0;
                        g=0;
                        b=0;
                        loops=0;
                        for(int x=0;x<width;x+=SECT_SKIP){
                            for(int y=0;y<heigh;y+=SECT_SKIP){
                                rgb=imgSection.getRGB(x,y);
                                color=new Color(rgb);
                                r+=color.getRed();
                                g+=color.getGreen();
                                b+=color.getBlue();
                                loops++;
                            }
                        }
                        r=r/loops;
                        g=g/loops;
                        b=b/loops;
                        myoutput.print(r + "\n");
                        myoutput.print(g + "\n");
                        myoutput.print(b + "\n");
                        Thread.sleep(10);
                    }
                }catch (AWTException e){
                    e.printStackTrace();
                }
            }
            skt.close();
            System.out.println("Host is exiting!");
        }catch (IOException | InterruptedException exc){
            exc.printStackTrace();
            System.out.println("Error!");
        }
    }
}