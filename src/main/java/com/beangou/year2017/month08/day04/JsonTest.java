package com.beangou.year2017.month08.day04;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.junit.Test;

import java.io.IOException;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/8/4
 * @since 1.0
 */
public class JsonTest {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void see() {
        System.out.println("result=" + toJsonString(new Person(null, 88), true));
    }

    /**
     * 对象转字符串，忽略null属性
     * @param obj
     * @param ignoreNull
     * @return
     */
    public static String toJsonString(final Object obj, boolean ignoreNull) {
        String str = null;
        try {
            if (ignoreNull) {
                objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
            }
            str = objectMapper.writeValueAsString(obj);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}

@Getter
@Setter
class Person {

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;

    private int age;
}
