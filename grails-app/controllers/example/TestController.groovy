package example

class TestController {
    def userService

    def index() {
        def currentUser = userService.currentUser

        if(!currentUser.certificates) {

        }
    }

    def list() {
        def currentUser = userService.getCurrentUser()
        if (!currentUser.certificates) {
            redirect uri: '/'
            return
        }
        [email: "some@email.com", publications: []]
    }
}
