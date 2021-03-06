/**
 * SMS-U - Copyright (c) 2009-2014 Universite Paris 1 Pantheon-Sorbonne
 */
package org.esupportail.smsuapiadmin.web.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;

import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.smsuapiadmin.business.RoleManager;
import org.esupportail.smsuapiadmin.dto.beans.UIRole;


@Path("/roles")
public class RolesController {
	
	@Autowired
	private RoleManager roleManager;

        @SuppressWarnings("unused")
	private final Logger logger = new LoggerImpl(getClass());

	@GET
	@Produces("application/json")
	public List<UIRole> getRoles() {
		return roleManager.getAllUIRoles();
	}

}
