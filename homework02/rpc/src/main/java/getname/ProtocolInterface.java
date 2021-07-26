package getname;

import org.apache.hadoop.ipc.VersionedProtocol;

public interface ProtocolInterface extends VersionedProtocol {
        long versionID = 1L;
        int add(int number1, int number2);
        String findName(int studentID);

}
