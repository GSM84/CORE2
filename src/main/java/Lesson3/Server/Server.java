package Lesson3.Server;

import Lesson3.Animal.Cat;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int  PORT = 8189;
    private Socket            socket;
    private ServerSocket      server;
    private ObjectInputStream in;

    public Server(){
        try{
            server                 = null;
            socket                 = null;
            ObjectOutputStream oos = null;

            try{
                server = new ServerSocket(PORT);
                System.out.println("Сервер запущен");

                socket = server.accept();
                System.out.println("Клиент подключился");

                in = new ObjectInputStream(socket.getInputStream());

                Cat cat = null;
                try {
                    cat = (Cat) in.readObject();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

                System.out.println(cat);

                oos = new ObjectOutputStream(new FileOutputStream("test\\cat.dat"));
                oos.writeObject(cat);

            }finally{
                socket.close();
                System.out.println("Сокет закрыт.");
                server.close();
                System.out.println("Сервер закрыт");
                in.close();
                System.out.println("Поток чтения закрыт");
                oos.close();
                System.out.println("Файловый поток закрыт");
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
