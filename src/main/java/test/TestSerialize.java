package test;

import com.simple.demo.entity.MsgEntity;

import java.io.*;
import java.util.UUID;

/**
 * @Title:test.TestSerialize
 * @Auther: Charles Rao
 * @Date: 2020/05/18/20:25
 * @Description:
 */
public class TestSerialize {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "d:\\testMsg1";
        String msg = "测试序列化";
//        serialize(fileName,msg);
        System.out.println(deserialize(fileName));
    }

    private static void serialize(String fileName,String msg) throws IOException {
        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
            MsgEntity msgEntity = new MsgEntity(UUID.randomUUID().toString(), msg);
            msgEntity.setPwd("mypwd");
            os.writeObject(msgEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            os.close();
        }
    }

    private static String deserialize(String fileName) throws IOException, ClassNotFoundException {

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
        MsgEntity msgEntity = (MsgEntity)inputStream.readObject();
        System.out.println("transient pwd:"+msgEntity.getPwd());
        return msgEntity.getContent();
    }

}
