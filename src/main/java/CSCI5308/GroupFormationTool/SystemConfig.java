package CSCI5308.GroupFormationTool;

import CSCI5308.GroupFormationTool.DBUtil.DefaultDatabaseConfiguration;
import CSCI5308.GroupFormationTool.DBUtil.IDatabaseConfiguration;

public class SystemConfig {

	private static SystemConfig uniqueInstance = null;
	private IDatabaseConfiguration databaseConfiguration;

	private SystemConfig() {
		databaseConfiguration = new DefaultDatabaseConfiguration();
	}

	public static SystemConfig instance() {
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