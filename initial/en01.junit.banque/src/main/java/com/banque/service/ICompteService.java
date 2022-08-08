// -#--------------------------------------
// -# ©Copyrigth Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.service;

import java.util.List;

import com.banque.entity.impl.CompteEntity;

/**
 * Represente un service qui va gerer les comptes.
 */
public interface ICompteService {

	/**
	 * Recupere un compte.
	 *
	 * @param unUtilisateurId un id d'utilisateur
	 * @param unCompteId      un id de compte
	 * @return le compte trouve
	 * @throws Exception si un probleme metier survient
	 */
	public abstract CompteEntity select(int unUtilisateurId, int unCompteId) throws Exception;

	/**
	 * Recupere tous les comptes d'un utilisateur.
	 *
	 * @param unUtilisateurId un id d'utilisateur
	 * @return les comptes trouves, une liste vide si aucun
	 * @throws Exception si un probleme metier survient
	 */
	public abstract List<CompteEntity> selectAll(int unUtilisateurId) throws Exception;

}
