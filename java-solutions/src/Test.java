import java.util.BitSet;

public class Test {

	public static void main(String[] args) {
		BitSet x = BitSet.valueOf(new long[] {5});
		System.out.println(x);
		x.flip(0,x.length());
		System.out.println(x);
		System.out.println(x.length());
		System.out.println(x.get(5));
		System.out.println(x);
		System.out.println(x.length());
	}

}
