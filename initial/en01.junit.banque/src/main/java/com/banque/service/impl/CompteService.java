// -#--------------------------------------
// -# ©Copyrigth Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banque.dao.ICompteDAO;
import com.banque.entity.impl.CompteEntity;
import com.banque.service.ICompteService;
import com.banque.service.ex.AucunDroitException;
import com.banque.service.ex.EntityIntrouvableException;

/**
 * Gestion des comptes.
 */
@Service
public class CompteService extends AbstractService implements ICompteService {
	private static final Logger LOG = LogManager.getLogger();
	@Autowired
	private ICompteDAO compteDao;

	/**
	 * Recupere la propriete <i>compteDao</i>.
	 *
	 * @return the compteDao la valeur de la propriete.
	 */
	protected ICompteDAO getCompteDao() {
		return this.compteDao;
	}

	@Override
	@Transactional(readOnly = true)
	public CompteEntity select(int unUtilisateurId, int unCompteId) throws Exception {
		CompteService.LOG.debug("select compte uId={} cpId={}", unUtilisateurId, unCompteId);
		if (unUtilisateurId < 0) {
			throw new IllegalArgumentException("utilisateurId<0");
		}
		if (unCompteId < 0) {
			throw new IllegalArgumentException("compteId<0");
		}
		var resultat = this.getCompteDao().findById(unCompteId);
		if (!resultat.isPresent()) {
			throw new EntityIntrouvableException();
		}

		if (unUtilisateurId != resultat.get().getUtilisateur().getId().intValue()) {
			throw new AucunDroitException();
		}
		CompteService.LOG.debug("select compte resultat={}", resultat.get());
		return resultat.get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<CompteEntity> selectAll(int unUtilisateurId) throws Exception {
		CompteService.LOG.debug("selectAll compte uId={}", unUtilisateurId);
		if (unUtilisateurId < 0) {
			throw new IllegalArgumentException("utilisateurId<0");
		}
		var resultat = this.getCompteDao().findByUtilisateurIdOrderByLibelleAsc(unUtilisateurId);
		if (resultat.isPresent()) {
			CompteService.LOG.debug("selectAll compte trouve {} compte(s)", resultat.get().size());
			return resultat.get();
		}
		CompteService.LOG.debug("selectAll compte n'a rien trouve");
		return new ArrayList<>();

	}
}
