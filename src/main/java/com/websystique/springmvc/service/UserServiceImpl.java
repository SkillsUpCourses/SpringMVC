package com.websystique.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.model.UserDTO;
import com.websystique.springmvc.dao.UserDAO;
import com.websystique.springmvc.entity.User;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
    
    private static final AtomicLong counter = new AtomicLong();
	
       @Autowired
       UserDAO dao;
       
	public List<UserDTO> findAllUsers() {
            List<UserDTO> result = new ArrayList<UserDTO>();
            List<User> entities = dao.findAllUsers();
            UserDTO model = null;
            for (User entity: entities) {
                model = new UserDTO (entity);
                result.add(model);
            }
		return result;
	}
	
	public UserDTO findById(long id) {
	    return new UserDTO (dao.findById(id));
	}
	
	
	public long saveUser(UserDTO user) {
            //Long id = counter.incrementAndGet();
            User entity = new User(user);
            //entity.setId(id);
	    dao.saveUser(entity);
            //return id;
            return 1;
	}

	public void updateUser(UserDTO user) {
            dao.updateUser(new User(user));
		
	}

	public void deleteUserById(long id) {
	     dao.deleteUserById(id);
	}

	public boolean isUserExist(UserDTO user) {
		return dao.isUserExist(new User(user));
	}
	
	public void deleteAllUsers(){
		dao.deleteAllUsers();
	}

}
