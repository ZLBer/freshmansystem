package weixin.msg.Resp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文本消息
 * Autohr Engineer.Jsp
 * Date 2014.10.08*/
public class TextMessage extends BaseMessage{
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public static void main(String[] args) {

    }
}
