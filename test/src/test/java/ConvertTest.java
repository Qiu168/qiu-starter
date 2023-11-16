import com.alibaba.fastjson2.JSON;
import com.test.P;
import org.junit.jupiter.api.Test;

public class ConvertTest {

    class p {
        String name;
        String password;
        String email;

        //<editor-fold defaultstate="collapsed" desc="delombok">
        @SuppressWarnings("all")
        public p() {
        }

        @SuppressWarnings("all")
        public String getName() {
            return this.name;
        }

        @SuppressWarnings("all")
        public String getPassword() {
            return this.password;
        }

        @SuppressWarnings("all")
        public String getEmail() {
            return this.email;
        }

        @SuppressWarnings("all")
        public void setName(final String name) {
            this.name = name;
        }

        @SuppressWarnings("all")
        public void setPassword(final String password) {
            this.password = password;
        }

        @SuppressWarnings("all")
        public void setEmail(final String email) {
            this.email = email;
        }

        @Override
        @SuppressWarnings("all")
        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof ConvertTest.p)) return false;
            final ConvertTest.p other = (ConvertTest.p) o;
            if (!other.canEqual((Object) this)) return false;
            final Object this$name = this.getName();
            final Object other$name = other.getName();
            if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
            final Object this$password = this.getPassword();
            final Object other$password = other.getPassword();
            if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
            final Object this$email = this.getEmail();
            final Object other$email = other.getEmail();
            if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
            return true;
        }

        @SuppressWarnings("all")
        protected boolean canEqual(final Object other) {
            return other instanceof ConvertTest.p;
        }

        @Override
        @SuppressWarnings("all")
        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $name = this.getName();
            result = result * PRIME + ($name == null ? 43 : $name.hashCode());
            final Object $password = this.getPassword();
            result = result * PRIME + ($password == null ? 43 : $password.hashCode());
            final Object $email = this.getEmail();
            result = result * PRIME + ($email == null ? 43 : $email.hashCode());
            return result;
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "ConvertTest.p(name=" + this.getName() + ", password=" + this.getPassword() + ", email=" + this.getEmail() + ")";
        }
        //</editor-fold>
    }


    class pp {
        String name;
        String password;
        String username;

        //<editor-fold defaultstate="collapsed" desc="delombok">
        @SuppressWarnings("all")
        public pp() {
        }

        @SuppressWarnings("all")
        public String getName() {
            return this.name;
        }

        @SuppressWarnings("all")
        public String getPassword() {
            return this.password;
        }

        @SuppressWarnings("all")
        public String getUsername() {
            return this.username;
        }

        @SuppressWarnings("all")
        public void setName(final String name) {
            this.name = name;
        }

        @SuppressWarnings("all")
        public void setPassword(final String password) {
            this.password = password;
        }

        @SuppressWarnings("all")
        public void setUsername(final String username) {
            this.username = username;
        }

        @Override
        @SuppressWarnings("all")
        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof ConvertTest.pp)) return false;
            final ConvertTest.pp other = (ConvertTest.pp) o;
            if (!other.canEqual((Object) this)) return false;
            final Object this$name = this.getName();
            final Object other$name = other.getName();
            if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
            final Object this$password = this.getPassword();
            final Object other$password = other.getPassword();
            if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
            final Object this$username = this.getUsername();
            final Object other$username = other.getUsername();
            if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
            return true;
        }

        @SuppressWarnings("all")
        protected boolean canEqual(final Object other) {
            return other instanceof ConvertTest.pp;
        }

        @Override
        @SuppressWarnings("all")
        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $name = this.getName();
            result = result * PRIME + ($name == null ? 43 : $name.hashCode());
            final Object $password = this.getPassword();
            result = result * PRIME + ($password == null ? 43 : $password.hashCode());
            final Object $username = this.getUsername();
            result = result * PRIME + ($username == null ? 43 : $username.hashCode());
            return result;
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "ConvertTest.pp(name=" + this.getName() + ", password=" + this.getPassword() + ", username=" + this.getUsername() + ")";
        }
        //</editor-fold>
    }

//<editor-fold defaultstate="collapsed" desc="delombok">
//</editor-fold>
    @Test
    public void test() {
        p p = new p();
        p.name = "123";
        p.password = "123";
        p.email = "123";
        pp pp = new pp();
        //Convert.convert(p,pp);
        System.out.println(pp);
    }
    @Test
    void testJson(){
        Object parse = JSON.parseObject("{\n" +
                "  \"email\": \"email@email.email\",\n" +
                "  \"name\": \"name\"\n" +
                "}",P.class);
        P parse1 = (P) parse;
        System.out.println(parse1);
    }
}
