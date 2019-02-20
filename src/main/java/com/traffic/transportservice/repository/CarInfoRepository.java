package com.traffic.transportservice.repository;

import com.traffic.transportservice.entity.CarInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CarInfoRepository extends JpaRepository<CarInfo, Integer> {

//    @Query(nativeQuery = true,value = "select balance from car_balance where car_id= :carId")
//    int findCarBalanceByCarId(@Param("carId") int carId);

    //通过小车id获取小车余额
    @Query(value = "SELECT balance FROM car_info WHERE car_id=?1", nativeQuery = true)
    String findCarBalanceByCarId(String carId);

    //设置小车Action(Start/Stop)，同时设置小车的速度
    @Transactional
    @Modifying
    @Query(value = "update car_info set car_action=?1,car_speed=?2 where car_id=?3", nativeQuery = true)
    Integer updateCarActionAndSpeed(String carAction, String carSpeed, String car_id);

    //设置小车充值
    @Transactional
    @Modifying
    @Query(value = "update car_info set balance=?1 where car_id=?2", nativeQuery = true)
    Integer updateCarBalance(String balance, String car_id);

    //查询小车速度
    @Query(value = "select car_speed from car_info where car_id=?1", nativeQuery = true)
    String getCarSpeed(String car_id);

    //通过身份证获取小车信息
    @Query(value = "select * from car_info where user_info_pcard_id=?1", nativeQuery = true)
    List<CarInfo> selectUserInfo(Long pcardId);

    //查询小车车牌号是否在数据库中
    @Query(value = "select * from car_info where carnumber=?1", nativeQuery = true)
    Integer selectcarnumber(String carnumber);
}
