package thinkingInJava.ch14;

public class Init {

    public static void main(String[] args){
//        System.out.println(1);
//        Object obj=Init1.init3;
//        System.out.println(Init1.i1);
////        int i=Init1.i2;
//        System.out.println(3);
//            Class.forName("thinkingInJava.ch14.Init1");
            Object o=Init1.class;
        
    }
}


class Init1{
    
    static int i1=1;
    static{
        System.out.println("init1");
    }
    static Init2 init2=new Init2();
    
    static final int i2=2;
    static{
        System.out.println("init2");
    }
    static final Init2 init3=new Init2();
    
    
    Init1(){
        System.out.println("init1****");
    }
}

class Init2{
    public Init2(){
        System.out.println("Init2******");
    }
}

