package thinkingInJava.ch21;

import java.io.IOException;

public class ResponsiveUI extends Thread{

    private static volatile double d=1;
    
    public ResponsiveUI(){
        setDaemon(true);
        start();
    }
    
    public void run(){
        while(true){
            d=(Math.PI+Math.E)/d;
        }
    }
    
    public static void main(String[] args) throws IOException{
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
    
}
