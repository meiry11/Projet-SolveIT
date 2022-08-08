// -#--------------------------------------
// -# ©Copyrigth Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.spring.component;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Classe qui sera executee une fois apres le demarrage du Spring. Elle sert a
 * valider les connections surtout a MySQL et surtout quand il est dockerise.
 * Parceque cette ... de MySQL demarre tres doucement dans Docker. Voir
 * https://hub.docker.com/_/mysql chapitre "No connections until MySQL init
 * completes".
 */
@Component
@Order(0)
@Profile("mysql")
public class MysqlForDockerNiceLoop implements ApplicationListener<ApplicationReadyEvent> {

	private static final Logger LOG = LogManager.getLogger();
	private static final int MAX_TRY = 20; // En general, il se reveille au bout de la 3ieme, 4ieme

	@Autowired
	private DataSource dataSource;
	@Autowired
	private Environment env;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {

		final var url = this.env.getProperty("spring.datasource.url");
		final var name = this.env.getProperty("spring.datasource.username");
		// Mal en terme de securite
		// final String pwd = this.env.getProperty("spring.datasource.password");

		MysqlForDockerNiceLoop.LOG.warn("---> On va attendre que MySQL dans docker se reveille ... {} {}", url, name);
		var nbTentatives = 0;
		while (true) {
			nbTentatives++;
			if (nbTentatives >= MysqlForDockerNiceLoop.MAX_TRY) {
				MysqlForDockerNiceLoop.LOG.fatal(
						"---> MySQL serveur n'est toujours pas valide, c'etait la {} et dernière tentative",
						nbTentatives);
				break;
			}
			try (var c = this.dataSource.getConnection();) {
				if (c.isValid(2)) {
					MysqlForDockerNiceLoop.LOG.debug("---> MySQL serveur est valide ... apres {} tentative(s)",
							nbTentatives);
					break;
				}
			} catch (Exception lExp) {
				MysqlForDockerNiceLoop.LOG.warn("---> MySQL serveur n'est toujours pas valide, c'est la {} tentatives",
						nbTentatives, lExp);
				try {
					Thread.sleep(2000);
				} catch (Exception lExp1) {
					// Pas normal
					MysqlForDockerNiceLoop.LOG.fatal("Sleep problem ...", lExp1);
					Thread.currentThread().interrupt();
				}
			}
		}
	}

}