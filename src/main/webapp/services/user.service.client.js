function UserService() {

    this.findAllUsers = findAllUsers

    function findAllUsers() {
        return fetch('http://localhost:8080/users')
            .then(function(response){
                return response.json()
            })
    }


}