package com.Utils;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
 * 一个创建实体类的工厂
 *
 * */
public class BeanFactory {
    /*
     * 读取配置文件属性
     * */
    private static Properties props;
    /*
     *容器
     * */
    private static Map<String, Object> beans;

    static {
        try {
            //实例化对象
            props = new Properties();
            //获取propertie文件的流对象
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            //加载==
            props.load(inputStream);
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration keys = props.keys();
            while (keys.hasMoreElements()) {
                //获取key
                String s = keys.nextElement().toString();
                // 获取key 的值
                String property = props.getProperty(s);
                //创建对象
                Object value = Class.forName(property).newInstance();
                //存入容器
                System.out.println(s+":"+value);
                beans.put(s, value);
            }

        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化失败");
        }
    }
   /* public  static Object getBean(String beanName){
        Object bean=null;
        try {
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  bean;
    }*/

        public  static Object getBean(String BeanName){
            return  beans.get(BeanName);
        }



}
