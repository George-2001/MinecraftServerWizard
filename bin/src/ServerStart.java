import java.io.*;

public class ServerStart {

    private File serverFolder = new File("D:/Hexxit2Server/Hexxit-II_Server_v1.0.0");
    private ProcessBuilder pb;
    private Process server;
    private BufferedReader reader;
    private String line;
    private int exitCode;

    public ServerStart() {
        init();
    }

    private void init() {

        if(serverFolder.exists() && serverFolder.isDirectory()) {
            System.out.println("1");
        }else {
            System.out.println("-1");
        }


        try {
            pb = new ProcessBuilder("C:\\Program Files\\Java\\jre1.8.0_311\\bin\\java", "-server", "-Xmx8G", "-XX:+UseG1GC", "-Xms2G", "-Dsun.rmi.dgc.server.gcInterval=2147483646", "-XX:+UnlockExperimentalVMOptions", "-XX:G1NewSizePercent=20", "-XX:G1ReservePercent=20", "-XX:MaxGCPauseMillis=50", "-XX:G1HeapRegionSize=32M", "-Dfml.queryResult=confirm", "-Duser.language=en", "-jar", "forge-1.12.2-14.23.5.2855.jar", "nogui");
            //pb.redirectOutput(serverFile);
            System.out.println(pb.inheritIO());
            server = pb.start();
            reader = new BufferedReader(
                    new InputStreamReader(server.getInputStream()));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            exitCode = server.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

        }catch(IOException | InterruptedException arg0) {
            arg0.printStackTrace();
        }
    }

    public Process getServerProcess() {
        return server;
    }

    public static void main(String[] args) {
        new ServerStart();
    }

}