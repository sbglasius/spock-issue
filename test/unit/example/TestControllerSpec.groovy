package example

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(TestController)
class TestControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        given:
        User mockUser = Mock()
        Set certificateSet = new HashSet<Certificate>()
        mockUser.certificates >> certificateSet
        UserService userSvc = Mock()
        controller.userService = userSvc
        userSvc.getCurrentUser() >> mockUser

        expect:
        controller.userService.currentUser.certificates.size() == 0
    }
}
