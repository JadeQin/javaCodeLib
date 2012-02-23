package sy;

/**
 * 
 * 2.有ABCD四个朋友，国庆时他们决定先去湖南再去内蒙最后去西藏游玩，由于他们住在南方不同的城市，选择了不同的交通工具：A选择汽车B选择了火车C选择了飞机而D选择了徒步
 * 
 * 先到达湖南的人要在湖南等其他人到达后再商量如何去内蒙；在湖南因为意见不和，他们又分成AD和BC两组，分别选择不同的方式到达内蒙，到达后再一起坐飞机西藏。用程序实现
 * 
 * 这一过程(ABCD分别为四个线程)
 * 
 */
public class Travel {

    public static void main(String[] args) {
        Go a = new Go("A");
        Go b = new Go("B");
        Go c = new Go("C");
        Go d = new Go("D");
        a.start();
        b.start();
        c.start();
        d.start();

    }

}

class Go extends Thread {

    private static int count = 0;

    private static int nm1 = 0;

    private static int nm2 = 0;

    private static Object hunan = new Object();

    private static Object neimeng = new Object();

    private static Object AD = new Object();

    private static Object BC = new Object();

    public Go(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            toHunan();
            toNeimeng();
            toXizang();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void toHunan() throws InterruptedException {
        synchronized (hunan) {
            count++;
            if (count < 4) {
                System.out.println(getName() + " H wait");
                hunan.wait();

            } else {
                System.out.println(getName() + " H notify");
                count = 0;
                hunan.notifyAll();
            }
        }

    }

    private void toNeimeng() throws InterruptedException {
        if (getName().equals("A") || getName().equals("D")) {
            nm1++;
            synchronized (AD) {
                if (nm1 < 2) {
                    System.out.println(getName() + " N wait");
                    AD.wait();
                } else {
                    System.out.println(getName() + " N notify");
                    AD.notifyAll();
                }
            }
        } else {
            nm2++;
            synchronized (BC) {
                if (nm2 < 2) {
                    System.out.println(getName() + " N wait");
                    BC.wait();
                } else {
                    System.out.println(getName() + " N notify");
                    BC.notifyAll();
                }

            }
        }

        synchronized (neimeng) {
            count++;
            if (count < 4) {
                System.out.println(getName() + " X wait");
                neimeng.wait();

            } else {
                System.out.println(getName() + " X notify");
                neimeng.notifyAll();
            }
        }

    }

    private void toXizang() {
        System.out.println(getName() + " X");
    }

}
