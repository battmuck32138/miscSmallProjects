
/*
Mathew Buck
Java II Lab B
 */
package reflectiondriver;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionDriver {

    public static void main(String[] args) {

        try {
            //Enter the package name in all lowercase then add the class 
            // to the argument.  "packagename.ClassName"
            Class<?> b1 = Class.forName("reflectiondriver.BaseInterface");
            Class<?> c1 = Class.forName("reflectiondriver.ConcreteClass");
            System.out.print("Get canonical name of the class: ");
            System.out.println(c1.getCanonicalName());
            System.out.println();

            System.out.print("Get super classes: ");
            System.out.println(c1.getSuperclass());
            System.out.println();

            //Nested classes use "$" as the separator.
            //forName() generates a varible of type class. 
            Class<?> nested1 = Class.forName("reflectiondriver.ConcreteClass"
                    + "$ConcreteClassPublicClass");
            System.out.println("Get declared members: ");
            System.out.println(nested1.getCanonicalName());
            //At index 5
            Class<?> nested2 = c1.getDeclaredClasses()[5];
            System.out.println(nested2.getCanonicalName());
            Class<?> nested3 = c1.getDeclaredClasses()[4];
            System.out.println(nested3.getCanonicalName());
            Class<?> nested4 = c1.getDeclaredClasses()[3];
            System.out.println(nested4.getCanonicalName());
            Class<?> nested5 = c1.getDeclaredClasses()[2];
            System.out.println(nested5.getCanonicalName());
            Class<?> nested6 = c1.getDeclaredClasses()[1];
            System.out.println(nested6.getCanonicalName());
            System.out.println();

            System.out.println("Get the class modifiers:");
            //Get an array of fields.
            Field fieldlist[] = c1.getDeclaredFields();
            for (int i = 0; i < fieldlist.length; i++) {
                Field fld = fieldlist[i];
                System.out.print("Name of field: " + fld.getName()
                        + ", Type: " + fld.getType() + ", modifier: ");
                //store modifers as an int.
                int mod = fld.getModifiers();
                //Convert to String to dispaly.
                System.out.println(Modifier.toString(mod));
            }
            System.out.println();

            System.out.print("Get interfaces: ");
            Class<?> interFace = c1.getInterfaces()[0];
            System.out.println(interFace);
            System.out.println();

            System.out.println("Get public Methods:");
            Method m[] = c1.getMethods();
            for (int i = 0; i < m.length; i++) {
                System.out.println(m[i].toString());
            }
            System.out.println();

            System.out.println("Get public constructors:");
            Constructor cList[] = c1.getConstructors();
            for (int i = 0; i < cList.length; i++) {
                Constructor ct = cList[i];
                System.out.println(ct.getName());
            }
            System.out.println();

            System.out.println("Get public fields:");
            Field fList[] = c1.getFields();
            for (int i = 0; i < fList.length; i++) {
                Field f = fList[i];
                System.out.println(f.getName());
            }
            System.out.println();

            System.out.println("Get annotations:");
            Annotation annos[] = c1.getAnnotations();
            System.out.println("There is " + annos.length
                    + " class annotation.");
            for (int i = 0; i < annos.length; i++) {
                Annotation a = annos[i];
                System.out.println(a.toString());
            }
            System.out.println();

            System.out.println("Get Constructors and parameter types:");
            //create an array of all the construtors.
            Constructor c[] = c1.getConstructors();
            for (int i = 0; i < c.length; i++) {
                Constructor con = c[i];
                System.out.print(con);
                //Get the parametes for the constructors. 
                Class partypes[] = con.getParameterTypes();
                System.out.println(", Parameter type: " + partypes[i]);
                //Feed the constructor an argument and creat a new instance.
                int number = 138;
                Object o = con.newInstance(number);
                System.out.println("New instance of: " + o.toString());
            }
            System.out.println();

            System.out.println("Get public fields and set them:");
            //Get the fields of the class. 
            Field fArr[] = c1.getFields();
            int newNumber = 1976;
            //Create an instance (could have used the above code to do so).
            ConcreteClass newConc = new ConcreteClass(0);
            Field f = fList[0];
            System.out.print(f.getName() + " = ");
            f.setAccessible(true);
            f.set(newConc, newNumber);
            System.out.println(newConc);
            System.out.println();

            System.out.println("Get public methods and invoke them:");
            Method m1[] = c1.getDeclaredMethods();
            ConcreteClass instanceOfConc = new ConcreteClass(0);
            int num = 138;

            //Invoke all methods with no arguments. 
            for (int i = 0; i < m1.length; i++) {
                Method meth = m[i];
                Class partypes[] = meth.getParameterTypes();
                if (partypes.length == 0) {
                    System.out.print(meth.toString());
                    System.out.println(", No paramaters.");
                    meth.invoke(instanceOfConc);
                }
            }

            //invoke methods with an int argument
            Method meth1 = c1.getDeclaredMethod("method5", int.class);
            System.out.println(meth1);
            meth1.invoke(instanceOfConc, num);

            //invoke methods with a String argument.
            Method meth2 = c1.getDeclaredMethod("method2", String.class);
            System.out.println(meth2);
            meth2.invoke(instanceOfConc, "string param");

            Method method = c1.getDeclaredMethod("method", String.class);
            System.out.println(method);
            method.invoke(instanceOfConc, "Method should print this string.");
            System.out.println();

            System.out.println("Get the public interface members inherited"
                    + " from super classes:");
            Field[] f1 = b1.getDeclaredFields();
            for (int i = 0; i < f1.length; i++) {
                System.out.println(f1[i].toString());
            }
            Method[] methArr = b1.getDeclaredMethods();
            for (int i = 0; i < methArr.length; i++) {
                System.out.println(methArr[i].toString());
            }
            System.out.println();

            System.out.println("Get public class and interface members "
                    + "declared by the class:");
            Field[] f2 = c1.getDeclaredFields();
            for (int i = 0; i < f2.length; i++) {
                System.out.println(f2[i].toString());
            }
            Method[] meth = b1.getDeclaredMethods();
            for (int i = 0; i < meth.length; i++) {
                System.out.println(meth[i].toString());
            }
            System.out.println();

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        //end main    
    }

}

/*
OUTPUT

run:
Get canonical name of the class: reflectiondriver.ConcreteClass

Get super classes: class reflectiondriver.BaseClass

Get declared members: 
reflectiondriver.ConcreteClass.ConcreteClassPublicClass
reflectiondriver.ConcreteClass.ConcreteClassPrivateClass
reflectiondriver.ConcreteClass.ConcreteClassProtectedClass
reflectiondriver.ConcreteClass.ConcreteClassDefaultClass
reflectiondriver.ConcreteClass.ConcreteClassDefaultEnum
reflectiondriver.ConcreteClass.ConcreteClassPublicEnum

Get the class modifiers:
Name of field: publicInt, Type: int, modifier: public
Name of field: privateString, Type: class java.lang.String, modifier: private
Name of field: protectedBoolean, Type: boolean, modifier: protected
Name of field: defaultObject, Type: class java.lang.Object, modifier: 

Get interfaces: interface reflectiondriver.BaseInterface

Get public Methods:
public java.lang.String reflectiondriver.ConcreteClass.toString()
public int reflectiondriver.ConcreteClass.method(java.lang.String)
public void reflectiondriver.ConcreteClass.method()
public int reflectiondriver.ConcreteClass.method5(int)
public int reflectiondriver.ConcreteClass.method2(java.lang.String)
public void reflectiondriver.ConcreteClass.method1()
public int reflectiondriver.ConcreteClass.method4()
public static int reflectiondriver.BaseClass.method5()
public final void java.lang.Object.wait() throws java.lang.InterruptedException
public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
public boolean java.lang.Object.equals(java.lang.Object)
public native int java.lang.Object.hashCode()
public final native java.lang.Class java.lang.Object.getClass()
public final native void java.lang.Object.notify()
public final native void java.lang.Object.notifyAll()

Get public constructors:
reflectiondriver.ConcreteClass

Get public fields:
publicInt
iterfaceInt
basicInt

Get annotations:
There is 1 class annotation.
@java.lang.Deprecated()

Get Constructors and parameter types:
public reflectiondriver.ConcreteClass(int), Parameter type: int
New instance of: ConcreteClass, publicInt = 138

Get public fields and set them:
publicInt = ConcreteClass, publicInt = 1976

Get public methods and invoke them:
public java.lang.String reflectiondriver.ConcreteClass.toString(), No paramaters.
public void reflectiondriver.ConcreteClass.method(), No paramaters.
method() was called.
public void reflectiondriver.ConcreteClass.method1(), No paramaters.
Method1 impl. 
public int reflectiondriver.ConcreteClass.method4(), No paramaters.
Method4 overridden.
public int reflectiondriver.ConcreteClass.method5(int)
Method5 overridden.
public int reflectiondriver.ConcreteClass.method2(java.lang.String)
Method2 impl.
public int reflectiondriver.ConcreteClass.method(java.lang.String)
Method should print this string.

Get the public interface members inherited from super classes:
public static final int reflectiondriver.BaseInterface.iterfaceInt
public abstract void reflectiondriver.BaseInterface.method()
public abstract int reflectiondriver.BaseInterface.method(java.lang.String)

Get public class and interface members declared by the class:
public int reflectiondriver.ConcreteClass.publicInt
private java.lang.String reflectiondriver.ConcreteClass.privateString
protected boolean reflectiondriver.ConcreteClass.protectedBoolean
java.lang.Object reflectiondriver.ConcreteClass.defaultObject
public abstract void reflectiondriver.BaseInterface.method()
public abstract int reflectiondriver.BaseInterface.method(java.lang.String)

BUILD SUCCESSFUL (total time: 0 seconds)


*/