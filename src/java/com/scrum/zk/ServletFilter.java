package com.scrum.zk;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter( filterName = "FilterLogin", urlPatterns = { "/admin/*" } )
public class ServletFilter implements Filter
{
    @Override
    public void init( FilterConfig fc ) throws ServletException
    {
    }

    @Override
    public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException, ServletException
    {
        HttpServletRequest HttpRequest = (HttpServletRequest) request;
        
        if ( HttpRequest.getSession().getAttribute( "ActiveUser" ) != null )
        {
            chain.doFilter( request, response );
        }
        else
        {
            request.getRequestDispatcher( "/login.zul" ).forward( request, response );
        }
    }

    @Override
    public void destroy()
    {
    }
}
