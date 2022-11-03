import javax.servlet.http.*;
public class SessionSetterandGetter {
	private static HttpServletRequest request;
	private static String attribute;
	private static String name;
	public SessionSetterandGetter(HttpServletRequest request,String attribute,String name) {
		SessionSetterandGetter.request = request;
		this.attribute = attribute;
		this.name = name;
	}
	public static void main(String[] args)throws Exception {
		HttpSession sess = request.getSession();
		setSessionAttribute(sess,attribute,name);
	}
	private static void setSessionAttribute(HttpSession sess, String attribute, String name) {
		sess.setAttribute(name, attribute);
	}
	private static void getSessionAttribute(HttpSession sess,String name) {
		sess.getAttribute(name);
	}
}
