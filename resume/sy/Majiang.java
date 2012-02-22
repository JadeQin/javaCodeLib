package sy;

import java.util.*;

public class Majiang {
	String[] majiangzi = { "一万", "二万", "三万", "四万", "五万", "六万", "七万", "八万",
			"九万", "一条", "二条", "三条", "四条", "五条", "六条", "七条", "八条", "九条", "一筒",
			"二筒", "三筒", "四筒", "五筒", "六筒", "七筒", "八筒", "九筒", "东风", "南风", "西风",
			"北风", "红中", "白板", "发财" };
	int[] majiangshu = { 11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24,
			25, 26, 27, 28, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39, 100, 101,
			102, 103, 104, 105, 106 };
	TreeMap<Integer, String> map = new TreeMap<Integer, String>();
	ArrayList<Integer> al = new ArrayList<Integer>();

	public static void main(String[] args) {
		final Majiang ma = new Majiang();
		ma.fetch(new ArrayList());
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					ArrayList ar2 = new ArrayList();
					ma.fetch(ar2);
					ma.al.removeAll(ar2);
				}
			}).start();
		}
	}

	public synchronized void fetch(ArrayList al2) {
		for (int i = 0; i < majiangshu.length; i++) {
			al.add(majiangshu[i]);
			al.add(majiangshu[i]);
			al.add(majiangshu[i]);
			al.add(majiangshu[i]);
			map.put(majiangshu[i], majiangzi[i]);
		}

		for (int j = 0; j < 13; j++) {
			int a = new Random().nextInt(136);
			int b = al.get(a);
			al2.add(b);
		}
		al.removeAll(al2);
		Object[] obj = al2.toArray();
		Arrays.sort(obj);
		for (Object ob : obj) {
			System.out.print(map.get((Integer) ob) + " ");
		}
		System.out.println();
	}
}