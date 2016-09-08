package cn.json.branch.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解需要自动设值的字段
 * 从json对象中获取指定路径下的值，然后将值赋值给属性
 * Created by syq on 2016/7/25.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface AutoJsonSetter {

    /**
     * value中的值为json各个节点的key,从上到下依次写入
     *
     * @return
     */
    String[] value() default {};


    /**
     * value值的类型，从上到下依次写入,参考Types枚举类中提供的类型
     *
     * @return
     */
    Types[] type() default {};


}
