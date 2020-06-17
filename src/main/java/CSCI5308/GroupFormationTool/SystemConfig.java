package CSCI5308.GroupFormationTool;

import CSCI5308.GroupFormationTool.DBConnection.DefaultDatabaseConfiguration;
import CSCI5308.GroupFormationTool.DBConnection.IDatabaseConfiguration;

/*
 * This is a singleton, we will learn about these when we learn design patterns.
 * 
 * The single responsibility of this singleton is to store concrete classes
 * selected by the system for use in the rest of the system. This will allow
 * a form of dependency injection in places where we cannot use normal
 * dependency injection (for example classes that override or extend existing
 * library classes in the framework).
 */
public class SystemConfig {
	private static SystemConfig uniqueInstance = null;

	private IDatabaseConfiguration databaseConfiguration;

	// This private constructor ensures that no class other than System can allocate
	// the System object. The compiler would prevent it.
	private SystemConfig() {
		// The default instantiations are the choices that would be used in the
		// production application. These choices can all be overridden by test
		// setup logic when necessary.
		databaseConfiguration = new DefaultDatabaseConfiguration();
	}

	// This is the way the rest of the application gets access to the System object.
	public static SystemConfig instance() {
		// Using lazy initialization, this is the one and only place that the System
		// object will be instantiated.
		if (null == uniqueInstance) {
			uniqueInstance = new SystemConfig();
		}
		return uniqueInstance;
	}

	public IDatabaseConfiguration getDatabaseConfiguration() {
		return databaseConfiguration;
	}

	public void setDatabaseConfiguration(IDatabaseConfiguration databaseConfiguration) {
		this.databaseConfiguration = databaseConfiguration;
	}
}
