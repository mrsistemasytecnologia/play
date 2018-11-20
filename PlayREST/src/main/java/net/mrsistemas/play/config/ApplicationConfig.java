package net.mrsistemas.play.config;

import java.util.Set;
import javax.ws.rs.core.Application;

import net.mrsistemas.play.rs.server.PlayCitiesServer;
import net.mrsistemas.play.rs.server.PlayDeviceServer;
import net.mrsistemas.play.rs.server.PlayUsersServer;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/mrsistemas")
public class ApplicationConfig extends Application {

	public Set<Class<?>> getClasses() {
        return getRestClasses();
    }
    
    private Set<Class<?>> getRestClasses() {
		Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
		
//		resources.add(net.mrsistemas.play.rs.server.SubResource.class);
//		resources.add(net.mrsistemas.play.rs.server.Resource.class);
		resources.add(PlayUsersServer.class);
		resources.add(PlayCitiesServer.class);
		resources.add(PlayDeviceServer.class);
		return resources;    
    }
}