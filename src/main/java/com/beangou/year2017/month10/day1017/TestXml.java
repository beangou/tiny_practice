package com.beangou.year2017.month10.day1017;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by liutongbin on 2017/10/17.
 */
public class TestXml {

    public static void main(String args[])
    {
        String xmls="<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg><appid><![CDATA[wx87fe70de2a1dd6b1]]></appid><mch_id><![CDATA[1490248422]]></mch_id><device_info><![CDATA[WEB]]></device_info><nonce_str><![CDATA[nBfVEkhOvz5LxT6o]]></nonce_str><sign><![CDATA[1ADD1E03969D1CDDBF71592D8780F421]]></sign><result_code><![CDATA[SUCCESS]]></result_code><prepay_id><![CDATA[wx20171017105445e0cec3ac120496718461]]></prepay_id><trade_type><![CDATA[JSAPI]]></trade_type></xml>";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        Document doc;

        try {
            db = dbf.newDocumentBuilder();
            InputStream x=new ByteArrayInputStream(xmls.getBytes());;
            doc = db.parse(x);
            Element root=doc.getDocumentElement();
            NodeList nodeList = root.getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("value=" + nodeList.item(i));
            }
//            while (root.hasChildNodes()) {
//                Node node = root.getNextSibling();
//                System.out.println("node=" + node.getNodeValue());
//            }
//            System.out.print(root.getFirstChild().getNodeValue());
        } catch (ParserConfigurationException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
