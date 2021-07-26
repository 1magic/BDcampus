package getname;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC.Builder;
import org.apache.hadoop.ipc.RPC.Server;



public class RpcServer {
    public static void main(String[] args) {
        Builder builder = new Builder(new Configuration());

        builder.setBindAddress("127.0.0.1");
        builder.setPort(12345);
        builder.setProtocol(ProtocolInterface.class);
        builder.setInstance(new ProtocolImpl());

        try{
            Server server = builder.build();
            System.out.println("Server start~");
            server.start();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
