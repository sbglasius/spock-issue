package example

class TestController {
    def userService

    def index() {
        def currentUser = userService.currentUser

        if(!currentUser.certificates) {

        }
    }
}
