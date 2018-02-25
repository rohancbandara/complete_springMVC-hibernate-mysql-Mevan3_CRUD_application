package com.rcb.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.rcb.constants.Constants;
import com.rcb.dtos.DocterDTO;
import com.rcb.entities.Docter;
import com.rcb.repositories.DocterRepository;
import com.rcb.utils.CommonValidation;
import com.rcb.utils.CustomizedResponse;

@Service
public class DocterService {
	private static final Logger LOG = Logger.getLogger(DocterService.class);
	@Autowired
	private DocterRepository docterRepository;

	@Transactional
	public CustomizedResponse saveUpdateDocter(DocterDTO inputDocter) {
		CustomizedResponse customizedResponse = new CustomizedResponse();
		Docter docterSaved = null;
		try {
			if (inputDocter != null) {
				docterSaved = inputDocter.getdId() > -1 ? (Docter) findDocterById(inputDocter.getdId()).getResponse()
						: new Docter();
				List<String> errorStatus = inputParemeterValidation(inputDocter);
				if (errorStatus.size() > 0) {
					customizedResponse.setStatusList(errorStatus);
					customizedResponse.setSuccess(true);
					return customizedResponse;
				}
				docterSaved.setDemail(inputDocter.getDemail());
				docterSaved.setDfirstName(inputDocter.getDfirstName());
				docterSaved.setDlastName(inputDocter.getDlastName());

				Long id = docterRepository.save(docterSaved);
				customizedResponse.setResponse(findDocterById(id).getResponse());
				customizedResponse.setSuccess(true);

			}

		} catch (Exception e) {
			LOG.warn("Exception in saveUpdateDocter() -> DocterService :" + e);
		}

		return customizedResponse;
	}

	public List<String> inputParemeterValidation(DocterDTO inputDocter) {
		List<String> errorStatus = new ArrayList<String>();
		if (StringUtils.isEmpty(inputDocter.getDemail())) {
			errorStatus.add(Constants.EMPTY_EMAIL_NAME);
		}
		if (StringUtils.isEmpty(inputDocter.getDfirstName())) {
			errorStatus.add(Constants.EMPTY_FIRST_NAME);
		}
		if (StringUtils.isEmpty(inputDocter.getDlastName())) {
			errorStatus.add(Constants.EMPTY_LAST_NAME);
		}
		if (!StringUtils.isEmpty(inputDocter.getDemail())) {
			CommonValidation commonValidation = new CommonValidation();
			if (!commonValidation.emailValidate(inputDocter.getDemail())) {
				errorStatus.add(Constants.INVALID_EMAIL);
			}
		}
		return errorStatus;
	}

	@Transactional
	public CustomizedResponse findDocterById(Long dId) {
		CustomizedResponse customizedResponse = new CustomizedResponse();
		try {
			Docter docter = docterRepository.findDocterById(dId);
			customizedResponse.setResponse(docter);
		} catch (Exception e) {
			LOG.warn("Exception in findDocterById() -> DocterService ", e);
			customizedResponse.setSuccess(true);
		}
		return customizedResponse;
	}

	@Transactional
	public CustomizedResponse getAll() {
		CustomizedResponse customizedResponse = new CustomizedResponse();
		try {
			List<Docter> docterList = docterRepository.getAll();
			if (docterList.size() > 0) {
				customizedResponse.setResponse(docterList);
				customizedResponse.setSuccess(true);
			}

		} catch (Exception e) {
			LOG.warn("Exception in getAll() -> DocterService", e);
		}
		return customizedResponse;

	}

	@Transactional
	public CustomizedResponse deleteDocterById(Long dId) {
		CustomizedResponse customizedResponse = new CustomizedResponse();
		if (dId > -1) {
			Docter docter = (Docter) findDocterById(dId).getResponse();
			if (docter != null) {
				try {
					docterRepository.deleteDocter(docter);
				} catch (Exception e) {
					LOG.warn("Exception in deleteDocterById() -> DocterService", e);
				}
			}
		}
		return customizedResponse;
	}

}
