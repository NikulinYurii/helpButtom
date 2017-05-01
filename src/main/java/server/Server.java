package server;

import com.google.gson.Gson;
import model.Address;
import model.Message;
import model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import utils.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by yurii on 22.04.17.
 */

//todo spring web socket
@SpringBootApplication
public class Server {

    public static void main(String[] args) {

        /*Utils utils = new Utils();


        User u1 = new User("Yurii","0997021685");
        Address a1 = new Address("Ukrainian","Kiev","st. Borschagivska","193");


        utils.saveToDb(u1);


        try {
            ServerSocket serverSocket = new ServerSocket(9999);

            while (true) {
                Socket socketClient = serverSocket.accept();

                Message message = readStream(socketClient.getInputStream());

                utils.saveToDb(message);
                utils.notifyUsers(message);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }*/

        SpringApplication.run(Server.class, args);
    }

    /*private static Message readStream(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String mess = "";
        Message message;

        Gson gson = new Gson();

        while (scanner.hasNextLine()) {
            mess += scanner.nextLine();
        }


        return message = gson.fromJson(mess, Message.class);
    }
*/
}
