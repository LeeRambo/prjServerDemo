package com.itlaobing.main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author MACHENIE
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("正在准备接受数据,请稍后......");
        try {

            DatagramSocket reciveSocket = new DatagramSocket(8081);

            byte[] b = new byte[1024];
            DatagramPacket dprecivePacket = new DatagramPacket(b, b.length);

            //开始接收数据
            reciveSocket.receive(dprecivePacket);


            b = dprecivePacket.getData();
            String s = new String(b);
            System.out.println("客户端发送的消息为:" + s);
            reciveSocket.close();
            System.out.println("接收完成......");



            //创建发送的报文套接字对象
            DatagramSocket dataSendSocket = new DatagramSocket();

            Scanner input = new Scanner(System.in);
            System.out.println("请输入要发送给客户端的消息:");
            String msg = input.next();

            //创建发送的报文包对象DatagramPacket对象
            DatagramPacket senddataPacket = new DatagramPacket(msg.getBytes(), msg.length(), InetAddress.getByName("172.16.0.5"), 8099);
            //使用dataSendSocket发送数据报
            dataSendSocket.send(senddataPacket);
            dataSendSocket.close();
            System.out.println("发送完成......");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
