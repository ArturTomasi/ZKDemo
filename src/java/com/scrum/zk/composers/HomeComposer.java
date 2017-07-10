package com.scrum.zk.composers;

import com.scrum.zk.ApplicationUtilities;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericComposer;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.Menubar;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.North;

public class HomeComposer extends GenericComposer<Component>
{

    @Override
    public void doAfterCompose( Component comp ) throws Exception
    {
        
        Menubar menubar = new Menubar();
        menubar.setHeight( "50px" );
        Menuitem menuitem = new Menuitem("logout");
        
        menuitem.addEventListener( Events.ON_CLICK, new EventListener()
        {
            @Override
            public void onEvent( Event event ) throws Exception
            {
                ApplicationUtilities.getInstance().logout();
            }
        });
        
        menubar.appendChild( menuitem );
        
        borderlayout.setSclass( "content" );
        borderlayout.setStyle( "margin: auto;" );
        
        north.appendChild( menubar );
        
//        borderlayout.setHflex( "true" );
//        borderlayout.setVflex( "true" );
        
        borderlayout.appendChild( north );
        borderlayout.appendChild( center );
        
        comp.appendChild( borderlayout );
    }
    
    private final Borderlayout borderlayout = new Borderlayout();
    private final Center center = new Center();
    private final North north = new North();
}
