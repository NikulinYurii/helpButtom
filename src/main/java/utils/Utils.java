package utils;

import model.Message;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.Dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Base64;

import java.util.List;

/**
 * Created by yurii on 23.04.17.
 */
@Component
public class Utils {

    @Autowired
    private Dao dao;

    public void notifyUsers(Message message) {
        List<User> users = dao.findByAddress_City(message.getAddress().getCity());

        for (User user : users) {
            sendSms(user.getPhone(), message.toString(), dao.findOne(message.getPhone()).getName());
        }
    }

    private void sendSms(String phone, String text, String sender) {
        try {
            String name = "login";
            String password = "pass";

            String authString = name + ":" + password;
            String authStringEnc = Base64.getEncoder().encodeToString(authString.getBytes());

            URL url = new URL("http", "api.smsfeedback.ru", 80, "/messages/v2/send/?phone=%2B" + phone + "&text=" + URLEncoder.encode(text, "UTF-8") + "&sender=" + sender);
            URLConnection urlConnection = url.openConnection();
            urlConnection.setRequestProperty("Authorization", authStringEnc);
            InputStream is = urlConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);

            int numCharsRead;
            char[] charArray = new char[1024];
            StringBuffer sb = new StringBuffer();
            while ((numCharsRead = isr.read(charArray)) > 0) {
                sb.append(charArray, 0, numCharsRead);
            }
            String result = sb.toString();

            System.out.println("*** BEGIN ***");
            System.out.println(result);
            System.out.println("*** END ***");

        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}

