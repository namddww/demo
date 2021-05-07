package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.UserProfile;

@Mapper
public interface UserProfileMapper {
	
	@Select("SELECT * FROM UserProfile WHERE id=${id}")
	UserProfile getUserProfile(@Param("id") String id);
	
	@Select("SELECT * FROM UserProfile")
	List<UserProfile> getUserProfileList();//
	//$를 #으로 바꿔야 함!!
	@Insert("INSERT INTO UserProfile VALUES(#{id}, #{name}, #{phone}, #{address})")
	int insertUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone,
			@Param("address") String address);
	// int : SQL문에 의해서 적용되고(영향을 받은) 레코드의 갯수가 반환됨
	// 이 결과값을 가지고 정상적으로 insert, update, delete가 됐는지 확인할 수 있음!!
	
	@Update("UPDATE UserProfile SET name=#{name}, phone=#{phone}, address=#{address} WHERE id=#{id}")
	int updateUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone,
			@Param("address") String address);
	
	@Delete("DELEDT UserProfile WHERE id=#{id}")
	int deleteUserProfile(@Param("id") String id);
}
