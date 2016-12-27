import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 *
 * Created by chenmj on 2016/12/26.
 */
public class GroupTest {
    public static void main(String[] args) {
        STGroup group = new STGroupFile("./input/test.stg");
        ST st = group.getInstanceOf("decl");
        st.add("type", "int");
        st.add("name", "x");
        st.add("value", 0);
        String result = st.render(); // yields "int x = 0;"
        System.out.println(result);
    }
}
