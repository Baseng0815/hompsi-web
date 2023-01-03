package xyz.bengel.hompsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

@SpringBootTest
@AutoConfigureMockMvc
//@ActiveProfiles("test")
class HompsiApplicationTests @Autowired constructor(val mvc: MockMvc) {
	@Test
	fun contextLoads() {

	}

	@Test
	fun `get all registered users`() {
		val uri = "/users/all"

		val result = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn()
		println(result.response.contentAsString)
		assertEquals(200, result.response.status)
	}
}
