package getname;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

public class RpcClient {
    public static void main(String[] args) {
        try {
            ProtocolInterface proxy = (ProtocolInterface) RPC.getProxy(ProtocolInterface.class, 1L, new InetSocketAddress("127.0.0.1", 12345), new Configuration());
            int res = proxy.add(1, 2);
            System.out.println("加法结果：" + res);

            String res2 = proxy.findName(5678);
            System.out.println("通过学号查找到姓名："+ res2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
