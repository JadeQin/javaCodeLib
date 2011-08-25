package topCoder.srm478;

/**
 * Problem Statement
    
Rabbits often feel hungry, so when they go out to eat carrots, they jump as quickly as possible.  Initially, 
rabbit Hanako stands at position init. From position x, she can jump to either position 4*x+3 or 8*x+7 
in a single jump. She can jump at most 100,000 times because she gets tired by jumping.  Carrots are planted at 
position x if and only if x is divisible by 1,000,000,007 (i.e. carrots are planted at position 0, 
position 1,000,000,007, position 2,000,000,014, and so on). Return the minimal number of jumps required to reach a 
carrot. If it's impossible to reach a carrot using at most 100,000 jumps, return -1.

init will be between 1 and 1,000,000,006, inclusive.
 * @author AAA
 *
 */

public class CarrotJumping {

    final int BASE_POSITION=1000000007;
    final int JUMP_STEP=100000;
    
    public int theJump(int init){
        if(init%BASE_POSITION==0){
            return 0;
        }
        for(int i=0;i<JUMP_STEP;i++){
            int m=jump1(init);
            int n=jump2(init);
            if(init%BASE_POSITION==0){
                return i;
            }
            
        }
        return -1;
    }
    
    private boolean jump(int x){
        int m=jump1(x);
        int n=jump2(x);
        if(m%BASE_POSITION==0||n%BASE_POSITION==0){
            return true;
        }else{
            return false;
        }
    }
    
    private int jump1(int x){
        return 4*x+3;
    }
    
    private int jump2(int x){
        return 8*x+7;
    }
}
