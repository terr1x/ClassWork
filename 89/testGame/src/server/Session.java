package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class Session extends Thread {
    private final Socket socket;

    static String sign;

    private DataInputStream input;
    private DataOutputStream output;

    public Session(Socket socketForClient) {
        this.socket = socketForClient;
    }

    public void run() {
        try {
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            String str = input.readUTF();

            if (sign != null) {
                if (sign.equals("ножницы") && str.equals("бумага")) {
                    for(int i=0;i<Server.sessions.size();i++) {
                        if(Server.sessions.get(i)==this){
                            Server.sessions.get(i).lose();
                        }else{
                            Server.sessions.get(i).win();
                        }
                    }
                } else if (sign.equals("ножницы") && str.equals("камень")) {
                    for(int i=0;i<Server.sessions.size();i++) {
                        if(Server.sessions.get(i)==this){
                            Server.sessions.get(i).win();
                        }else{
                            Server.sessions.get(i).lose();
                        }
                    }
                } else if (sign.equals("бумага") && str.equals("ножницы")) {
                    for(int i=0;i<Server.sessions.size();i++) {
                        if(Server.sessions.get(i)==this){
                            Server.sessions.get(i).win();
                        }else{
                            Server.sessions.get(i).lose();
                        }
                    }
                } else if (sign.equals("бумага") && str.equals("камень")) {
                    for(int i=0;i<Server.sessions.size();i++) {
                        if(Server.sessions.get(i)==this){
                            Server.sessions.get(i).lose();
                        }else{
                            Server.sessions.get(i).win();
                        }
                    }
                } else if (sign.equals("камень") && str.equals("бумага")) {
                    for(int i=0;i<Server.sessions.size();i++) {
                        if(Server.sessions.get(i)==this){
                            Server.sessions.get(i).win();
                        }else{
                            Server.sessions.get(i).lose();
                        }
                    }
                } else if (sign.equals("камень") && str.equals("ножницы")) {
                    for(int i=0;i<Server.sessions.size();i++) {
                        if(Server.sessions.get(i)==this){
                            Server.sessions.get(i).lose();
                        }else{
                            Server.sessions.get(i).win();
                        }
                    }
                } else if (sign.equals(str)) {
                    for(int i=0;i<Server.sessions.size();i++) {
                        Server.sessions.get(i).tie();
                    }
                }
            }


            sign = str;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void win(){
        send("Вы выиграли");
    }

    public void lose(){
        send("Вы проиграли");
    }

    public void tie(){
        send("Ничья");
    }

    public void send(String text){
        try {
            output.writeUTF(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        disconnect();
    }


    public void disconnect() {
        try {
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}