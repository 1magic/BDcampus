import org.apache.hadoop.ipc.RPC;

import javax.security.auth.login.Configuration;
import java.io.IOException;

public class Server {
    public class MyInterfaceImpl implements MyInterface{
        @Override
        public int add(int number1, int number2) {
            System.out.println("num1= " + number1 + "num2" + number2);
            return number1 + number2;
        }

        @Override
        public long getProtocolVersion(String protocol, long clientVersion) throws IOException {
            return MyInterface.versionID;
        }
    }

    public static void main(String[] args){
        RPC.Builder builder = new RPC.Builder(new Configuration());

        builder.setBindAddress("127.0.0.1");
        builder.setPort(12345);
        builder.setProtoccol(MyInterface.class);
        builder.setInstancce(new MyInterfaceImpl());

        try{
            RPC.Server server = builder.build();
            server.start();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
