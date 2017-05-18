package app.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by yurii on 22.04.17.
 */

@EnableWebMvc
@ComponentScan(value = "app")
@SpringBootApplication
public class Server extends SpringBootServletInitializer {

    public static void main(String[] args) {

        /*Utils app.utils = new Utils();


        User u1 = new User("Yurii","0997021685");
        Address a1 = new Address("Ukrainian","Kiev","st. Borschagivska","193");


        app.utils.saveToDb(u1);


        try {
            ServerSocket serverSocket = new ServerSocket(9999);

            while (true) {
                Socket socketClient = serverSocket.accept();

                Message message = readStream(socketClient.getInputStream());

                app.utils.saveToDb(message);
                app.utils.notifyUsers(message);

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
