import com.alibaba.fastjson2.annotation.JSONField;
import com.cat.json.JSONIgnore;
import com.cat.json.sensitive.Desensitize;
import com.cat.json.sensitive.SensitiveStrategy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.P;
import org.junit.jupiter.api.Test;


import java.lang.reflect.Field;

public class EnumInterfaceTest {
    @Test
    public void test(){
        Enum instance = Enum.valueOf(SensitiveStrategy.class, "EMAIL");
        System.out.println(instance);
        Desensitize instance1 = (Desensitize) instance;
        String email="156123456@qq.com";
        String apply = instance1.desensitizer().apply(email);
        System.out.println(apply);
    }
    @Test
    public void annoTest() throws NoSuchFieldException {
        Field password = P.class.getDeclaredField("password");
        JSONIgnore annotation = password.getAnnotation(JSONIgnore.class);
        JsonIgnore jsonIgnore = annotation.getClass().getAnnotation(JsonIgnore.class);
        JSONField jsonField = annotation.getClass().getAnnotation(JSONField.class);
        System.out.println(annotation==null);
        System.out.println(jsonIgnore==null);
        System.out.println(jsonField==null);
    }

}
