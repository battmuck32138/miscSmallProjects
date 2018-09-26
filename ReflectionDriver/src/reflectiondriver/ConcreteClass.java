
/*
Mathew Buck
Java II Lab B
 */
package reflectiondriver;


@Deprecated
public class ConcreteClass extends BaseClass implements BaseInterface {

    public int publicInt;
    private String privateString = "private string";
    protected boolean protectedBoolean;
    Object defaultObject;

    public ConcreteClass(int i) {
        this.publicInt = i;
    }
    
    public String toString(){
        return "ConcreteClass, publicInt = " + publicInt;
    }

    public void method1() {
        System.out.println("Method1 impl. ");
    }

    public int method2(String str) {
        System.out.println("Method2 impl.");
        return 0;
    }

    @Override
    public int method4() {
        System.out.println("Method4 overridden.");
        return 0;
    }

    public int method5(int i) {
        System.out.println("Method5 overridden.");
        return 0;
    }
    
    @Override
    public void method(){
        System.out.println("method() was called.");
    }
    
    @Override
    public int method(String str){
        System.out.println(str);
        return 0;
    }

    //------------------------------------------------------------------------
    //inner classes
    //------------------------------------------------------------------------
    public class ConcreteClassPublicClass {

    }

    private class ConcreteClassPrivateClass {

    }

    protected class ConcreteClassProtectedClass {

    }

    class ConcreteClassDefaultClass {

    }

    //------------------------------------------------------------------------
    //member enum
    //------------------------------------------------------------------------
    enum ConcreteClassDefaultEnum {

    }

    public enum ConcreteClassPublicEnum {

    }

    //------------------------------------------------------------------------
    //member interface
    //------------------------------------------------------------------------
    public interface ConcreteClassPublicInterface {

    }
}


