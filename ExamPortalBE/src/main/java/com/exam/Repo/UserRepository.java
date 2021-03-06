package com.exam.Repo;

import org.springframework.data.jpa.repository.*;

import com.exam.BALModel.UserBALModel;
import com.exam.models.*;

public interface UserRepository extends JpaRepository<User,Long>{
public User findByUsername(String username);

@Query(value="select * from users u where u.username=?1 and u.password=?2",nativeQuery=true)
public User findUserByUsernameAndPassword(String username,String Password);



}
