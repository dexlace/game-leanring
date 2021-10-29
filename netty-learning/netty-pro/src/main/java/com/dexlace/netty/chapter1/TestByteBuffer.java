package com.dexlace.netty.chapter1;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: dexlace
 * @Description: ByteBuffer和FileChannel的使用
 * 注意FileChannel对文件（注意这里定义的都是对文件的概念）的读写
 * 在程序角度理解，（不要从文件角度理解），对文件读就是对程序内存的写
 * 所以read就是读取文件道Buffer中，即Channel到Buffer
 * 在程序角度的写，就是对程序内存的读，所以
 * 所以write操作就是Buffer到Channel
 *
 * 案例一：写文件，文件不存在需要创建
 * 案例二：文件读取
 * 案例三：文件copy
 *
 * @Date: 2021/10/23
 */
public class TestByteBuffer {
    public static void main(String[] args) {



    }

    /**
     * 案例一  写文件
     */
    public  static  void write(){

        String content="hello nio";

        try  {

            FileOutputStream fileOutputStream = new FileOutputStream("D:\\1.txt");

            // 1. 获取FileChannel即一个FileOutputStream就能获取
            FileChannel channel = fileOutputStream.getChannel();

            // 2. 创建缓冲区
            ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

            // 将str放入byteBuffer
            byteBuffer.put(content.getBytes());

            // 3.反转缓冲区，因为将str放入buffer中的过程对缓冲区来说相当于写
            // 现在要写入Channel，对于缓冲区来说相当于读
            // 所以需要反转
            byteBuffer.flip();

            // 4. 写入channel
            channel.write(byteBuffer);

            fileOutputStream.close();

        }catch (IOException e){
            e.printStackTrace();

        }

    }


    /**
     * 案例二：读文件
     */
    public static void read(){

        try{
            FileInputStream fileInputStream = new FileInputStream("D:\\1.txt");
            // 1.获取一个channel
            FileChannel channel = fileInputStream.getChannel();

            // 2.创建一个缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);

            // 3. channel读入到Buffer 仅此而已
            channel.read(byteBuffer);

            System.out.println(new String (byteBuffer.array()));

            fileInputStream.close();


        }catch(Exception e){

        }



    }


    public void copy() throws Exception{

        FileInputStream fileInputStream=new FileInputStream("D:\\3.txt");
        FileChannel fileChannel=fileInputStream.getChannel();

        FileOutputStream fileOutputStream=new FileOutputStream("D:\\4.txt");
        FileChannel outFileChannel=fileOutputStream.getChannel();

        ByteBuffer byteBuffer=ByteBuffer.allocate(512);

        // 循环读取
        while (true){
            // 0.注意 读的过程中需要清空buffer
            byteBuffer.clear();

            // 1.读取
            int read=fileChannel.read(byteBuffer);
            // 表示读完了
            if(read==-1){
                break;
            }

            // 2.反转buffer的方向
            byteBuffer.flip();

            // 3.写
            outFileChannel.write(byteBuffer);

        }

        // 4. 关闭流
        fileInputStream.close();
        fileOutputStream.close();
    }


}
