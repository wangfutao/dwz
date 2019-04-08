package cn.furty.dwz.other;

import java.util.ArrayList;
import java.util.List;

public class StaticData {
    public static List<String> dwzForbiddenList;
    static {
        dwzForbiddenList = new ArrayList<>();
        dwzForbiddenList.add("dwz");
    }
}
