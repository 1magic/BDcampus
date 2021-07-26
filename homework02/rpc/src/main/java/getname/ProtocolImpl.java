package getname;

import org.apache.hadoop.ipc.ProtocolSignature;

import java.io.IOException;

public class ProtocolImpl implements ProtocolInterface{
    @Override
    public int add(int number1, int number2) {
        System.out.println("num1= " + number1 + "num2" + number2);
        return number1 + number2;
    }
    @Override
    public String findName(int studentID) {
        if(studentID == 5678) {
            return "心心";
        }
        return null;
    }
    @Override
    public long getProtocolVersion(String protocol, long clientVersion) throws IOException {
        return ProtocolInterface.versionID;
    }

    @Override
    public ProtocolSignature getProtocolSignature(String s, long l, int i) throws IOException {
        return null;
    }
}
