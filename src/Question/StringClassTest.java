package Question;

public class StringClassTest {
    public static void main(String... args) {
        String literal = "test";
        String object = new String("test");

        System.out.println(literal == object);
        System.out.println(literal.equals(object));

    }

}
