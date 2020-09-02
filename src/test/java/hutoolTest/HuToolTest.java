package hutoolTest;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;
import cn.hutool.core.date.ChineseDate;

import java.util.Arrays;
import java.util.Date;

public class HuToolTest {

    @Test
    public void ChineseDateTest() {

        ChineseDate date = new ChineseDate(new Date());

        System.out.println(date.toString());
        System.out.println(date.toStringNormal());
    }

    @Test
    public void DateUtilTest(){
        String date = DateUtil.now();

        System.out.println(date);
    }
    @Test
    public void NumberUtilTest(){

        int[] range = NumberUtil.range(4);

        System.out.println(Arrays.toString(range));

    }

    @Test
    public void httpUtilTest(){

        String result = HttpUtil.get("https://www.baidu.com");

        System.out.println(result);


    }

    static class Ab{
        int id;
        String name;

        public Ab(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    @Test
    public void jsonUtilTest(){

        Ab a = new Ab(23, "sdf");

        System.out.println(JSONUtil.parse(a));
    }

}
