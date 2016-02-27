package cn.ssms.realm;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

public class RoleAuthorizationFilter extends AuthorizationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest arg0, ServletResponse arg1)
			throws IOException {
		// TODO Auto-generated method stub
		System.out.println("denyed......................");
		return super.onAccessDenied(arg0, arg1);
	}
	@Override
	public boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws IOException {
		System.out.println("allowed.................");
		Subject subject = getSubject(request, response);
		String rolesArray[] = (String[]) (String[]) mappedValue;
		if (rolesArray == null || rolesArray.length == 0) {
			return true;
		} else {
			java.util.Set roles = CollectionUtils.asSet(rolesArray);
			return subject.hasAllRoles(roles);
		}
	}
}
