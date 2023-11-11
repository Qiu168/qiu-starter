import lombok.Data;
import lombok.ToString;
import org.junit.Test;

public class ConvertTest {
    @Data
    class p{
        String name;
        String password;
        String email;
    }
    @Data
    @ToString
    class pp{
        String name;
        String password;
        String username;
    }
    @Test
    public void test(){
        p p=new p();
        p.name="123";
        p.password="123";
        p.email="123";
        pp pp=new pp();
        //Convert.convert(p,pp);
        System.out.println(pp);
    }
}
