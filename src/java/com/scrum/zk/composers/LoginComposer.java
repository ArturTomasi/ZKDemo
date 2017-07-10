package com.scrum.zk.composers;



import com.scrum.zk.data.User;
import javax.servlet.http.HttpSession;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vbox;

public class LoginComposer extends GenericComposer<Component>
{

    @Override
    public void doAfterCompose( Component comp ) throws Exception
    {
        Label l1 = new Label("Usuario");
        Label l2 = new Label("Senha");
        
        Textbox t1 = new Textbox();
        Textbox t2 = new Textbox();
        t2.setType("password");
        
        Button button = new Button("vai");
        button.setSclass( "btn btn-success");
        button.setZclass( " ");
        
        button.addEventListener( Events.ON_CLICK, new EventListener()
        {
            @Override
            public void onEvent( Event event ) throws Exception
            {
                login();
            }
        });
        
        Vbox vbox = new Vbox();
        vbox.appendChild( l1 );
        vbox.appendChild( t1 );
        vbox.appendChild( l2 );
        vbox.appendChild( t2 );
        vbox.appendChild( button );
        comp.appendChild( vbox );
    }
    
    private void login()
    {
        // faz select banco verifica o usuario
        
        User user = new User();
        ((HttpSession)Sessions.getCurrent().getNativeSession()).setAttribute( "ActiveUser", user );
        Executions.sendRedirect( "" );
    }
}
