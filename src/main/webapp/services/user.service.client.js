function AdminUserServiceClient() {

    this.findAllUsers = findAllUsers;
    this.createUser = createUser;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'https://wbdv-generic-server.herokuapp.com/api/001045850/users';
    var self = this;


    // POST - Create
    function createUser(user) {
        return fetch(self.url, {
            method: 'POST',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function(response){
            return response.json();
        })
    }

    // GET - Read
    function findAllUsers() {
        return fetch(self.url)
            .then(function(response){
                return response.json();
        })
    }

    // GET user by id
    function findUserById(userId) {
        return fetch(`${self.url}/${userId}`).then(function(response) {
            return response.json();
        })
    }

    // PUT update user by id
    function updateUser(userId, user) {
        return fetch(`${self.url}/${userId}`, {
            method: 'PUT',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => response.json())
    }

    // DELETE user by id
    function deleteUser(userId) {
        return fetch(`${self.url}/${userId}`, {
            method: 'DELETE'
        })
            .then(function(response) {
                return response.json()
        })
    }
}