package com.beangou.util.httpclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 翻墙代理IP
	private  String proxyHost = "127.0.0.1";

	// 翻墙代理端口
	private  int proxyPort = 1080;

	private CloseableHttpClient httpClient = null;

	protected RequestConfig requestConfig;

	protected Builder builder = RequestConfig.custom();

	public HttpClientUtil() {
		httpClient = HttpClients.createDefault();
		builder.setConnectTimeout(10000);
		builder.setSocketTimeout(10000);
		builder.setConnectionRequestTimeout(10000);
		requestConfig = builder.build();
	}

	public HttpClientUtil(int connectTimeout, int socketTimeout, int connectionRequestTimeout,
                          int maxConnPerRoute, int retryCount) {
		builder.setConnectTimeout(connectTimeout);
		builder.setSocketTimeout(socketTimeout);
		builder.setConnectionRequestTimeout(connectionRequestTimeout);
		requestConfig = builder.build();
		httpClient = HttpClients.custom().setMaxConnPerRoute(maxConnPerRoute)
				.setRetryHandler(new DefaultHttpRequestRetryHandler(retryCount, true))
				.build();
	}

	public HttpClientUtil(int connectTimeout, int socketTimeout, int connectionRequestTimeout,
						  int maxConnPerRoute, int tryCount, Collection<Class<? extends IOException>> nonRetryClasses) {
		builder.setConnectTimeout(connectTimeout);
		builder.setSocketTimeout(socketTimeout);
		builder.setConnectionRequestTimeout(connectionRequestTimeout);
		requestConfig = builder.build();
		httpClient = HttpClients.custom().setMaxConnPerRoute(maxConnPerRoute)
				.setRetryHandler(new MyRetryHandler(tryCount, nonRetryClasses))
				.build();
	}

	/**
	 * 自定义重试异常类不需要重试
	 */
	private class MyRetryHandler extends DefaultHttpRequestRetryHandler {
		public MyRetryHandler(int retryCount, Collection<Class<? extends IOException>> nonRetryClasses) {
			super(retryCount, retryCount < 1 ? false : true, nonRetryClasses);
		}
	}

	public HttpClientUtil(boolean enableProxy) {
		httpClient = HttpClients.createDefault();
		if (enableProxy) {
			builder.setProxy(new HttpHost(proxyHost, proxyPort));
			requestConfig = builder.build();
		} else {
			requestConfig = builder.build();
		}
	}
	
	public HttpClientUtil(String proxyHost, int proxyPort) {
		httpClient = HttpClients.createDefault();
		this.proxyHost=proxyHost;
		this.proxyPort=proxyPort;
		builder.setProxy(new HttpHost(proxyHost, proxyPort));
		requestConfig = builder.build();
	}

	public Builder getBuilder() {
		return builder;
	}

	public String get(String uri) throws Exception {
		logger.info("开始请求：uri={}", uri);

		CloseableHttpResponse response = null;
		try {
			HttpGet httpGet = new HttpGet(uri);
			httpGet.setConfig(requestConfig);
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();

			if (response.getStatusLine().getStatusCode() != 200) {
				httpGet.abort();
				logger.error("url={}, code={}", uri, response.getStatusLine().getStatusCode());
				throw new Exception(String.format("http请求出错，url=%s", uri));
			}
			String content = EntityUtils.toString(response.getEntity());
			// do something useful with the response body and ensure it is fully consumed
			EntityUtils.consume(entity);
			if (StringUtils.isBlank(content)) {
				logger.error("请求返回结果为空, uri={}", uri);
				return null;
			}
			return content;
		} catch (Exception e) {
			logger.error("请求：uri={}, 失败", uri, e);
			throw new Exception(String.format("http请求出错，url=%s", uri));
		} finally {
			if (response != null) {
				// In order to ensure correct deallocation of system resources
				// the user MUST call CloseableHttpResponse#close() from a finally clause
				response.close();
			}
		}
	}

	public <T> T get(String uri, Map<String, Object> params, TypeReference<T> typeReference, Feature... features)
			throws Exception {
		logger.info("开始请求：uri={}, params={}", uri, params);
		if (!uri.contains("?") && params != null && CollectionUtils.isNotEmpty(params.keySet())) {
			uri += '?';
		}
		if (params != null && CollectionUtils.isNotEmpty(params.keySet())) {
			for (String key : params.keySet()) {
				Object value = params.get(key);
				if (value == null) {
					continue;
				}
				if (uri.endsWith("?")) {
					uri += key + "=" + URLEncoder.encode(params.get(key).toString(), "utf8");
				} else {
					uri += "&" + key + "=" + URLEncoder.encode(params.get(key).toString(), "utf8");
				}

			}
		}

        CloseableHttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet(uri);
            httpGet.setConfig(requestConfig);
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();

            if (response.getStatusLine().getStatusCode() != 200) {
			    httpGet.abort();
                logger.error("url={}, params={}, code={}", uri, params, response.getStatusLine().getStatusCode());
                throw new Exception(String.format("http请求出错，url=%s", uri));
            }
            String content = EntityUtils.toString(response.getEntity());
            // do something useful with the response body and ensure it is fully consumed
            EntityUtils.consume(entity);
            if (StringUtils.isBlank(content)) {
				logger.error("请求返回结果为空, uri={}, params={}", uri, params);
                return null;
            }
            T result = JSON.parseObject(content, typeReference, features);
            return result;
        } catch (Exception e) {
		    logger.error("请求：uri={}, params={}失败", uri, params, e);
            throw new Exception(String.format("http请求出错，url=%s", uri));
        } finally {
            if (response != null) {
                // In order to ensure correct deallocation of system resources
                // the user MUST call CloseableHttpResponse#close() from a finally clause
                response.close();
            }
        }
	}
	
	public <T> T post(String uri, Map<String, Object> params, TypeReference<T> typeReference, Feature... features)
			throws Exception {
		logger.info("uri={}, params={}", uri, params);
		HttpPost httpPost = new HttpPost(uri);
		List<NameValuePair> nameValuesPairs = new ArrayList();
		if (params != null) {
			for (String key : params.keySet()) {
				Object value = params.get(key);
				if (value != null) {
					NameValuePair nameValuePair = new BasicNameValuePair(key, params.get(key).toString());
					nameValuesPairs.add(nameValuePair);
				}
			}
		}
		HttpEntity requetEntity = new UrlEncodedFormEntity(nameValuesPairs, "utf8");
		httpPost.setEntity(requetEntity);
		httpPost.setConfig(requestConfig);
		CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            if (response.getStatusLine().getStatusCode() != 200) {
                httpPost.abort();
                logger.error("post url={}, params={}, code={}", uri, params, response.getStatusLine().getStatusCode());
                throw new Exception(String.format("http请求出错，url=%s", uri));
            }
            String content = EntityUtils.toString(response.getEntity());
            // do something useful with the response body and ensure it is fully consumed
            EntityUtils.consume(entity);
            if (StringUtils.isBlank(content)) {
                return null;
            }
            T result = JSON.parseObject(content, typeReference, features);
            return result;
        } catch (Exception e) {
            logger.error("请求：post uri={}, params={}失败", uri, params, e);
            throw new Exception(String.format("http请求出错，url=%s", uri));
        } finally {
            if (response != null) {
                // In order to ensure correct deallocation of system resources
                // the user MUST call CloseableHttpResponse#close() from a finally clause
                response.close();
            }
        }
	}
}
