package sy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 1.编写程序利用Random类的对象的链表中一随机的顺序存储一副144张的麻将。 用含有连个字符的字符串代表麻将，例如“11”表示一万，“12”表示2万等。
 * 
 * 从栈中输出4手牌，每手牌有13张牌，手牌按万条筒风牌排序，
 * 
 * 输出时要把11显示为一万，12显示成二万这样。
 */
public class Majiang {

    private static final String[] huapai = { "春", "夏", "秋", "冬", "梅", "兰", "竹", "菊" };

    private static final String[] majiangzi = { "一万", "二万", "三万", "四万", "五万", "六万", "七万", "八万", "九万", "一条", "二条", "三条",
            "四条", "五条", "六条", "七条", "八条", "九条", "一筒", "二筒", "三筒", "四筒", "五筒", "六筒", "七筒", "八筒", "九筒", "东风", "南风", "西风",
            "北风", "红中", "白板", "发财" };

    private static int[] superCode = { 100, 101, 102, 103, 104, 105, 106, 107 };

    private static int[] normalCode = { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44 };

    private List<Integer> majiang = new ArrayList<Integer>();

    public static void main(String[] args) {
        Majiang m = new Majiang();
        m.init();
        int[][] player = m.fapai();

        for (int[] pp : player) {
            for (int p : pp) {
                if (p > 99) {
                    System.out.print(huapai[p - 100] + " ");
                } else {
                    System.out.print(majiangzi[p - 11] + " ");
                }
            }
            System.out.println();
        }

    }

    /**
     * 麻将洗牌
     * 
     * 1、初始化一副麻将，包括108张序数牌，28张字牌，8张花牌
     * 
     * 2、将初始的顺序打乱
     */
    public void init() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < normalCode.length; j++) {
                majiang.add(normalCode[j]);
            }
        }

        for (int i = 0; i < superCode.length; i++) {
            majiang.add(superCode[i]);
        }

        Random random = new Random();
        int size = majiang.size();
        for (int i = 0; i < size; i++) {
            int index = random.nextInt(size);
            int temp = majiang.get(index);
            majiang.set(i, temp);
            majiang.set(index, majiang.get(i));
        }
    }

    /**
     * 按照顺序，4个人轮流摸牌
     * 
     * 1、每个人摸一张牌，第i个人摸第j张牌，该牌位于4*i+j
     * 
     * 2、排序每个人的手牌
     * 
     */
    public int[][] fapai() {
        int[][] player = new int[4][13];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                player[j][i] = majiang.get(i * 4 + j);
            }
        }
        for (int[] p : player) {
            Arrays.sort(p);
        }
        return player;
    }

}