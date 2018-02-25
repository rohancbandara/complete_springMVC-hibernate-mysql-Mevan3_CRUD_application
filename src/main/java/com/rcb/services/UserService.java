package com.rcb.services;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.rcb.constants.Constants;
import com.rcb.dtos.UserDTO;
import com.rcb.entities.User;
import com.rcb.repositories.UserRepository;
import com.rcb.utils.CommonValidation;
import com.rcb.utils.CustomizedResponse;

@Service
public class UserService {

	private static final Logger LOG = Logger.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public CustomizedResponse saveUpdateUser(UserDTO inputUser) {
		CustomizedResponse customizedResponse = new CustomizedResponse();
		User userSaved = null;
		try {
			if(inputUser != null) {
				userSaved = inputUser.getUserId() > -1 ? (User)findUserById(inputUser.getUserId()).getResponse():new User();
				
				List<String> errorStatus = inputParemeterValidation(inputUser);
				if(errorStatus.size() > 0){
					customizedResponse.setStatusList(errorStatus);
					customizedResponse.setSuccess(false);
					return customizedResponse;
				}
				
				userSaved.setUserName(inputUser.getUserName());
				userSaved.setPassword(inputUser.getPassword());
				userSaved.setEmail(inputUser.getEmail());
				userSaved.setFirstName(inputUser.getFirstName());
				userSaved.setLastName(inputUser.getLastName());	
				
				Long id = userRepository.save(userSaved);
				customizedResponse.setResponse((User)findUserById(id).getResponse());
				customizedResponse.setSuccess(true);
			}
		} catch (Exception e) {LOG.warn("Exception in saveUpdateUser() -> UserService :",e);}
		return customizedResponse;
	}
	
	public List<String> inputParemeterValidation (UserDTO inputUser) {
		
		List<String> errorStatus = new ArrayList<String>();
		
		if(StringUtils.isEmpty(inputUser.getFirstName())){errorStatus.add(Constants.EMPTY_FIRST_NAME);}
		if(StringUtils.isEmpty(inputUser.getLastName())){errorStatus.add(Constants.EMPTY_LAST_NAME);}
		if(StringUtils.isEmpty(inputUser.getEmail())){errorStatus.add(Constants.EMPTY_EMAIL_NAME);}
		if(StringUtils.isEmpty(inputUser.getPassword())){errorStatus.add(Constants.EMPTY_PASSWORD_NAME);}
		if(StringUtils.isEmpty(inputUser.getUserName())){errorStatus.add(Constants.EMPTY_USER_NAME);}

		if(!StringUtils.isEmpty(inputUser.getEmail())){
			CommonValidation commonValidation = new CommonValidation();
			if(!commonValidation.emailValidate(inputUser.getEmail())){
				errorStatus.add(Constants.INVALID_EMAIL);
			}
		}
		return errorStatus;
	}
	
	@Transactional
	public CustomizedResponse findUserById(Long userId){
		CustomizedResponse customizedResponse = new CustomizedResponse();
		try {
			User user = userRepository.findUserById(userId);
			customizedResponse.setResponse(user);
		} catch (Exception e) {	LOG.warn("Exception in findUserById() -> UserService :",e);}
		customizedResponse.setSuccess(true);
		return customizedResponse;
	}

	@Transactional
	public CustomizedResponse findUserByEmailAndPassword(String email, String password){
		CustomizedResponse customizedResponse = new CustomizedResponse();
		try {
			User user = userRepository.findUserByEmailAndPassword(email, password);
			customizedResponse.setResponse(user);
		} catch (Exception e) {	LOG.warn("Exception in findUserByEmailAndPassword() -> UserService :",e);}
		customizedResponse.setSuccess(true);
		return customizedResponse;
	}
	
	@Transactional
	public CustomizedResponse getAll() {
		CustomizedResponse customizedResponse = new CustomizedResponse();
		try {
			List<User> userList = userRepository.getAll();
			if(userList.size() > 0){
				customizedResponse.setResponse(userList);
				customizedResponse.setSuccess(true);
			}
		} catch (Exception e) {	LOG.warn("Exception in getAll() -> UserService :",e);}
		return customizedResponse;
	}
	
	@Transactional
	public CustomizedResponse deleteUserById(long userId) {
		CustomizedResponse customizedResponse = new CustomizedResponse();
		if(userId > -1) {
			User user = (User)findUserById(userId).getResponse();
			if(user !=null) {
				try {
					userRepository.deleteUser(user);
				} catch (Exception e) {LOG.warn("Exception in deleteUserById() -> UserService :",e);}
			}
			customizedResponse.setSuccess(true);
		}
		return customizedResponse;
	}

	@Transactional
	public CustomizedResponse login(UserDTO user) {
		CustomizedResponse customizedResponse = new CustomizedResponse();
		
		if(user== null) {return customizedResponse;}
		else if (StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getPassword())) {return customizedResponse;}
		
		String userId = user.getEmail();
		String password = user.getPassword();
		
		customizedResponse =  findUserByEmailAndPassword(userId, password);
		
		if((User) customizedResponse.getResponse() == null) {
			List<String> list = new ArrayList<String>();
			list.add(Constants.INVALID_LOGGIN);
			customizedResponse.setStatusList(list);
			customizedResponse.setSuccess(false);
		}
		return customizedResponse;
	}
	
}
