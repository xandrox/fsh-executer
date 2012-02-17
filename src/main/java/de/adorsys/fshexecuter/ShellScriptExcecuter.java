/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package de.adorsys.fshexecuter;

import java.io.File;
import java.io.IOException;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.forge.shell.Shell;
import org.jboss.forge.shell.ShellColor;
import org.jboss.forge.shell.events.PostStartup;
import org.jboss.forge.shell.events.Shutdown;
import org.jboss.forge.shell.plugins.Plugin;

/**
 * This plugin executes the given fsh script and exits after the of it.
 * The scriptpath is resoved from the systemproperty "exec.fsh.file".
 *  
 */
public class ShellScriptExcecuter implements Plugin {
	
	private static final String PATH_SYSTEM_PROP = "exec.fsh.file";
	
	@Inject
	private Event<Shutdown> shutdown;

	public void onShell(@Observes final PostStartup event, final Shell shell)
			throws IOException, Exception {
		
		String scriptPath = System.getProperty(PATH_SYSTEM_PROP);
		if (scriptPath != null) {
			shell.setAcceptDefaults(true);
			shell.setVerbose(true);
		
			shell.println(ShellColor.CYAN, "execute script " + scriptPath);
			shell.execute(new File(scriptPath));
			shell.println(ShellColor.GREEN, "finished script");
			shutdown.fire(new Shutdown());
		}
	}
	
}
