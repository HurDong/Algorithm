
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BigInteger n = sc.nextBigInteger();
		BigInteger m = sc.nextBigInteger();
		BigInteger div = n.divide(m);
		BigInteger rem = n.remainder(m);

		System.out.println(div + "\n" + rem);

	}
}
