package methodChaining;

public class B {
     public B a() {
    	  System.out.println("a method");
		return new B();
      }
    public B b() {
    	  System.out.println("b method");
		return new B();
      }
    public C c() {
    	  System.out.println("c method");
		return new C();
      }
}
