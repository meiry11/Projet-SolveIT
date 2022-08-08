// -#--------------------------------------
// -# ©Copyright Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.banque.entity.impl.CompteEntity;

/**
 * Compte DAO en utilisant Spring Data avec JPA. <br>
 * Pas besoin de code, juste les requetes en JPA.
 */
@Repository
public interface ICompteDAO extends PagingAndSortingRepository<CompteEntity, Integer> {
	/**
	 * Selectionne tous les comptes qui appartiennent a un utilisateur.
	 *
	 * @param aUserId un utilisateur id
	 * @return tous les comptes de l'utilisateur
	 */
	// @Query("FROM CompteEntity cpt where cpt.utilisateur.id = :aUserId order by
	// cpt.libelle asc")
	public Optional<List<CompteEntity>> findByUtilisateurIdOrderByLibelleAsc(int aUserId);
}
