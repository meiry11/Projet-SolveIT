// -#--------------------------------------
// -# ©Copyright Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.web.controller.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banque.entity.impl.OperationEntity;
import com.banque.service.IOperationService;
import com.banque.web.dto.out.OperationDtoOut;

/**
 * Gestion du listage des operations en rest. <br>
 * URL en get :
 * /operations/search/{compteId}?dateDebut=yyyy/MM/dd&dateFin=yyyy/MM/dd&credit=1
 * <br>
 * Il faut être authentifie
 */
@RestController
@RequestMapping("/operations")
public class OperationsRestController extends AbstractRestController {
	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	private IOperationService operationService;

	/**
	 * Liste les operations d'un compte de l'utilisateur connecte. <br>
	 * En get :
	 * /operations/search/{compteId}?dateDebut=yyyy/MM/dd&dateFin=yyyy/MM/dd&credit=1
	 * <br>
	 * il faut etre authentifie.
	 *
	 * @param compteId  l'id du compte
	 * @param dateDebut la date de debut au format 2016/25/12
	 * @param dateFin   la date de fin au format 2016/25/12
	 * @param credit    indique si c'est un credit ou un debit ou les deux
	 *                  <ul>
	 *                  <li>1 = credit</li>
	 *                  <li>0 = debit</li>
	 *                  <li>2 = credit & debit</li>
	 *                  </ul>
	 * @return la liste des operations
	 */
	@GetMapping("/search/{compteId}")
	public ResponseEntity<?> listerOperations(@PathVariable(name = "compteId") int compteId,
			@RequestParam(name = "dateDebut", required = false) String dateDebut,
			@RequestParam(name = "dateFin", required = false) String dateFin,
			@RequestParam(name = "credit", required = false, defaultValue = "2") String credit) throws Exception {
		OperationsRestController.LOG.info("listage des operations compteId={}, dateDebut={}, dateFin={}, credit={} )",
				compteId, dateDebut, dateFin, credit);
		var userId = super.getConnectedUserId();

		// TODO Verifier si l'id du compte appartient bien a la personne connectee

		OperationsRestController.LOG.info("listage des operations pour l'utilisateur userId={}", userId);

		final var pattern = "yyyy/MM/dd";
		var creditInt = -1;
		try {
			creditInt = Integer.parseInt(credit);
		} catch (Exception e) {
			OperationsRestController.LOG.warn("Valeur pour credit invalide ({})", credit, e);
			creditInt = -1;
		}
		LocalDate dateD = null;
		LocalDate dateF = null;
		try {
			if (dateDebut != null) {
				dateD = LocalDate.parse(dateDebut, DateTimeFormatter.ofPattern(pattern));
			}
		} catch (Exception e) {
			OperationsRestController.LOG.warn("Date de debut invalide ({})", dateDebut, e);
		}
		try {
			if (dateFin != null) {
				dateF = LocalDate.parse(dateFin, DateTimeFormatter.ofPattern(pattern));
			}
		} catch (Exception e) {
			OperationsRestController.LOG.warn("Date de fin invalide ({})", dateFin, e);
		}

		var operations = this.operationService.selectCritere(userId, compteId, dateD, dateF, creditInt == 1,
				creditInt == 0);
		OperationsRestController.LOG.debug(
				"listage des operations - trouve {} nb operations pour le user {} et le compte {}",
				Integer.valueOf(operations.size()), userId, compteId);
		List<OperationDtoOut> operationDtos = new ArrayList<>();
		for (OperationEntity operation : operations) {
			operationDtos.add(new OperationDtoOut(operation));
		}
		return ResponseEntity.ok(operationDtos);
	}
}
