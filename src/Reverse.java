import java.util.function.Function;

/**
 * https://aphyr.com/posts/340-acing-the-technical-interview
 */
public class Reverse {
    interface List<T> extends Function<Boolean, Object> {
        default T head() {
            return (T) apply(true);
        }

        default List<T> tail() {
            return (List<T>) apply(false);
        }

        default T nth(int idx) {
            return idx == 0 ? head() : tail() == null ? null : tail().nth(idx - 1);
        }

        default String print() {
            return "(" + printLoop(this);
        }

        static <T> String printLoop(List<T> list) {
            return list.head().toString() + (list.tail() == null ? ")" : " " + printLoop(list.tail()));
        }

        default List<T> reverse() {
            return reverseLoop(null, this);
        }

        static <T> List<T> reverseLoop(List<T> reversed, List<T> remainder) {
            return remainder == null ? reversed : reverseLoop(cons(remainder.head(), reversed), remainder.tail());
        }

        static <T> List<T> cons(T head, List<T> tail) {
            return (whichOne) -> whichOne ? head : tail;
        }
    }

    public static void main(String[] args) {
        List<Integer> x = List.cons(1, List.cons(2, List.cons(3, null)));
        System.out.println(x);
        System.out.println(x.head());
        System.out.println(x.tail());
        System.out.println(x.tail().head());
        System.out.println(x.tail().tail());
        System.out.println(x.nth(0));
        System.out.println(x.nth(1));
        System.out.println(x.nth(2));
        System.out.println(x.nth(3));

        System.out.println(x.print());
        System.out.println(x.reverse().print());
    }
}
