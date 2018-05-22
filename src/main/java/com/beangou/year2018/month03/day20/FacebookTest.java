package com.beangou.year2018.month03.day20;

import facebook4j.*;
import facebook4j.auth.AccessToken;
import facebook4j.conf.ConfigurationBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author 小彬
 * @version V1.0 2018/3/20 下午11:31
 * @since V1.0
 */
public class FacebookTest {

    String appId = "1462873430417362";
    String appSecret = "9e0d6016a4e80b9314e00b80f86348db";
    String token = "EAAFKc9GMDV4BAKmbbvxDKGvoAJwWgt2jiDeWpRJZBYUlXKxFbQq0aOPvoFB48qmZCs02PGRoSw279odZCZBQk4cxWyVrsbzgKPPKp0K1PAMyKuq6ypHheKGb0jB0CSMgKqZBN6wQ9lEGh9X1hVDYvTyB2Rnc8ZAz8ZD";

    @Test
    public void encode() throws UnsupportedEncodingException {
        String url = "https%3A%2F%2Fgraph.facebook.com%2Fv2.8%2Fsearch%3Faccess_token%3DEAAPniDpSP14BAFJx9ZB7FdBDFOaiCv7gMmefWDq0qH1udipIVyLEYV4qzCOq0gprGCYVHrdkTHvqrB7qpsOsEbtfCjZB3NT82cFZARVg8ZCvHMN4PmJZB9sXAGJcsIP5cUKAmGCU62W65rXsqKqcMAQOZAYrFWW7qIiTHsytPZAkEn1GZCcGG6WS8UX2NucZCqCIDueffmC1ZC1gZDZD%26fields%3Did%252Cpicture%252Cabout%252Caccess_token%252Cbirthday%252Cawards%252Ccompany_overview%252Cdescription%252Ccategory%252Clocation%252Cwebsite%252Cemails%252Cname%252Cphone%252Cproducts%252Cusername%252Cfounded%252Cfan_count%252Cposts.limit%25281%2529%257Bparent_id%252Cattachments%252Ccreated_time%252Cfrom%252Cmessage_tags%252Clink%252Cmessage%252Ccomments.limit%252830%2529%257Bcomments.limit%252830%2529%257Bid%252Cmessage%252Cfrom%252Ccreated_time%257D%252Cid%252Cmessage%252Cfrom%252Ccreated_time%257D%257D%26q%3Dwigs%26type%3Dpage%26limit%3D30%26after%3DMjkZD";
        System.out.println("result=" + URLDecoder.decode(url, "utf-8"));
    }

    @Test
    public void see() throws FacebookException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId(appId)
                .setOAuthAppSecret(appSecret)
                .setOAuthAccessToken(token)
                .setHttpProxyHost("localhost")
                .setHttpProxyPort(8118);
//                .setOAuthPermissions("email,publish_stream,...");

        FacebookFactory ff = new FacebookFactory(cb.build());
        Facebook facebook = ff.getInstance();
//        Facebook facebook = new FacebookFactory().getInstance();
//        facebook.setOAuthAppId(appId, appSecret);
//        facebook.setOAuthPermissions(commaSeparetedPermissions);
//        facebook.setOAuthAccessToken(new AccessToken("", null));
        ResponseList<User> results = facebook.searchUsers("mark");
        System.out.println("result=" + results.getCount());
    }

}
