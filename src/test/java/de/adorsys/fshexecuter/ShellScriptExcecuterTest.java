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

import java.util.UUID;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.forge.test.AbstractShellTest;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;

public class ShellScriptExcecuterTest extends AbstractShellTest {

	@Deployment
	public static JavaArchive getDeployment() {
		System.setProperty("forge.debug.no_auto_init_streams", "false");
		
		String uid = UUID.randomUUID().toString();
		System.setProperty("newproject.dir", "target/" + uid);
		System.setProperty("newproject.topLevelPackage", "com.adorys.shellscript.test");
		System.setProperty("newproject.name", uid);
		
		System.setProperty("exec.fsh.file", ShellScriptExcecuterTest.class.getResource("test.fsh").getFile());
		
		
		return AbstractShellTest.getDeployment().addPackages(true,
				ShellScriptExcecuter.class.getPackage());
	}

	@Test
	public void testDefaultCommand() throws Exception {
		System.out.println("nothing to do");
	}
}
