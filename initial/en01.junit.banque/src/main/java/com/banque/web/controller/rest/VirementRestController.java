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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banque.entity.impl.OperationEntity;
import com.banque.service.IOperationService;
import com.banque.web.dto.out.OperationDtoOut;

/**
 * Realiser un virement entre deux comptes. <br>
 * URL en put uniquement : /virer?compteSrc=xxx&compteDest=Yyyy&montant=Zzzz
 * <br>
 */
@RestController
@RequestMapping("/virer")
public class VirementRestController extends AbstractRestController {
	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private IOperationService operationService;

	/**
	 * Realiser un virement entre deux comptes. <br>
	 * En put uniquement : /virer?compteSrc=xxx&compteDest= Yyyy&montant=Zzzz <br>
	 * Il faut etre connecte
	 *
	 * @param compteSrc  l'id du compte source
	 * @param compteDest id du compte destination
	 * @param montant    le montant
	 * @return la liste des operations en Json
	 */
	@PutMapping
	public ResponseEntity<?> virerPut(@RequestParam(name = "compteSrc") int compteSrc,
			@RequestParam(name = "compteDest") int compteDest, @RequestParam(name = "montant") double montant)
			throws Exception {
		var userId = super.getConnectedUserId();

		VirementRestController.LOG.info("virer RS (userId={}, compteSrc={}, compteDest={}, montant={})", userId,
				compteSrc, compteDest, montant);

		// TODO Faire usage du userId afin de verifier que les comptes lui appartiennent
		var operations = this.operationService.faireVirement(userId, compteSrc, compteDest, montant);
		List<OperationDtoOut> operationDtos = new ArrayList<>();
		for (OperationEntity operation : operations) {
			operationDtos.add(new OperationDtoOut(operation));
		}
		return ResponseEntity.ok(operationDtos);

	}
}
