package weixin.test;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by Administrator on 2017/5/20.
 */

public class NumberJudge {
    public static boolean isNumber(String str){
        boolean re = true;
        for(int i=0;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))){
                re = false;
                break;
            }
        }
        return re;

    }

}
