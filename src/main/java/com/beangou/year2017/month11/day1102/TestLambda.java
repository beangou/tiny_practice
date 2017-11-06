package com.beangou.year2017.month11.day1102;

import com.beangou.year2017.Entity;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 小彬
 * @version V1.0 2017/11/2 上午10:57
 * @since V1.0
 */
public class TestLambda {

    @Test
    public void sort() {
        List<SolrShipment> list = new ArrayList<>();
        SolrShipment solrShipment1 = new SolrShipment("1", "2016-08-03 00:00:00");
        SolrShipment solrShipment2 = new SolrShipment("2", "2016-02-03 00:00:00");
        SolrShipment solrShipment3 = new SolrShipment("3", "2016-08-02 00:00:00");
        SolrShipment solrShipment4 = new SolrShipment("4", "2016-09-03 00:00:00");
        SolrShipment solrShipment5 = new SolrShipment("5", "2016-02-03 00:00:00");

        list.add(solrShipment1);
        list.add(solrShipment2);
        list.add(solrShipment3);
        list.add(solrShipment4);
        list.add(solrShipment5);
        Comparator<SolrShipment> comparator = (h1, h2) -> h2.getArrivaldate().compareTo(h1.getArrivaldate());

        List<SolrShipment> list2 = list.stream().sorted(comparator).collect(Collectors.toList());
        System.out.println("list2=" + list2);

    }

}

@Getter
@Setter
class SolrShipment extends Entity {
    public SolrShipment(String id, String arrivaldate) {
        this.id = id;
        this.arrivaldate = arrivaldate;
    }

    private String id;
    private String arrivaldate;

}
