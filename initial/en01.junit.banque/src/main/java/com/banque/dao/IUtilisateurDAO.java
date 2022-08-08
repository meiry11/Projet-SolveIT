// -#--------------------------------------
// -# ©Copyright Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.banque.entity.impl.UtilisateurEntity;

/**
 * Interface representant l'utilisateur en utilisant Spring Data avec JPA. <br>
 * Pas besoin de code, juste les requetes en JPA.
 */
@Repository
public interface IUtilisateurDAO extends PagingAndSortingRepository<UtilisateurEntity, Integer> {

	/**
	 * Selectionne le premier utilisateur ayant l'email indique.
	 *
	 * @param pEmail un email.
	 * @return l'utilisateur
	 */
	public abstract Optional<UtilisateurEntity> findByEmail(String pEmail);

}
