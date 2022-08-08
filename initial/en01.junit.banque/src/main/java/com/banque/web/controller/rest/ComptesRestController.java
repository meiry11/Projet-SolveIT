// -#--------------------------------------
// -# ©Copyright Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.web.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banque.entity.impl.CompteEntity;
import com.banque.service.ICompteService;
import com.banque.web.dto.out.CompteDtoOut;

/**
 * Gestion du listage des comptes en rest. URL : /comptes/search Il faut être
 * authentifier.
 */
@RestController
@RequestMapping("/comptes")
public class ComptesRestController extends AbstractRestController {
	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private ICompteService compteService;

	/**
	 * Liste les comptes de l'utilisateur connecte. <br>
	 * En put/pots/get : /comptes/search/userId <br>
	 *
	 * @param userId le user id
	 * @return la liste des comptes de l'utilisateur connecte
	 */
	@GetMapping("/search")
	public ResponseEntity<?> listerCompte() throws Exception {
		ComptesRestController.LOG.info("listage des comptes");
		var userId = super.getConnectedUserId();
		ComptesRestController.LOG.info("listage des comptes pour utilisateur {}", userId);

		var comptes = this.compteService.selectAll(userId);
		ComptesRestController.LOG.debug("listage des comptes - trouve {} nb comptes pour {}",
				Integer.valueOf(comptes.size()), userId);
		List<CompteDtoOut> compteDtos = new ArrayList<>();
		for (CompteEntity compte : comptes) {
			compteDtos.add(new CompteDtoOut(compte));
		}
		return ResponseEntity.ok(compteDtos);
	}
}
