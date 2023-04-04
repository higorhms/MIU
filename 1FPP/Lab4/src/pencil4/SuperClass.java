package pencil4;

public class SuperClass {
    SuperClass() {
        System.out.println("In SuperClass");
        new BadInherit();
    }
}
