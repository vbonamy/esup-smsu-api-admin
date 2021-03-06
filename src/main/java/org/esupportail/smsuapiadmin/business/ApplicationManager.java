package org.esupportail.smsuapiadmin.business;

import java.util.ArrayList;
import java.util.List;

import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.smsuapiadmin.dao.DaoService;
import org.esupportail.smsuapi.dao.beans.Application;
import org.esupportail.smsuapiadmin.dto.DTOConverterService;
import org.esupportail.smsuapiadmin.dto.beans.UIApplication;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ApplicationManager is the business layer between the web and the database for
 * 'application' objects.
 * 
 */
public class ApplicationManager {

	private final Logger logger = new LoggerImpl(getClass());

	@Autowired private DaoService daoService;
	@Autowired private DTOConverterService dtoConverterService;

	/**
	 * Retrieves all the applications defined in database.
	 * 
	 * @return
	 */
	public List<Application> getAllApplications() {
		if (logger.isDebugEnabled()) {
			logger.debug("Retrieve the applications from the database");
		}
		List<Application> allApps = daoService.getApplications();
		return allApps;
	}

	/**
	 * Retrieves all the applications defined in database as UIObject.
	 * 
	 * @return
	 */
	public List<UIApplication> getAllUIApplications() {
		if (logger.isDebugEnabled()) {
			logger.debug("Retrieves the applications from the database");
		}
		List<UIApplication> allUiApps = new ArrayList<UIApplication>();
		List<Application> allApps = daoService.getApplications();

		for (Application app : allApps) {
			UIApplication ui = dtoConverterService.convertToUI(app);
			allUiApps.add(ui);
		}
		return allUiApps;
	}

	public UIApplication getUIApplication(int id) {
		Application app = daoService.getApplicationById(id);
		return app == null ? null : dtoConverterService.convertToUI(app);
	}

	/**
	 * Returns the application with the specified id.
	 * 
	 * @param idStr
	 *            Identifier of the application
	 * @return the application
	 */
	public Application getApplicationById(final String idStr) {
		Application result = null;

		try {
			int id = Integer.parseInt(idStr);
			result = daoService.getApplicationById(id);
		} catch (NumberFormatException e) {
			logger.warn("L'identifiant d'une application doit etre un entier",
					e);
		}

		return result;
	}

	/**
	 * Adds the application in the database.
	 * 
	 * @param uiApp
	 */
	public void addApplication(final UIApplication uiApp) {
		logger.info("creating application " + uiApp.getName());
		Application app = dtoConverterService.convertFromUI(uiApp, true);
		daoService.addApplication(app);
	}

	/**
	 * Updates the application.
	 * 
	 * @param uiApplication
	 */
	public void updateApplication(final UIApplication uiApplication) {
		final Application app = dtoConverterService.convertFromUI(uiApplication, false);

		logger.info("modify application " + app.getId() + " " + app.getName());

		Application appPersistent = daoService.getApplicationById(app.getId());
		if (appPersistent == null) throw new NotFoundException("invalid application " + app.getId());
		appPersistent.setName(app.getName());
		appPersistent.setPassword(app.getPassword());
		appPersistent.setAcc(app.getAcc());
		appPersistent.setIns(app.getIns());
		appPersistent.setQuota(app.getQuota());

		daoService.updateApplication(appPersistent);
	}

	/**
	 * Deletes the application.
	 * 
	 * @param uiApplication
	 */
	public void deleteApplication(int id) {
		Application appPersistent = daoService.getApplicationById(id);
		logger.info("removing application " + id + " " + appPersistent.getName());
		daoService.deleteApplication(appPersistent);
	}
}
