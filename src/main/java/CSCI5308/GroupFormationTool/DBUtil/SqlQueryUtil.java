package CSCI5308.GroupFormationTool.DBUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SqlQueryUtil {

	private static SqlQueryUtil instance;
	private static Properties queryProps;
	private static String queryPropFile;
	private static InputStream queryPropsFileStream;
	private Logger logger = LogManager.getLogger(SqlQueryUtil.class);

	private SqlQueryUtil() {
		loadAllQueries();
	}

	public static SqlQueryUtil instance() {
		if (null == instance) {
			instance = new SqlQueryUtil();
		}
		return instance;
	}

	private void loadAllQueries() {
		try {
			queryProps = new Properties();
			queryPropFile = "application.sql.properties";
			queryPropsFileStream = getClass().getClassLoader().getResourceAsStream(queryPropFile);
			queryProps.load(queryPropsFileStream);
			logger.info("Application queries loaded successfully.");
		} catch (IOException e) {
			logger.error("Exception occurred while sql loading properties file: ", e);
		}
	}

	public String getQueryByKey(String queryKey) {
		return queryProps.getProperty(queryKey);
	}
}