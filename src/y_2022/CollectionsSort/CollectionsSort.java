package y_2022.CollectionsSort;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import utils.XLog;

public class CollectionsSort {

	public static void main(String[] args) {

		List<Integer> list_01 = Arrays.asList(1, 2, 3, 2, 2, 3, 2, 3, 2, 2, 3, 2, 3, 3, 2, 2, 2, 2, 2, 2, 3, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1);
		List<Integer> list_02 = Arrays.asList(1, 2, 3, 2, 2, 3, 2, 3, 2, 2, 3, 2, 3, 3, 2, 2, 2, 2, 2, 2, 3, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1);

		first(list_01);
		first(list_02);

		// second(list_01);
	}

	private static void second(List<Integer> list) {
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				Collator collator = Collator.getInstance(Locale.CHINA);
				// return collator.compare(o1, o2);
				return collator.getCollationKey(o1 + "").compareTo(collator.getCollationKey(o2 + ""));
			}
		};

		Collections.sort(list, comparator);
		XLog.init().debug(list);
	}

	private static void first(List<Integer> list) {
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 > o2 ? 1 : -1; // error
				// return o1 == o2 ? 0 : (o1 > o2 ? 1 : -1); // right
			}
		});
		XLog.init().debug(list);
	}

}
