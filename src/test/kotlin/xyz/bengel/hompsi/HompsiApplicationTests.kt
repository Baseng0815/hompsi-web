package xyz.bengel.hompsi

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
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
	fun `registerUser`() {
		val uri = "http://localhost:8080/users/register"
		val result = mvc.perform(
			MockMvcRequestBuilders
				.post(uri)
				.contentType(MediaType.APPLICATION_JSON)
				.content("""{"realName": "Paul Dinkleburry",
						|"userName": "pburry",
						|"mailAddress": "paul192834513@gmail.com",
						|"password": "password123"}""".trimMargin())
		).andReturn()
		assertEquals(200, result.response.status)

		val user = Json.decodeFromString<Map<String, JsonPrimitive>>(result.response.contentAsString)
		assertEquals("\"Paul Dinkleburry\"", user["realName"].toString())
		assert(user["uid"] != null)
	}

	@Test
	fun `get all users`() {
		val uri = "http://localhost:8080/users/all"
		val result = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn()
		assertEquals(200, result.response.status)

		println(result.response.contentAsString)
		val users = Json.decodeFromString<JsonArray>(result.response.contentAsString)
		assert(users.size == 1)
		assertEquals("\"Paul Dinkleburry\"", users[0].jsonObject["realName"].toString())
	}
}
