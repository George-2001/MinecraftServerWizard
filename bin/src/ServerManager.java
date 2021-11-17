import java.io.*;
import java.lang.*;

public class ServerManager {

    private ServerStart serverProcess;
    private Process server;
    private InputStream is;
    private OutputStream os;
    private String str = "say hello";
public ServerManager(){
    serverManager();
}

    public void serverManager(){

        serverProcess = new ServerStart();
        server = serverProcess.getServerProcess();
        is = server.getInputStream();
        os = server.getOutputStream();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(os));
        try {
            out.write(str + "\n");
            out.write("\n");
            out.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void main(String[] Args){
        new ServerManager();
    }



}
