package cn.furty.dwz.other;

import org.springframework.util.DigestUtils;

public class Utils {
    public static String getDwz(String ywz) {
        String ywzMd5 = DigestUtils.md5DigestAsHex(ywz.getBytes());

        StringBuffer sb = new StringBuffer();
        sb.append(ywzMd5.charAt(0));
        sb.append(ywzMd5.charAt(1));
        sb.append(ywzMd5.charAt(8));
        sb.append(ywzMd5.charAt(9));
        sb.append(ywzMd5.charAt(16));
        sb.append(ywzMd5.charAt(17));
        sb.append(ywzMd5.charAt(24));
        sb.append(ywzMd5.charAt(25));

        return sb.toString();
    }
}
