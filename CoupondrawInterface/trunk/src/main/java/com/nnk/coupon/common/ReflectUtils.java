package com.nnk.coupon.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/4/8
 * Time: 11:25
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
public class ReflectUtils {
    /**
     * ��ȡ��ֵ�Ե��ַ���ֵ
     * @param obj
     * @param keysplit
     * @param valueSplit
     * @param removedkeys
     * @return
     */
    public static String getkeyValueString(Object obj,String keysplit,String valueSplit,String... removedkeys){
        if(null == obj){
            return null;
        }
        Map<String,Object> map =sortFieldMap(obj);
        if(removedkeys != null) {
            for (String key : removedkeys) {
                if (map.containsKey(key)) {
                    map.remove(key);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<String,Object> entry : map.entrySet()){
            stringBuilder.append(entry.getKey()).append(keysplit)
                    .append(entry.getValue()).append(valueSplit);
        }
        String str = stringBuilder.toString();
        return str.substring(0,str.length()-1);
    }
    /**
     * ��ȡ�����ļ�ֵmap��
     */
    public static Map<String, Object> sortFieldMap(Object obj){
        Map<String,Object> map = new TreeMap<String, Object>();
        Class<?> clazz= obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field  field :fields){
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(obj));

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * ��ȡanotation��ֵ
     * @param obj
     * @param anotationClazz
     * @return
     */
    public static Annotation getAnotiation(Object obj,Class anotationClazz){
        Class<?> clazz = obj.getClass();
        return clazz.getAnnotation(anotationClazz);
    }
    public static Object invokeMethodName(Object targetObject,
                                          String methodName,
                                          Class<?>[] targetParameterTypes,
                                          Object... targetParameters)  {
        try {
            Class<?> targetCLass = targetObject.getClass();
            if(targetParameterTypes == null || targetParameters == null){

                Method method = targetCLass.getDeclaredMethod(methodName);
                method.setAccessible(true);
                return method.invoke(targetObject);
            }else {
                Method method = targetCLass.getDeclaredMethod(methodName, targetParameterTypes);
                method.setAccessible(true);
                return method.invoke(targetObject, targetParameters);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
