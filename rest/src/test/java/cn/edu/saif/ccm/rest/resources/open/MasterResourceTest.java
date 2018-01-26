package cn.edu.saif.ccm.rest.resources.open;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import cn.edu.saif.shared.config.AppConfig;
import cn.edu.saif.ccm.rest.config.WebMvcConfigTest;

@ContextConfiguration(classes = { WebMvcConfigTest.class, AppConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ActiveProfiles("dev")
public class MasterResourceTest {
	private final String urlPrefix = "/api/v1/open/master/";

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
//		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
//				.build();
	}

	// 获取基础数据代码
	@Test
	public void testGetMasterCode() throws Exception {
//		mockMvc.perform(
//				get(urlPrefix + "getMasterCode/S009").contentType(
//						MediaType.APPLICATION_JSON)).andDo(print())
//				.andExpect(status().isOk());
	}
}
