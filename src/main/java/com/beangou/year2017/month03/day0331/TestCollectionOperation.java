package com.beangou.year2017.month03.day0331;

import com.beangou.year2017.Entity;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/3/31
 * @since 1.0
 */
public class TestCollectionOperation {

    @Test
    public void testListOperate() {
        List<Person> resultList = new ArrayList<>();
        List<Person> customDataList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            resultList.add(new Person(i));
        }
        for (int i = 0; i < 3; i++) {
            customDataList.add(new Person(1000 + i));
        }
//        List<String> overList = customsDataShowInFirstPage(resultList, customDataList);
//        List<String> overList = customsDataShowInFirstPageErrorVersion(resultList, customDataList);
        List<Person> overList = customsDataShowInFirstPageErrorVersionDevelop(resultList, customDataList);
//        List<String> overList = customsDataShowInFirstPageBetterVersion(resultList, customDataList);
        System.out.println("list=" + overList);
        System.out.println("listSize=" + overList.size());
    }

    /**
     * 报错版本
     * @param resultList
     * @param customDataList
     * @return
     */
    private List<String> customsDataShowInFirstPageErrorVersion(List<String> resultList, List<String> customDataList) {
        if (CollectionUtils.isEmpty(customDataList)) {
            return resultList;
        }
        // 取出前9条数据
        List<String> frontList = resultList.subList(0, 9);
        resultList.removeAll(frontList);

        frontList.addAll(customDataList);
        // 将前面数据打乱
        Collections.shuffle(frontList);
        // 将list数据打乱
        Collections.shuffle(resultList);
        // 保证海关数据在前面
        frontList.addAll(resultList);
        return frontList;
    }

    /**
     * 报错版本演进
     * @param resultList
     * @param customDataList
     * @return
     */
    private List<Person> customsDataShowInFirstPageErrorVersionDevelop(List<Person> resultList, List<Person> customDataList) {
        if (CollectionUtils.isEmpty(customDataList)) {
            return resultList;
        }
        // 取出前9条数据
        List<Person> frontList = resultList.subList(0, 9);

//        Person firstEle = frontList.get(0);
//        firstEle.setId(100);
        System.out.println("frontList=" + frontList);
        System.out.println("resultList=" + resultList);

//        for (Person person : frontList) {
//            resultList.remove(person);
//        }
        resultList.removeAll(frontList);

        System.out.println("frontList=" + frontList.size());

        System.out.println("after remove: resultList=" + resultList);

        for(Person person : resultList) {
            System.out.println("person = " + person);
        }
        return frontList;
    }

    /**
     * 纠正版本
     * @param resultList
     * @param customDataList
     * @return
     */
    private List<String> customsDataShowInFirstPage(List<String> resultList, List<String> customDataList) {
        if (CollectionUtils.isEmpty(customDataList)) {
            return resultList;
        }
        // 取出前9条数据
        List<String> frontList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            frontList.add(resultList.get(0));
            resultList.remove(0);
        }

        resultList.removeAll(frontList);
        frontList.addAll(customDataList);
        // 将前面数据打乱
        Collections.shuffle(frontList);
        // 将list数据打乱
        Collections.shuffle(resultList);
        // 保证海关数据在前面
        frontList.addAll(resultList);
        return frontList;
    }

    /**
     * 优化版本
     * @param resultList
     * @param customDataList
     * @return
     */
    private List<String> customsDataShowInFirstPageBetterVersion(List<String> resultList, List<String> customDataList) {
        if (CollectionUtils.isEmpty(customDataList)) {
            return resultList;
        }
        // 取出前9条数据
        List<String> frontList = new ArrayList<>(resultList.subList(0, 9));
        resultList.removeAll(frontList);
        frontList.addAll(customDataList);
        // 将前面数据打乱
        Collections.shuffle(frontList);
        // 将list数据打乱
        Collections.shuffle(resultList);
        // 保证海关数据在前面
        frontList.addAll(resultList);
        return frontList;
    }


}

class Person extends Entity {
    public Person(int id) {
        this.id = id;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}