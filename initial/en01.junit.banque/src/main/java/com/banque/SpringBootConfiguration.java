// -#--------------------------------------
// -# ©Copyrigth Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringBootConfiguration extends SpringBootServletInitializer {
	private static final Logger LOG = LogManager.getLogger();

	protected static final String SPRING_KEY_DRIVER = "spring.datasource.driver-class-name";

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootConfiguration.class);
	}

	public static void main(String[] args) {
		SpringBootConfiguration.LOG.info("-- Starting Banque Project - Using Spring Security -- ");
		var springApplication = new SpringApplication(SpringBootConfiguration.class);
		var context = springApplication.run(args);
		var insideEnv = context.getBean(Environment.class);
		if (SpringBootConfiguration.usingH2(insideEnv)) {
			SpringBootConfiguration.LOG.info("-- Using H2 in memory DBMS so:");
			SpringBootConfiguration.LOG.info(
					"--  + Data base will be created at startup with some data (see data.sql script in src/main/resources directory)");
			SpringBootConfiguration.LOG.info("--  + H2 console is availabe at http://localhost:{}{}{}",
					insideEnv.getProperty("server.port", "8080"),
					insideEnv.getProperty("server.servlet.context-path", "/"),
					insideEnv.getProperty("spring.h2.console.path", ""));
			var h2Url = insideEnv.getProperty("spring.datasource.url", "NotFound!");
			if (h2Url.contains(";DB_CLOSE_ON_EXIT=FALSE")) {
				h2Url = h2Url.replace(";DB_CLOSE_ON_EXIT=FALSE", "");
			}
			SpringBootConfiguration.LOG.info("--  + H2 console please use {} as JDBC URL", h2Url);
			SpringBootConfiguration.LOG.info("--  + All information added will be lost at shutdown");
		} else if (SpringBootConfiguration.usingMySQL(insideEnv)) {
			SpringBootConfiguration.LOG.info("-- Using MySQL DBMS, do not forget to verify that");
			SpringBootConfiguration.LOG.info("--  + DBMS was started");
			SpringBootConfiguration.LOG.info(
					"--  + You started the application with the right login/password (using --spring.datasource.username=yourlogin --spring.datasource.password=yourpwd)");
			SpringBootConfiguration.LOG
					.info("--  + You have created and loaded the banque data base (see dump file in /db directory)");
		} else {
			SpringBootConfiguration.LOG.info(
					"-- Strange, you will be using DBMS {}, did you spell mysql or h2 properly?",
					insideEnv.getProperty(SpringBootConfiguration.SPRING_KEY_DRIVER, ""));
		}
		SpringBootConfiguration.LOG.info(
				"-- Project Banque is up - Root is at http://localhost:{}{}/swagger-ui/index.html for documentation, but GO read code from classes in com.banque.web.controller.rest -- ",
				insideEnv.getProperty("server.port", "8080"),
				insideEnv.getProperty("server.servlet.context-path", "/"));
		// Swagger : http://localhost:8080/banque/swagger-ui/index.html
	}

	/**
	 * Indicates if we are using H2 DBMS.
	 *
	 * @param pEnv environment
	 * @return true if we are using H2 DBMS
	 */
	public static final boolean usingH2(Environment pEnv) {
		return pEnv.getProperty(SpringBootConfiguration.SPRING_KEY_DRIVER, "").contains("h2");
	}

	/**
	 * Indicates if we are using MySQL DBMS.
	 *
	 * @param pEnv environment
	 * @return true if we are using MySQL DBMS
	 */
	public static final boolean usingMySQL(Environment pEnv) {
		return pEnv.getProperty(SpringBootConfiguration.SPRING_KEY_DRIVER, "").contains("mysql");
	}

}
