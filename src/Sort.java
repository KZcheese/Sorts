import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {
	public static void selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int mindex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[mindex])
					mindex = j;
			}
			int temp = a[mindex];
			a[mindex] = a[i];
			a[i] = temp;
		}
	}

	public static void selectionSort(ArrayList<String> a) {
		for (int i = 0; i < a.size() - 1; i++) {
			int mindex = i;
			for (int j = i + 1; j < a.size(); j++) {
				if (a.get(j).compareTo(a.get(mindex)) < 0)
					mindex = j;
			}
			a.set(mindex, a.set(i, a.get(mindex)));
		}
	}

	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int temp = i;
			while (temp > 0 && a[temp] < a[temp - 1]) {
				int tempval = a[temp];
				a[temp] = a[temp - 1];
				a[temp - 1] = tempval;
				temp--;
			}
		}

	}

	public static void insertionSort(ArrayList<String> a) {
		for (int i = 1; i < a.size(); i++) {
			int temp = i;
			while (temp > 0 && a.get(temp - 1).compareTo(a.get(temp)) > 0) {
				a.set(temp, a.set(temp - 1, a.get(temp)));
				temp--;
			}
		}
	}

	public static String arrayString(int[] a) {
		String out = "[";
		for (int n : a)
			out += n + ", ";
		return out.substring(0, out.length() - 2) + "]";
	}

	public static void main(String[] args) {
		int[] a = { 5, 6, 8, 4, 0, 7, 3, 7, 4 };
		System.out.println(arrayString(a));
		insertionSort(a);
		System.out.println(arrayString(a));
		ArrayList<String> al = new ArrayList<>();
		al.add("word");
		al.add("");
		al.add("woot");
		al.add("banananannananana");
		al.add("apple");

		System.out.println(al);
		insertionSort(al);
		System.out.println(al);
	}
}
