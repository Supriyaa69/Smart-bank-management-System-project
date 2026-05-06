package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.entity.Account;
import com.entity.User;
@Repository
public interface AccountRepository extends JpaRepository <Account,Integer> {
	Account findByuser(User user);

}
