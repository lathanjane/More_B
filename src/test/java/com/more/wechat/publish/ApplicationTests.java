package com.more.wechat.publish;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.more.wechat.publish.survey.model.CustomerSurveyModel;
import com.more.wechat.publish.survey.service.CustomerSurveyService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class ApplicationTests {

	@Resource(name = CustomerSurveyService.BEAN_DEFAULT)
	CustomerSurveyService customerSurveyService;

	@Test
	@Rollback
	public void testUserMapper() throws Exception {
		CustomerSurveyModel t = new CustomerSurveyModel();

		customerSurveyService.saveCustomerSurvey(t);

	}
	// @Test
	// @Rollback
	// public void testUserMapper() throws Exception {
	// // insert一条数据，并select出来验证
	// userMapper.insert("AAA", 20);
	// User u = userMapper.findByName("AAA");
	// Assert.assertEquals(20, u.getAge().intValue());
	// // update一条数据，并select出来验证
	// u.setAge(30);
	// userMapper.update(u);
	// u = userMapper.findByName("AAA");
	// Assert.assertEquals(30, u.getAge().intValue());
	// // 删除这条数据，并select验证
	// userMapper.delete(u.getId());
	// u = userMapper.findByName("AAA");
	// Assert.assertEquals(null, u);
	//
	// u = new User("BBB", 30);
	// userMapper.insertByUser(u);
	// Assert.assertEquals(30,
	// userMapper.findByName("BBB").getAge().intValue());
	//
	// Map<String, Object> map = new HashMap<>();
	// map.put("name", "CCC");
	// map.put("age", 40);
	// userMapper.insertByMap(map);
	// Assert.assertEquals(40,
	// userMapper.findByName("CCC").getAge().intValue());
	//
	// List<User> userList = userMapper.findAll();
	// for(User user : userList) {
	// Assert.assertEquals(null, user.getId());
	// Assert.assertNotEquals(null, user.getName());
	// }
	//
	// }

}
