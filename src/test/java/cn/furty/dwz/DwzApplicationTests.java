package cn.furty.dwz;

import cn.furty.dwz.mapper.DwzMapper;
import cn.furty.dwz.pojo.Dwz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DwzApplicationTests {

    @Autowired
    DwzMapper dwzMapper;

    @Test
    public void contextLoads() {
        List<Dwz> list = dwzMapper.getAllDwz();
        System.out.println(list);
    }

}
