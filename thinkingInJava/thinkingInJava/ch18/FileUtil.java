package thinkingInJava.ch18;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

public class FileUtil {

    public static void main(String[] args) throws IOException{
        FileUtil.BufferToText();
    }
    
    public List<String> readString(String fileName) {
        List<String> list = new LinkedList<String>();
        try {
            FileReader fr=new FileReader(fileName);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            while ((line = bf.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return list;
    }
    
    public static void BufferToText() throws IOException{
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        
        //1、无操作
//        FileChannel fc=new FileOutputStream("E:\\a.txt").getChannel();
//        fc.write(ByteBuffer.wrap("我".getBytes()));
//        fc.close();
//        
//        fc=new FileInputStream("E:\\a.txt").getChannel();
//        fc.read(buffer);
//        buffer.flip();
//        System.out.println(buffer.asCharBuffer());
        
        //2、输入后解码
//        FileChannel fc=new FileOutputStream("E:\\a.txt").getChannel();
//        fc.write(ByteBuffer.wrap("我".getBytes()));
//        fc.close();
//        
//        fc=new FileInputStream("E:\\a.txt").getChannel();
//        fc.read(buffer);
//        buffer.flip();
//        System.out.println(Charset.forName(System.getProperty("file.encoding")).decode(buffer));
        
        //3、输出前编码
//        FileChannel fc=new FileOutputStream("E:\\a.txt").getChannel();
//        fc.write(ByteBuffer.wrap("我".getBytes("UTF-16BE")));
//        fc.close();
//        
//        fc=new FileInputStream("E:\\a.txt").getChannel();
//        fc.read(buffer);
//        buffer.flip();
//        System.out.println(buffer.asCharBuffer());
        
        //4、转换成CharBuffer
        FileChannel fc=new FileOutputStream("E:\\a.txt").getChannel();
        buffer.asCharBuffer().put("我");
        fc.write(buffer);
        fc.close();
        
        fc=new FileInputStream("E:\\a.txt").getChannel();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
    }
    
    public static void getData(){
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        
        buffer.asCharBuffer().put("sakdjsakdjsakjd jlkas dlksj as jdlkas");
        char c;
        while((c=buffer.getChar())!=0){
            System.out.print(c+"  ");
        }
        System.out.println();
        buffer.flip();
        
        buffer.asIntBuffer().put(1);
        System.out.println(buffer.get());
        buffer.rewind();
    }
    
    public static void writeLargeFile(){
        int length=0X8FFFFFF;
        try {
            MappedByteBuffer buffer=new RandomAccessFile("E:\\a.txt","rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
            for(int i=0;i<length;i++){
                buffer.put((byte)'X');
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void simpleGzip(){
        try {
            BufferedReader in=new BufferedReader(new FileReader(""));
            BufferedOutputStream out =new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("")));
            int c;
            while((c=in.read())!=-1){
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

