/**
 * Created with by shuangyao on 2016/8/11.
 */
public class Test {

    public static void main(String[] args){
        System.out.println(Math.pow(3, (int)(Math.log(Integer.MAX_VALUE) / Math.log(3))) % 243 == 0);
    }
}
