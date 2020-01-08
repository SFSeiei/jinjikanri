package com.jinjikanri;

import static org.mockito.Mockito.never;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jinjikanri.entity.SYST01UserEntity;
import com.jinjikanri.entity.SYST06CharEntity;
import com.jinjikanri.mapper.CharMapper;
import com.jinjikanri.service.CharService;
import com.jinjikanri.service.LoginService;
import com.jinjikanri.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JinjikanriApplicationTests {

	@Autowired
	private LoginService LoginService;

	@Autowired
	private UserService userService;

	@Autowired
	private CharService charService;

	@Autowired
	private CharMapper charMapper;

//	@Test
//	public void contextLoads() throws UserNameIsHaveException {
//		SYST01UserEntity user = new SYST01UserEntity();
//		user.setUsrCd(4);
//
//		userService.updateUserPassword(user.getUsrCd(), "005", "a005");
//	}

//	@Test
//	public void test2() throws UserNameIsHaveException {
//		SYST01UserEntity user = new SYST01UserEntity();
//		user.setUsrCd(4);
//		List<Integer> charList = new ArrayList<>();
//		charList.add(1);
//		charList.add(2);
//		charList.add(5);
//		charList.add(6);
//		userService.updateUser(user, charList);
//	}

//	@Test
//	public void deleteCharBatchTest() {
//		//初始化数组并赋值.
//		Integer[] charCds = new Integer[] {4,5};
////		charCds[2] = 6;
//		boolean flag = this.charMapper.deleteCharBatch(charCds);
//		// flag == true
//		System.out.println(flag);
//	}
//	@Test
//	public void saveCharTest() {
//		SYST06CharEntity charEntity = new SYST06CharEntity();
//		charEntity.setCharMei("123321");
//		this.charMapper.saveChar(charEntity);
//		System.out.print("+++++++++++++++++++++" + charEntity.getCharCd());
//	}
	@Test
	public void savaUserTest() throws Exception{
		SYST01UserEntity userEntity = new SYST01UserEntity();
		userEntity.setUsrId("admin");
		userEntity.setPasswd("admin");
		List<Integer> charCdList = new ArrayList<>();
		charCdList.add(1);
		this.userService.saveUser(userEntity, charCdList);
	}

}
