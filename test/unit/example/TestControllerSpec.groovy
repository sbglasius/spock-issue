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

    void "groovier test"() {
        given:
            User mockUser = Mock()
            HashSet<Certificate> certificateSet = []
            mockUser.certificates >> certificateSet
            controller.userService = Mock(UserService)
            controller.userService.currentUser >> mockUser

        expect:
            controller.userService.currentUser.certificates.size() == 0

    }

    void "from janet"() {
        given:
        User mockUser = Mock()
            Set certificateSet = new HashSet<Certificate>()
            certificateSet.add(new Certificate(null))
            certificateSet.add(new Certificate(null))
            mockUser.certificates >> certificateSet
            UserService userSvc = Mock()
            controller.userService = userSvc
            userSvc.getCurrentUser() >> mockUser
        when:
            def returnMap = controller.list()
        then:
            returnMap.size() > 0
    }

}
