package googCodeJam.qualificationRound2010.themePark;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ThemePark {

	public static final int ALL_LQ_K = -2;
	public static final int NO_LOOP = -1;

	public static void main(String[] args) {
		ThemePark tp = new ThemePark();
		String fileName = tp.getClass().getResource(".").getPath()
				+ "C-small-practice.in";
		tp.readASCIIFileByLine(fileName);
	}

	private void readASCIIFileByLine(String fileName) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(new File(
					fileName)));
			String line = bf.readLine();
			int i = 1;
			long start = System.currentTimeMillis();
			while ((line = bf.readLine()) != null) {
				String[] str = line.split(" ");
				int r = Integer.parseInt(str[0]);
				int k = Integer.parseInt(str[1]);
				int groupSize = Integer.parseInt(str[2]);
				int[] groups = new int[groupSize];

				String g = bf.readLine();
				String[] gs = g.split(" ");
				for (int j = 0; j < gs.length; j++) {
					groups[j] = Integer.parseInt(gs[j]);
				}

				long moneyCount = process2(r, k, groups);
				System.out.println("Case #" + i + ": " + moneyCount);
				i++;
			}
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 小队人数依次相加，直到小于K的最大数
	 * 
	 * @param r
	 *            循环次数
	 * @param k
	 *            座位数
	 * @param groups
	 *            队伍情况
	 * @return
	 */
	private long process(int r, int k, int[] groups) {
		long count = 0;
		int m = 0;

		for (int i = 0; i < groups.length; i++) {
			count += groups[i];
		}
		if (count <= k) {
			count *= r;
			return count;
		} else {
			count = 0;
		}

		for (int i = 0; i < r; i++) {
			long sum = 0;
			for (int j = m; j < groups.length; j++) {
				sum += groups[j];
				if (sum > k) {
					sum -= groups[j];
					m = j;

					break;
				}
				if (j == groups.length - 1) {
					j = -1;
				}
				if (j == m - 1) {
					break;
				}
			}
			count += sum;
		}
		return count;
	}

	/**
	 * 在一个封闭的集合里，给定一个上限，在足够大的循环次数中，必然会复现,讲groups看做一个首尾相连的数组，
	 * groupIndex作为指针指向每次循环的起始位置，count作为总收益，mapIndex标记复现的groupIndex
	 * 
	 * @param r
	 * @param k
	 * @param groups
	 * @return
	 */
	private long process2(int r, int k, int[] groups) {
		MyMap map = new MyMap();
		long count = 0;
		int groupIndex = 0;
		int mapIndex = NO_LOOP;

		for (int i = 0; i < r; i++) {
			long sum = 0;
			for (int j = groupIndex; j < groups.length; j++) {
				sum += groups[j];

				if (sum > k) {
					sum -= groups[j];
					if (map.isContainsKey(groupIndex)) {
						mapIndex = map.getIndex(groupIndex);
					} else {
						map.add(groupIndex, sum);
					}
					groupIndex = j;
					break;
				}

				if (groupIndex == 0 && j == groups.length - 1) {
					mapIndex = ALL_LQ_K;
					map.add(0, sum);
					break;
				}

				if (j == groups.length - 1) {
					j = -1;
				}
			}

			if (mapIndex == ALL_LQ_K) {
				count = map.get(0) * r;
				break;
			}

			if (mapIndex > -1) {
				count = jisuan(r, mapIndex, map);
				break;
			}
		}

		if (mapIndex == NO_LOOP) {
			for (int i = 0; i < map.size(); i++) {
				count += map.get(i);
			}
		}

		return count;
	}

	private long jisuan(int r, int mapIndex, MyMap map) {
		long count = 0;
		int size = map.size();
		int times = (r - mapIndex) / (size - mapIndex);
		int other = (r - mapIndex) % (size - mapIndex);
		long block = 0;

		for (int n = 0; n < mapIndex; n++) {
			count += map.get(n);
		}

		for (int n = mapIndex; n < size; n++) {
			block += map.get(n);
		}
		count += times * block;

		for (int n = 0; n < other; n++) {
			count += map.get(n + mapIndex);
		}
		return count;
	}

}

class MyMap {
	private List<Integer> keys = new ArrayList<Integer>();
	private List<Long> values = new ArrayList<Long>();

	public void add(int key, long value) {
		keys.add(key);
		values.add(value);
	}

	public boolean isContainsKey(int key) {
		return keys.contains(key);
	}

	public int size() {
		return keys.size();
	}

	public long get(int index) {
		return values.get(index);
	}

	public int getIndex(int key) {
		return keys.indexOf(key);
	}

	public void replace(int key, long value) {
		int index = keys.indexOf(key);
		long v = values.get(index);
		values.remove(v);
		values.add(index, value);
	}
}
