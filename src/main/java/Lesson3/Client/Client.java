package Lesson3.Client;

import Lesson3.Animal.Cat;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private Socket              socket;
    private static final String ADDRESS = "localhost";
    private static final int    PORT    = 8189;
    private ObjectOutputStream  out;

    public Client(){
        try{
            socket = null;
            out    = null;
            try{
                socket        = new Socket(ADDRESS, PORT);
                out           = new ObjectOutputStream(socket.getOutputStream());

                Cat cat = new Cat("Мурзик", "белый", 4f, 5);

                System.out.println(cat);

                out.writeObject(cat);

            }finally{
                out.close();
                socket.close();
                System.out.println("Клиент отключился");
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Client();
    }
}
