package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class IOUtil {

    public static void main(String[] args) throws IOException{
//        writeFile("a.txt", "我想做一个梦给你", true);
        System.out.println(readFile("a.txt"));
    }
    
    public static String readFile(String fileName){
        StringBuffer content=new StringBuffer();
        try {
            ByteBuffer buffer=ByteBuffer.allocate(1);
            CharBuffer cb=buffer.asCharBuffer();
            FileChannel channel=new FileInputStream(fileName).getChannel();
            while(-1!=channel.read(buffer)){
                buffer.flip();
                content.append(Charset.forName(System.getProperty("file.encoding")).decode(buffer).toString());
                buffer.clear();
            }
//            FileInputStream in=new FileInputStream(fileName);
//            byte[] b=new byte[in.available()];
//            in.read(b);
//            content=new String(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
    
    public static void writeFile(String fileName,String content,boolean isAppend){
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(fileName,isAppend),true);
            pw.print(content);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
