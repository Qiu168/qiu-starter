import com.test.Application;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@SpringBootTest(classes = Application.class)
@Component
public class RedisTest {
    @Autowired
    RedisTest redisTest;
    @SneakyThrows
    @Cacheable(/*cacheNames = {"123","456"},*/key = "#id",cacheManager = "redisCacheManager")
    public String RedisCache(String id){
        Thread.sleep(1000);
        System.out.println("begin");
        return "789456123";
    }
    @Test
    public void test(){
        redisTest.RedisCache("abc123");
        redisTest.RedisCache("abc123");
        redisTest.RedisCache("abc123");
    }
}
