package server;

import com.google.gson.Gson;
import model.Message;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import repository.Dao;
import utils.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yurii on 22.04.17.
 */
public class Server {

    public static void main(String[] args) {

        Utils utils = new Utils();

        try {
            ServerSocket serverSocket = new ServerSocket(9999);

            while (true) {
                Socket socketClient = serverSocket.accept();

                Message message = readStream(socketClient.getInputStream());

                utils.notifyUsers(message);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Message readStream(InputStream inputStream) {
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


}
