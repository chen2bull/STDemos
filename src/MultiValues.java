import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 *
 * Created by chenmj on 2016/12/27.
 */
public class MultiValues {
    public static void main(String[] args) {
        test1();
        test2();
    }

    // MultiValues1.stg中的separator可以认为是关键字
    private static void test1() {
        STGroup group = new STGroupFile("./input/MultiValues1.stg");
        ST st = group.getInstanceOf("test");
        st.add("name", "parr");
        st.add("name", "tom");
        st.add("name", "what");
        System.out.println(st.render());

    }

    private static void test2() {
        int[] num =
                new int[] {3,9,20,2,1,4,6,32,5,6,77,888,2,1,6,32,5,6,77,4,9,20,2,1,4,63,9,20,2,1,4,6,32,5,6,77,6,32,5,6,77,
                        3,9,20,2,1,4,6,32,5,6,77,888,1,6,32,5};
        System.out.println("num len:" + num.length);
        // 注意参数2的几个关键字
        // wrap表示达到行宽以后换行(是不包括分隔符的行宽)
        String t0 = ST.format(30, "int <%1>[] = { <%2; anchor, separator=\", \"> };", "a", num);
        System.out.println(t0);

        // anchor表示换行以后, 首字符自动对齐
        String t1 = ST.format(30, "int <%1>[] = { <%2; wrap, separator=\", \"> };", "a", num);
        System.out.println(t1);

        String t2 = ST.format(30, "int <%1>[] = { <%2; wrap, anchor, separator=\", \"> };", "a", num);
        System.out.println(t2);
    }

}
