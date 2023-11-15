import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.Digester;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.cat.encrypt.EncryptHelper;
import com.cat.encrypt.encryptor.Md5Encryptor;
import com.test.Application;
import com.test.Food;
import com.test.FoodMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@SpringBootTest(classes = Application.class)
public class MapperTest {
    @Autowired
    private FoodMapper foodMapper;
    @Test
    public void test(){
        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food(null,"456"));
        foods.add(new Food(null,"789"));
        EncryptHelper.cancelEncrypt();
        foodMapper.insertBatch(foods);
        foodMapper.insert(new Food(null,"123"));
        System.out.println(foods);
    }
    @Test
    public void get(){
        List<Food> foods = foodMapper.selectList(new LambdaQueryWrapper<Food>().eq(Food::getName, "NDU2").or().eq(Food::getName, "Nzg5"));
        foods.forEach(System.out::println);
    }
    @Test
    public void Md5Test(){
        Digester digester = SecureUtil.md5().setSalt("456sadas121d3a564das".getBytes());
        System.out.println(digester.digestHex("456").equals("b7fcdfdb21751adcc0abcc48b7b4ad90"));
        System.out.println(digester.digestHex("789").equals("a5bd28fb102227d3e2249d1e431f40d3"));
    }
    @Test
    public void testMap(){
        List<LinkedHashMap<String, Object>> foodMap = foodMapper.getFoodMap();
        for (LinkedHashMap<String, Object> stringStringLinkedHashMap : foodMap) {
            for (String s : stringStringLinkedHashMap.keySet()) {
                System.out.println(s+":"+stringStringLinkedHashMap.get(s));
            }
        }
    }
}
