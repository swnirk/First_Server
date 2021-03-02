package Client;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket clientSocket;
    private BufferedReader in;
    private BufferedWriter out;

    private void connect(int port) throws IOException {
        clientSocket = new Socket("127.0.0.1", port);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
    }
    
    private void send(String msg) throws IOException {
        out.write(msg + "\n");
    }
    
    public void main(String[] arg) throws IOException {
        connect(1111);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
//        System.out.println(str);
        send(str);
        out.flush();
    }

    public void close() throws IOException {
        clientSocket.close();
        in.close();
        out.close();
    }

}
