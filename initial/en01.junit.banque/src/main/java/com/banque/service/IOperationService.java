// -#--------------------------------------
// -# ©Copyrigth Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.service;

import java.time.LocalDate;
import java.util.List;

import com.banque.entity.impl.OperationEntity;

/**
 * Service des operations.
 */
public interface IOperationService {

	/**
	 * Recupere une operation.
	 *
	 * @param unUtilisateurId un id d'utilisateur
	 * @param unCompteId      un id de compte
	 * @param uneOperationId  un id d'operation
	 *
	 * @return l'operation trouvee
	 * @throws Exception si un probleme metier survient
	 */
	public abstract OperationEntity select(int unUtilisateurId, int unCompteId, int uneOperationId) throws Exception;

	/**
	 * Recupere toutes les operations d'un compte.
	 *
	 * @param unUtilisateurId un id d'utilisateur
	 * @param unCompteId      un id de compte
	 *
	 * @return les operations trouvees, une liste vide si aucunne.
	 * @throws Exception si un probleme metier survient
	 */
	public abstract List<OperationEntity> selectAll(int unUtilisateurId, int unCompteId) throws Exception;

	/**
	 * Recupere toutes les operations respectant les criteres donnees.
	 *
	 * @param unUtilisateurId un id d'utilisateur
	 * @param unCompteId      un id de compte
	 * @param unDebut         une date de debut
	 * @param uneFin          une date de fin
	 * @param pCredit         si vrai remonte les credit
	 * @param pDebit          si vrai remmonte les debits
	 *
	 * @return les operations trouvees, une liste vide si aucunne.
	 * @throws Exception si un probleme metier survient
	 */
	public abstract List<OperationEntity> selectCritere(int unUtilisateurId, int unCompteId, LocalDate unDebut,
			LocalDate uneFin, boolean pCredit, boolean pDebit) throws Exception;

	/**
	 * Fait un virement entre deux comptes.
	 *
	 * @param unUtilisateurId un id d'utilisateur
	 * @param unCompteIdSrc   compte source
	 * @param unCompteIdDst   compte destination
	 * @param unMontant       la somme +/-
	 *
	 * @return les deux operations crees par le virement
	 * @throws Exception si un probleme metier survient
	 */
	public abstract List<OperationEntity> faireVirement(int unUtilisateurId, int unCompteIdSrc, int unCompteIdDst,
			double unMontant) throws Exception;

}
