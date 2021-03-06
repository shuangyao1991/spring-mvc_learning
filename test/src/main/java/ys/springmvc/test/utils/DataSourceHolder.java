package ys.springmvc.test.utils;

import org.springframework.util.Assert;

/**
 * Created with by shuangyao on 2016/8/17.
 */
public class DataSourceHolder {

    //线程本地环境
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    //设置数据源类型
    public static void set(String  dataSourceType){
//        Assert.isTrue(dataSourceType == null || dataSourceType.matches("[\\s]*"), "DataSourceType cannot be null!");
        contextHolder.set(dataSourceType);
    }

    //获取数据源类型
    public static String get(){
        return contextHolder.get();
    }

    //清除数据源类型
    public static void clear(){
        contextHolder.remove();
    }

}
