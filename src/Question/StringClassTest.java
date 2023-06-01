package Question;

public class StringClassTest {
    public static void main(String... args) {
        String literal = "loper";
        String object = new String("loper");

        System.out.println(literal == object);
        System.out.println(literal.equals(object));
    }


}
