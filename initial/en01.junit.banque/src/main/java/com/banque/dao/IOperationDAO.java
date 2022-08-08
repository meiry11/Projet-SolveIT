// -#--------------------------------------
// -# ©Copyright Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.banque.entity.impl.OperationEntity;

/**
 * Interface representant l'operation DAO en utilisant Spring Data avec JPA.
 */
@Repository
public interface IOperationDAO extends PagingAndSortingRepository<OperationEntity, Integer> {

	public static final Logger LOG = LogManager.getLogger();

	/**
	 * Selectionne les operations en fonction des criteres donnes. Attention ! Aucun
	 * des paramètres ne peut être null.
	 *
	 * @param unCompteId  un compte id
	 * @param unDebut     une date de debut
	 * @param uneFin      une date de fin
	 * @param pMontantMin un montant minimum
	 * @param pMontantMax un montant maximum
	 *
	 * @return la liste des opertaions repondant aux criteres
	 *
	 */
	public abstract Optional<List<OperationEntity>> findByCompteIdAndDateOpBetweenAndMontantBetween(Integer unCompteId,
			LocalDate unDebut, LocalDate uneFin, BigDecimal pMontantMin, BigDecimal pMontantMax);

	/**
	 * Selectionne les operations en fonction des criteres donnes.
	 *
	 * @param unCompteId un compte id. Ne peut pas etre null.
	 * @param unDebut    une date de debut. Si null, prend maintenant - 10 ans.
	 * @param uneFin     une date de fin. Si null, prend maintenant.
	 * @param pCredit    si true prend les montants &gt; 0
	 * @param pDebit     si true prend les montants &lt; 0
	 *
	 * @return la liste des opertaions repondant aux criteres
	 *
	 */
	public default Optional<List<OperationEntity>> selectCriteria(Integer unCompteId, LocalDate unDebut,
			LocalDate uneFin, boolean pCredit, boolean pDebit) {
		if (unCompteId == null) {
			throw new IllegalArgumentException("L'id du compte ne peut pas etre null!");
		}
		// JPA n'aime pas les null dans le cas qui nous interesse
		if (uneFin == null) {
			uneFin = IOperationDAO.getDefaultEndDate();
			IOperationDAO.LOG.info("--  selectCritere avec dateFin calculee={}", uneFin);
		}
		if (unDebut == null) {
			unDebut = IOperationDAO.getDefaultStartDate(uneFin);
			IOperationDAO.LOG.info("--  selectCritere avec dateDebut calculee={}", unDebut);
		}
		Optional<List<OperationEntity>> resultat;
		if (pCredit == pDebit) {
			resultat = this.findByCompteIdAndDateOpBetweenAndMontantBetween(unCompteId, unDebut,
					uneFin, BigDecimal.valueOf(-Double.MAX_VALUE), BigDecimal.valueOf(Double.MAX_VALUE));
		} else if (pCredit) {
			resultat = this.findByCompteIdAndDateOpBetweenAndMontantBetween(unCompteId, unDebut,
					uneFin, BigDecimal.valueOf(0D), BigDecimal.valueOf(Double.MAX_VALUE));
		} else {
			resultat = this.findByCompteIdAndDateOpBetweenAndMontantBetween(unCompteId, unDebut,
					uneFin, BigDecimal.valueOf(-Double.MAX_VALUE), BigDecimal.valueOf(0D));
		}
		return resultat;
	}

	/**
	 * Calcule une date de fin.
	 *
	 * @return la date de fin (maintenant)
	 */
	public static LocalDate getDefaultEndDate() {
		// FIXME En Java 9+, on prendrait une visibilité private pour cette méthode
		return LocalDate.now();
	}

	/**
	 * Calcule une date de debut a partir d'une date de fin.
	 *
	 * @param uneFin la date de fin
	 * @return une date de debut (dateFin - 10 ans)
	 */
	public static LocalDate getDefaultStartDate(LocalDate uneFin) {
		// FIXME En Java 9+, on prendrait une visibilité private pour cette méthode
		return uneFin.minusYears(10);
	}

	/**
	 * Selectionne toutes les operations qui appartiennent a un compte.
	 *
	 * @param aCptId un id de compte
	 * @return toutes les operations d'un compte
	 */
	// @Query("FROM OperationEntity op where op.compte.id = :aCptId order by
	// op.dateOp DESC")
	public Optional<List<OperationEntity>> findByCompteIdOrderByDateOpDesc(int aCptId);
}
