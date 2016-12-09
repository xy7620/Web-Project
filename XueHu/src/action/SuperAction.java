package action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author XF
 * 方便使用拦截器等使用继承
 * 为获得request等内置对象实现三个接口
 */
public class SuperAction extends ActionSupport implements ServletRequestAware,
		ServletContextAware, ServletResponseAware {

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected ServletContext application;
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub

		this.response = response;
	}

	@Override
	public void setServletContext(ServletContext application) {
		// TODO Auto-generated method stub
		this.application = application;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub

		this.request =request;
		this.session = this.request.getSession();
	}

}
