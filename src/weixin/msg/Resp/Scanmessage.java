package weixin.msg.Resp;

/**
 * Created by ThinkPad on 2017/5/20 0020.
 */
public class Scanmessage extends BaseMessage{

    private String ScanResult;
    public String getScanesult() {
        return ScanResult;
    }

    public void setScanesult(String scanResult) {
        ScanResult = scanResult;
    }
}
