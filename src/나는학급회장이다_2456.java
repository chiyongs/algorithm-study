import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 나는학급회장이다_2456 {

	public static class Person {
		int sum;
		int wsum;
		int number;		
	}

	static Person[] p = {new Person(), new Person(), new Person()};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				int v = sc.nextInt();
				p[j].number = j + 1;
				if (v == 1) {
					p[j].wsum += v;
				} else if (v == 2) {
					p[j].wsum += 10 * v;
				} else if (v == 3) {
					p[j].wsum += 100 * v;
				}
				p[j].sum += v;
			}
		}

		Arrays.sort(p, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if(o1.sum == o2.sum) {
					return Integer.compare(o1.wsum, o2.wsum) * -1;
				}
				return Integer.compare(o1.sum, o2.sum) * -1;
			}

		});

		if (p[0].wsum == p[1].wsum) {
			System.out.println("0 " + p[0].sum);
		} else {
			System.out.println(p[0].number + " " + p[0].sum);
		}

	}

}
