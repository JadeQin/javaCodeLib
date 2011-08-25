package euler.p14;

import java.util.ArrayList;
import java.util.List;

public class P14 {

    public List<Integer> getSequence(Integer num){
        List<Integer> list=new ArrayList<Integer>();
        list.add(num);
        while(num!=1){
            if(num%2==0){
                num/=2;
                list.add(num);
            }else{
                num=num*3+1;
                list.add(num);
            }
        }
        return list;
    }
    
    public static void main(String[] args){
        int count=0;
        int num=0;
        P14 p=new P14();
        for(int i=2;i<1000000;i++){
            System.out.println(i);
            List<Integer> list=p.getSequence(i);
            if(list.size()>count){
                count=list.size();
                num=list.get(0);
            }
        }
        
//        Thread
    }
}
