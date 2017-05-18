package app.utils;

import app.model.Message;
import app.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import app.repository.MessageRepository;
import app.repository.UserRepository;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Base64;

import java.util.List;

/**
 * Created by yurii on 23.04.17.
 */
//@Component
public class Utils {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    private static final Logger LOGGER = Logger.getLogger(Utils.class);

    public Utils() {
    }

    public void notifyUsers(Message message) {
        List<User> users = userRepository.findByAddress_City(message.getAddress().getCity());

        for (User user : users) {
            sendSmsUtil(user.getPhone(), message.toString(), userRepository.findOne(message.getUserPhone().getPhone()).getName());
            LOGGER.info("notify user " + user.getPhone());
        }
    }

    public void saveToDb(Message message){
        messageRepository.save(message);
        LOGGER.info("save message to DB " + message.getUserPhone().getPhone());
    }

    public void saveToDb(User user){
        userRepository.save(user);
        LOGGER.info("save user to DB " + user.getPhone());
    }

    private void sendSmsUtil(String phone, String text, String sender) {
        try {
            String name = "login";
            String password = "pass";

            String authString = name + ":" + password;
            String authStringEnc = Base64.getEncoder().encodeToString(authString.getBytes());
//todo guava
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
            LOGGER.info("*** BEGIN ***");
            LOGGER.info(result);
            LOGGER.info("*** END ***");

        } catch (MalformedURLException ex) {
            LOGGER.error(ex.toString());
        } catch (IOException ex) {
            LOGGER.error(ex.toString());
        }
    }

    /*public void addUser(User user) {

        try {

            Gson gson = new Gson();
            URL url;
            URLConnection urlConn;
            DataOutputStream dos;
            DataInputStream dis;

            url = new URL("Localhost:8080/add_user");
            urlConn = url.openConnection();
            urlConn.setDoInput(true);
            urlConn.setDoOutput(true);
            urlConn.setUseCaches(false);
            urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            dos = new DataOutputStream(urlConn.getOutputStream());
            dos.writeBytes(gson.toJson(url));
            dos.flush();
            dos.close();

        } catch (MalformedURLException mue) {
        } catch (IOException ioe) {
        }

    }*/
}

