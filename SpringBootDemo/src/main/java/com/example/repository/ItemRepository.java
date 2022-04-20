package com.example.repository;


import com.example.model.ItemTable;
import com.example.model.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<ItemTable,Long>
{
    @Query(value= "SELECT * FROM item_table",nativeQuery=true)
    List<ItemTable> findAllByJQL();

    @Modifying
    @Query(value="insert into item_table(tracking_id,name,source,destination,location,order_date,estimated_date,user_name)values(:tracking_id,:iname,:source,:destination,:location,:orderDate,:estimatedDate,:user_id)",nativeQuery = true)
    void saveByJQL(String iname, String tracking_id, String source, String destination, String location, Date orderDate, Date estimatedDate,String user_id);

    @Query(value="SELECT * FROM item_table a WHERE a.tracking_id=:trackid",nativeQuery = true)
    ItemTable findByTrackidByJql(String trackid);

    @Modifying
    @Query(value="UPDATE item_table set location=:location WHERE tracking_id=:trackid",nativeQuery = true)
    void updateLocationByTrackId(String trackid, String location);

//    @Query(value="SELECT * FROM item_table a WHERE a.tracking_id=:uname",nativeQuery = true)
//    UserTable findByUserNameByJql(@Param("uname")String userName);
//
}