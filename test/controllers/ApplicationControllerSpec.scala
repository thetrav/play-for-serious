package test.controllers

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._
import controllers._

import org.specs2.mock._
import org.mockito.Matchers

class ApplicationControllerSpec extends Specification with Mockito {
  "cake ApplicationController" should {
      "return OK with the results of the service invocation" in {
        val expectedMessage = "Test Message"
        val m = mock[(String) => play.api.templates.Html]

        object ApplicationControllerSpec extends ApplicationController {
          def indexMessage = expectedMessage
          def template = m
        }

        val response = ApplicationControllerSpec.index(FakeRequest())

        status(response) must equalTo(OK)
        there was one(m).apply(Matchers.eq("controller got:" + expectedMessage))
      }
  }
}

