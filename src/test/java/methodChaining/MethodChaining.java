package methodChaining;

import org.testng.annotations.Test;

public class MethodChaining {
    @Test
    public void sample() {
    	B b1=new B();
    	b1.a().b().c();
    }
}
