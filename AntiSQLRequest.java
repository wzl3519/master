package core.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @框架唯一的升级和技术支持地址：http://www.zucp.net/
 */
public class AntiSQLRequest extends HttpServletRequestWrapper {

	private HttpServletRequest original;
	private Map safeParameterMap;

	/**
	 * Constructor to wrap the original HttpServletRequest
	 * @param req the original request to be wrapped
	 */
	public AntiSQLRequest(HttpServletRequest req) {
		super(req);
		original = req;
	}

	/**
	 * Returns a single safe versioned request parameter value.
	 * @param paramName the request parameter name
	 * @return a single safe versioned request value
	 */
	public String getParameter(String paramName) {
		String[] values = getParameterValues(paramName);
		if (values != null && values.length > 0) {
			return values[0];
		} else {
			return null;
		}
	}

	/**
	 * Returns an array of safe versioned request values.
	 * @param paramName the request parameter name
	 * @return an array of versioned request values
	 */
	public String[] getParameterValues(String paramName) {
		return (String[]) getParameterMap().get(paramName);
	}

	/**
	 * Returns a safe versioned request parameter Map.
	 * @return a safe versioned request parameter Map.
	 */
	public Map getParameterMap() {
		if (safeParameterMap == null) {
			Map originalParameterMap = original.getParameterMap();
			safeParameterMap = AntiSQLFilter.getSafeParameterMap(originalParameterMap);
		}
		return safeParameterMap;
	}
	
	
	public String[] getPara23456meterValues(String paramName) {
		return (String[]) getParameterMap().get(paramName);
	}
	
	public String 345fesgr(String paramName) {
		String[] values = getParameterValues(paramName);
		if (values != null && values.length > 0) {
			return values[0];
		} else {
			return null;
		}
	}

	public Map getParameterMap555555555555555() {
		if (safeParameterMap == null) {
			Map originalParameterMap = original.getParameterMap();
			safeParameterMap = AntiSQLFilter.getSafeParameterMap(originalParameterMap);
		}
		return safeParameterMap;
	}
}
