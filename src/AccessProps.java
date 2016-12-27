import org.stringtemplate.v4.ST;

/**
 * StringTemplate looks for methods getP(), isP(), hasP() first.
 * Also note that the template uses $...$ delimiters
 * Created by chenmj on 2016/12/26.
 */
public class AccessProps {
    public static class User {
        public int id; // template can directly access via u.id
        private String name; // template can't access this
        @SuppressWarnings("all")
        public User(int id, String name) { this.id = id; this.name = name; }
        public boolean isManager() { return true; } // u.manager
        public boolean hasParkingSpot() { return true; } // u.parkingSpot
        public String getName() { return name; } // u.name
        public String toString() { return id+":" + name; } // u
    }

    public static void main(String[] args) {
        ST st = new ST("<b>$u.id$</b>: $u.name$, manager:$u.manager$", '$', '$');
        st.add("u", new User(999, "parrt"));
        String result = st.render(); // "<b>999</b>: parrt"
        System.out.println(result);
    }
}
