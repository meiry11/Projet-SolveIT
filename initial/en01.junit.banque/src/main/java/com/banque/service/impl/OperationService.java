// -#--------------------------------------
// -# ©Copyrigth Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banque.dao.ICompteDAO;
import com.banque.dao.IOperationDAO;
import com.banque.entity.impl.OperationEntity;
import com.banque.service.IOperationService;
import com.banque.service.ex.AucunDroitException;
import com.banque.service.ex.DecouvertException;
import com.banque.service.ex.EntityIntrouvableException;

/**
 * Gestion des operations.
 */
@Service
public class OperationService extends AbstractService implements IOperationService {
	private static final Logger LOG = LogManager.getLogger();
	@Autowired
	private IOperationDAO operationDao;
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

	/**
	 * Recupere la propriete <i>operationDao</i>.
	 *
	 * @return the operationDao la valeur de la propriete.
	 */
	protected IOperationDAO getOperationDao() {
		return this.operationDao;
	}

	@Override
	@Transactional(readOnly = true)
	public OperationEntity select(int unUtilisateurId, int unCompteId, int uneOperationId) throws Exception {
		OperationService.LOG.debug("select operation uId={} cpId={} opId={}", unUtilisateurId, unCompteId,
				uneOperationId);

		if (unUtilisateurId < 0) {
			throw new IllegalArgumentException("utilisateurId<0");
		}
		if (unCompteId < 0) {
			throw new IllegalArgumentException("compteId<0");
		}
		if (uneOperationId < 0) {
			throw new IllegalArgumentException("operationId<0");
		}

		// On verifie que le compte appartient bien a l'utilisateur
		var compte = this.getCompteDao().findById(unCompteId);
		if (!compte.isPresent()) {
			throw new EntityIntrouvableException();
		}
		if (unUtilisateurId != compte.get().getUtilisateur().getId().intValue()) {
			throw new AucunDroitException();
		}

		var resultat = this.getOperationDao().findById(uneOperationId);
		if (!resultat.isPresent()) {
			throw new EntityIntrouvableException();
		}
		if (unCompteId != resultat.get().getCompte().getId().intValue()) {
			throw new AucunDroitException();
		}
		OperationService.LOG.debug("select operation resultat={}", resultat.get());

		return resultat.get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<OperationEntity> selectAll(int unUtilisateurId, int unCompteId) throws Exception {
		OperationService.LOG.debug("selectAll operation uId={} cpId={}", unUtilisateurId, unCompteId);

		if (unUtilisateurId < 0) {
			throw new IllegalArgumentException("utilisateurId<0");
		}
		if (unCompteId < 0) {
			throw new IllegalArgumentException("compteId<0");
		}

		var compte = this.getCompteDao().findById(unCompteId);
		if (!compte.isPresent()) {
			throw new EntityIntrouvableException();
		}
		if (unUtilisateurId != compte.get().getUtilisateur().getId().intValue()) {
			throw new AucunDroitException();
		}

		var resultat = this.getOperationDao().findByCompteIdOrderByDateOpDesc(unCompteId);
		if (resultat.isPresent()) {
			OperationService.LOG.debug("selectAll trouve {} operation(s)", resultat.get().size());
			return resultat.get();
		}
		OperationService.LOG.debug("selectAll n'a rien trouve");
		return new ArrayList<>();
	}

	@Override
	@Transactional(readOnly = true)
	public List<OperationEntity> selectCritere(int unUtilisateurId, int unCompteId, LocalDate unDebut, LocalDate uneFin,
			boolean pCredit, boolean pDebit) throws Exception {
		OperationService.LOG.debug("selectCritere operation uId={} cpId={} debut={} fin={} credit={} debit={}",
				unUtilisateurId, unCompteId, unDebut, uneFin, pCredit, pDebit);

		if (unUtilisateurId < 0) {
			throw new IllegalArgumentException("utilisateurId<0");
		}
		if (unCompteId < 0) {
			throw new IllegalArgumentException("compteId<0");
		}

		var resultat = this.getOperationDao().selectCriteria(unCompteId, unDebut, uneFin, pCredit, pDebit);
		if (resultat.isPresent()) {
			OperationService.LOG.debug("selectCritere trouve {} operation(s)", resultat.get().size());
			return resultat.get();
		}
		OperationService.LOG.debug("selectCritere n'a rien trouve");
		return new ArrayList<>();

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public synchronized List<OperationEntity> faireVirement(int unUtilisateurId, int unCompteIdSrc, int unCompteIdDst,
			double unMontant) throws Exception {
		OperationService.LOG.debug("faireVirement uId={} cpIdSrc={} cpIdDest={}", unUtilisateurId, unCompteIdSrc,
				unCompteIdDst);

		if (unUtilisateurId < 0) {
			throw new IllegalArgumentException("utilisateurId<0");
		}
		if (unCompteIdSrc < 0) {
			throw new IllegalArgumentException("compteIdSrc<0");
		}
		if (unCompteIdDst < 0) {
			throw new IllegalArgumentException("compteIdDst<0");
		}
		if (unMontant < 0) {
			throw new IllegalArgumentException("montant<0");
		}
		if (unCompteIdSrc == unCompteIdDst) {
			throw new IllegalArgumentException("unCompteIdSrc==compteIdDst");
		}

		List<OperationEntity> resultat = new ArrayList<>(2);
		OperationEntity opSrc = null;
		OperationEntity opDst = null;

		var compteSrc = this.getCompteDao().findById(unCompteIdSrc);
		if (!compteSrc.isPresent()) {
			throw new EntityIntrouvableException();
		}
		if (unUtilisateurId != compteSrc.get().getUtilisateur().getId().intValue()) {
			throw new AucunDroitException();
		}
		var compteDst = this.getCompteDao().findById(unCompteIdDst);
		if (!compteDst.isPresent()) {
			throw new EntityIntrouvableException();
		}
		if (unUtilisateurId != compteDst.get().getUtilisateur().getId().intValue()) {
			throw new AucunDroitException();
		}

		var montant = unMontant;
		// Simulation
		var soldeSrc = compteSrc.get().getSolde().doubleValue();
		final var decouvertSrc = compteSrc.get().getDecouvert() != null ? compteSrc.get().getDecouvert().doubleValue()
				: Double.MIN_VALUE;
		var soldeDst = compteDst.get().getSolde().doubleValue();
		final var decouvertDst = compteDst.get().getDecouvert() != null ? compteDst.get().getDecouvert().doubleValue()
				: Double.MIN_VALUE;

		// On retire de la source
		soldeSrc -= montant;
		// On ajoute a destination
		soldeDst += montant;
		// On regarde si les decouverts suivent
		if (soldeSrc <= decouvertSrc || soldeDst <= decouvertDst) {
			throw new DecouvertException();
		}

		var nowT = LocalTime.now();
		var nowD = LocalDate.now();
		opSrc = new OperationEntity();
		opSrc.setCompte(compteSrc.get());
		opSrc.setDateOp(nowD);
		opSrc.setHeureOp(nowT);
		opSrc.setMontant(BigDecimal.valueOf(-montant));
		opSrc.setLibelle("Transaction avec le compte " + unCompteIdDst);

		opDst = new OperationEntity();
		opDst.setCompte(compteDst.get());
		opDst.setDateOp(nowD);
		opDst.setHeureOp(nowT);
		opDst.setMontant(BigDecimal.valueOf(unMontant));
		opDst.setLibelle("Transaction avec le compte " + unCompteIdSrc);

		opSrc = this.getOperationDao().save(opSrc);
		opDst = this.getOperationDao().save(opDst);
		// Code de validation du transactionnel
		// if (true) {
		// throw new FonctionnelleException("Exemple de plantage pour le
		// transactionnel");
		// }
		compteSrc.get().setSolde(BigDecimal.valueOf(soldeSrc));
		compteDst.get().setSolde(BigDecimal.valueOf(soldeDst));
		this.getCompteDao().save(compteSrc.get());
		this.getCompteDao().save(compteDst.get());

		resultat.add(opSrc);
		resultat.add(opDst);
		return resultat;
	}
}
