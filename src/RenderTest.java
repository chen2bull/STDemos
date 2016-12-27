import org.stringtemplate.v4.*;
/**
 *
 * Created by chenmj on 2016/12/25.
 */
public class RenderTest {
    public static void main(String[] args) {
        ST hello = new ST("Hello,<name>");
        /* 中文 */
        hello.add("name", "World");
        System.out.println(hello.render());
    }
}
