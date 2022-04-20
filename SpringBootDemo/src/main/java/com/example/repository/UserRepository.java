package com.example.repository;


import com.example.model.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserTable,Long>
{
    @Query(value= "SELECT * FROM user_table",nativeQuery=true)
    List<UserTable> findAllByJQL();

    @Query(value="SELECT * FROM user_table a WHERE a.name=:uname",nativeQuery = true)
    UserTable findByUserNameByJql(@Param("uname")String userName);

    @Modifying
    @Query(value="insert into user_table (name,email,password,role) values(:uname,:uemail,:upass,:role) ",nativeQuery = true)
    void saveByJQL(String uname,String uemail,String upass,String role);
}
