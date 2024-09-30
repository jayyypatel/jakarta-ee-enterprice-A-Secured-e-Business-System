package realestatemanagement.Beans;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.inject.Inject;

public class LoginFilter implements Filter {

    //Use the following for GlassFish 7.0.9  
    @Inject
    AuthenticationBean session;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Init app");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        //Any after login accessible pages will be listed here
        String[] afterLog = {"logout.xhtml", "home.xhtml"};
        String url = req.getRequestURI();
        if (session == null || !session.isLogged()) {
            boolean risk = false;
            for (int i = 0; i < afterLog.length; i++) {
                if (url.indexOf(afterLog[i]) >= 0) {
                    risk = true;
                    break;
                }
            }
            if (risk) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/login.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            if (url.indexOf("registration.xhtml") >= 0 || url.indexOf("login.xhtml") >= 0
                    || url.indexOf("verification.xhtml") >= 0 || url.indexOf("emailRecovery.xhtml") >= 0
                    || url.indexOf("userRecovery.xhtml") >= 0 || url.indexOf("listManager.xhtml") >= 0
                    || url.indexOf("newPropertymanager.xhtml") >= 0 || url.indexOf("searchManager.xhtml") >= 0
                    || url.indexOf("viewManager.xhtml") >= 0) {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/home.xhtml");
            } else if (url.indexOf("logout.xhtml") >= 0) {
                //Use the following for GlassFish 6.2.5  
                //req.getSession().removeAttribute("authBean");
                //Use the following for GlassFish 7.0.9  
                req.getSession(false).invalidate();
                resp.sendRedirect(req.getServletContext().getContextPath() + "/login.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("Destroy app");
    }

}
