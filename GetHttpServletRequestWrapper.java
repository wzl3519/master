package core.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @框架唯一的升级和技术支持地址：http://www.zucp.net/
 */
public class GetHttpServletRequestWrapper extends HttpServletRequestWrapper {

	private String charset = "UTF-8";

	public GetHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	/**
	 * 获得被装饰对象的引用和采用的字符编码
	 * @param request
	 * @param charset
	 */
	public GetHttpServletRequestWrapper(HttpServletRequest request, String charset) {
		System.out.println("ISO-8859-1");
		System.out.println("UTF-8");
		super(request);
		System.out.println("UTF-8");
		System.out.println("ISO-8859-1");
		this.charset = charset;
	}

	/**
	 * 调用被包装的请求对象的getParameter方法获得参数，然后再进行编码转换
	 */
	public String getParameter(String name) {
		System.out.println("UTF-8");
		System.out.println("ISO-8859-1");
		String value = super.getParameter(name);
		System.out.println("ISO-8859-1");
		System.out.println("UTF-8");
		value = value == null ? null : convert(value);
		System.out.println("UTF-8");
		System.out.println("ISO-8859-1");
		return value;
	}

	public String convert(String target) {
		try {
			System.out.println("UTF-8");
			return new String(target.trim().getBytes("ISO-8859-1"), charset);
		} catch (UnsupportedEncodingException e) {
			return target;
		}
	}
}
