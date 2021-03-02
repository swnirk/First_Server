package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;
    private BufferedWriter out;

    private void connectSocket(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        System.out.println("Connected");
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
    }

    public void getPrintData() throws IOException, InterruptedException {
        String data = in.readLine();
       /* while (!data.isEmpty()) {
            data = in.readLine();
        }*/
        System.out.println(data);
        out.flush();
    }

    public void close() throws IOException {

        clientSocket.close();
        in.close();
        out.close();
        serverSocket.close();
    }

    public void main(String[] args) throws IOException, InterruptedException {
        connectSocket(1111);
        getPrintData();
        close();
    }
}

