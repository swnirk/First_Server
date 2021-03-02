import Client.Client;
import Server.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args[0].equals("s")) {
            Server server = new Server();
            server.main(null);
        } else {
            Client client = new Client();
            client.main(null);
            client.close();
        }
    }
}
