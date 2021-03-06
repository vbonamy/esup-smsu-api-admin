/**
 * SMS-U - Copyright (c) 2009-2014 Universite Paris 1 Pantheon-Sorbonne
 */
package org.esupportail.smsuapiadmin.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.esupportail.smsuapi.dao.beans.Account;
import org.esupportail.smsuapi.dao.beans.Application;
import org.esupportail.smsuapi.dao.beans.Institution;
import org.esupportail.smsuapiadmin.dao.beans.Role;
import org.esupportail.smsuapi.dao.beans.Sms;
import org.esupportail.smsuapi.dao.beans.Statistic;
import org.esupportail.smsuapiadmin.dao.beans.UserBoSmsu;


/**
 * The DAO service interface.
 */
public interface DaoService extends Serializable {

	// ////////////////////////////////////////////////////////////
	// User
	// ////////////////////////////////////////////////////////////

	/**
	 * @param id
	 * @return the User instance that corresponds to an id.
	 */
	UserBoSmsu getUserById(Integer id);

	/**
	 * @return the list of all the users.
	 */
	List<UserBoSmsu> getUsers();

	/**
	 * Add a user.
	 * 
	 * @param user
	 */
	void addUser(UserBoSmsu user);

	/**
	 * Delete a user.
	 * 
	 * @param user
	 */
	void deleteUser(UserBoSmsu user);

	/**
	 * Update a user.
	 * 
	 * @param user
	 */
	void updateUser(UserBoSmsu user);

	/**
	 * Returns all the applications.
	 * 
	 * @return list containing all the applications
	 */
	List<Application> getApplications();

	/**
	 * 
	 * @param app
	 */
	void updateApplication(Application app);

	/**
	 * 
	 * @param app
	 */
	void deleteApplication(Application app);

	/**
	 * 
	 * @param app
	 */
	void addApplication(Application app);

	/**
	 * 
	 * @param name
	 * @return
	 */
	Account getAccountByName(String name);

	/**
	 * 
	 * @param name
	 * @return
	 */
	Institution getInstitutionByName(String name);

	/**
	 * 
	 * @param account
	 */
	void addAccount(Account account);

	/**
	 * 
	 * @param institution
	 */
	void addInstitution(Institution institution);

	/**
	 * Returns the persistent application identified by 'id'.
	 * 
	 * @param id
	 * @return
	 */
	Application getApplicationById(int id);

	Application getApplicationByName(String name);
	
	/**
	 * Returns all the SMS's that reference the application.
	 * 
	 * @param app
	 * @return
	 */
	List<Sms> getSMSByApplication(Application app);

	/**
	 * Returns all the Statistics that reference the application.
	 * 
	 * @param app
	 * @return
	 */
	List<Statistic> getStatisticByApplication(Application app);

	/**
	 * Returns all the accounts.
	 * 
	 * @return list containing all the accounts
	 */
	List<Account> getAccounts();

	/**
	 * Updates the account.
	 * 
	 * @param account
	 */
	void updateAccount(Account account);

	/**
	 * Returns all the institutions.
	 * 
	 * @return list containing all the institutions
	 */
	List<Institution> getInstitutions();

	/**
	 * Returns all the statistics.
	 * 
	 * @return list containing all the statistics
	 */
	List<Statistic> getStatistics();

	/**
	 * Returns the persistent institution identified by 'id'.
	 * 
	 * @param id
	 * @return
	 */
	Institution getInstitutionById(int id);

	/**
	 * Returns the persistent account identified by 'id'.
	 * 
	 * @param id
	 * @return
	 */
	Account getAccountById(int id);

	/**
	 * Searches statistics corresponding to criterias.
	 * 
	 * @param institution
	 * @param account
	 * @param application
	 * @param month
	 * @return
	 */
	List<Statistic> getStatisticsSorted();

	/**
	 * Returns all the sms.
	 * 
	 * @return list containing all the sms
	 */
	List<Sms> getSms();

	Sms getSmsById(Integer id);

	List<Map<String,?>> getSmsAccountsAndApplications();
	
	/**
	 * Returns identifiers of all sms' group matching criterias.
	 * 
	 * @param inst
	 * @param acc
	 * @param app
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<Sms> searchGroupSmsWithNullInitialId(Institution inst, Account acc,
			Application app, Date startDate, Date endDate, int maxResults);

	List<List<?>> searchGroupSmsWithInitialId(Institution inst, Account acc,
			Application app, Date startDate, Date endDate, int maxResults);

	/**
	 * Returns the role with the specified name.
	 * 
	 * @param name
	 * @return
	 */
	Role getRoleByName(String name);

	/**
	 * Returns the user with the specified login.
	 * 
	 * @param login
	 * @return
	 */
	UserBoSmsu getUserByLogin(String login);

	/**
	 * Returns a list containing all the roles.
	 * 
	 * @return
	 */
	List<Role> getRoles();

	List<Sms> getSmsByApplicationAndInitialId(Application application,
			Integer smsInitialId);

}
