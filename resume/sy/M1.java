package sy;

import java.util.Random;

public class M1 {
	static String[] wangpai = { "春", "夏", "秋", "冬", "梅", "兰", "竹", "菊" };
	static String[] s = { "一万", "二万", "三万", "四万", "五万", "六万", "七万", "八万", "九万",
			"一条", "二条", "三条", "四条", "五条", "六条", "七条", "八条", "九条", "一筒", "二筒",
			"三筒", "四筒", "五筒", "六筒", "七筒", "八筒", "九筒", "东", "南", "西", "北", "中",
			"发", "白" };
	static String[] majiang = new String[144];

	public static void main(String[] args) {
		M1 m = new M1();

		m.init();
		System.out.println("洗牌后");
		String str[] = m.rand(majiang);
		m.System(str);

		int n = 1;
		System.out.println("发牌" + n);
		String st[] = m.fapai(str);
		m.System(st);

		System.out.println("整理后");
		m.System(m.zhengli(st));

	}

	public void System(String[] arg) {
		for (int j = 0; j < arg.length; j++) {
			System.out.print(arg[j] + " ");
		}
		System.out.println();
	}

	public void init() {
		int n = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < s.length; j++) {
				majiang[n] = s[j];
				n++;
			}
		}
		for (int i = 0; i < wangpai.length; i++) {
			majiang[majiang.length - 8 + i] = wangpai[i];
		}

		System(majiang);

	}

	public String[] rand(String[] ma) {
		Random rand = new Random();
		String temp = "";
		int n;
		for (int i = 0; i < majiang.length; i++) {
			n = rand.nextInt(144);
			temp = ma[i];
			ma[i] = ma[n];
			ma[n] = temp;

		}
		return ma;
	}

	int n = 0;

	public String[] fapai(String[] ma) {
		String[] wanjia = new String[13];
		for (int i = 0; i < 13; i++) {
			wanjia[i] = ma[n];
			n++;
		}
		return wanjia;
	}

	public String[] zhengli(String[] paimian) {
		String str = "";
		int start = 0;
		int end = 12;
		for (int i = 0; i < paimian.length; i++) {
			if (paimian[i].endsWith("万")) {
				str = paimian[start];
				paimian[start] = paimian[i];
				paimian[i] = str;
				start++;
			}
			if (paimian[i].matches("['东''南''西''北']")) {
				str = paimian[end];
				paimian[end] = paimian[i];
				paimian[i] = str;
				end--;
			}

		}
		for (int i = 0; i < paimian.length; i++) {
			if (paimian[i].endsWith("筒")) {
				str = paimian[start];
				paimian[start] = paimian[i];
				paimian[i] = str;
				start++;
			}
			if (paimian[i].endsWith("条")) {
				str = paimian[end];
				paimian[end] = paimian[i];
				paimian[i] = str;
				end--;
			}
		}
		return paimian;
	}

}