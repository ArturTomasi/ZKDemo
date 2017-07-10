package com.scrum.zk;

import com.scrum.zk.data.User;
import javax.servlet.http.HttpSession;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;

public class ApplicationUtilities
{

    private ApplicationUtilities()
    {
    }

    public static final String SESSION_NAME = "ApplicationUtilities";

    public static ApplicationUtilities getInstance()
    {
        ApplicationUtilities ac = null;

        if ( Sessions.getCurrent() != null )
        {
            ac = (ApplicationUtilities) Sessions.getCurrent().getAttribute( SESSION_NAME );
        }

        if ( ac == null )
        {
            ac = new ApplicationUtilities();

            if ( Sessions.getCurrent() != null )
            {
                Sessions.getCurrent().setAttribute( SESSION_NAME, ac );
            }
        }

        return ac;
    }

    public User getActiveUser()
    {
        return (User) ( (HttpSession) Sessions.getCurrent().getNativeSession() ).getAttribute( "ActiveUser" );
    }

    public void logout()
    {
        Executions.getCurrent().getSession().invalidate();
        Executions.sendRedirect( null );
    }

}
