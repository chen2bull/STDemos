import org.stringtemplate.v4.ST;

/**
 * Creating one-off data aggregates is a pain, so we have aggregate attributes.
 * For example a.{p1,p2,p3} describes an attribute called a that has three properties p1, p2, p3.
 * 这样的话,就不用额外定义一个有这些属性的类了.
 * Created by chenmj on 2016/12/26.
 */
public class AggregateProps {
    public static void main(String[] args) {
        ST st = new ST("<items:{it|<it.id>: <it.lastName>, <it.firstName>\n}>");
        st.addAggr("items.{ firstName ,lastName, id }", "Ter", "Parr", 99);
        st.addAggr("items.{firstName, lastName ,id}", "Tom", "Burns", 34);
        String reslut = st.render();
        System.out.println(reslut);
    }
}
