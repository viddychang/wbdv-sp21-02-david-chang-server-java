(function (){

    var $usernameFld, $passwordFld;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $removeBtn, $editBtn, $createBtn;
    var $userRowTemplate, $tbody;
    var userService = new AdminUserServiceClient();

    var users = [
/*        {username: "alice123", password: "password1", firstName: "Alice", lastName: "Park", role: "Admin" },
        {username: "bob234", password: "password2", firstName: "Bob", lastName: "Costas", role: "Faculty" },
        {username: "charlie345", password: "password3", firstName: "Charlie", lastName: "Conway", role: "Student" },
        {username: "dan456", password: "password4", firstName: "Dan", lastName: "Orlovsky", role: "Student" }*/
    ];

    function createUser() {
        var newUser = {
            userName: $usernameFld.val(),
            password: $passwordFld.val(),
            firstName: $firstNameFld.val(),
            lastName: $lastNameFld.val(),
            role: $roleFld.val()
        }

        userService
            .createUser(newUser)
            .then(function(actualUser) {
                users.push(actualUser)
                renderUsers(users)
            })

        clearInputs()
    }

    function renderUsers(users) {
        console.log(users)
        $tbody.empty()
        for (var i=0; i < users.length; i++) {
            var user = users[i]
            $tbody
                .append(`
                    <tr class= "wbdv-user">
                        <td class="wbdv-username">${user.userName}</td>
                        <td>&nbsp;</td>
                        <td class="wbdv-first-name">${user.firstName}</td>
                        <td class="wbdv-last-name">${user.lastName}</td>
                        <td class="wbdv-role">${user.role}</td>
                        <td class="wbdv-actions">
                    <span class="pull-right">
                      <i id="${i}"class="fa-2x fa fa-times wbdv-remove"></i>
                      <i id="${user._id}" class="fa-2x fa fa-pencil wbdv-edit"></i>
                    </span>
                        </td>
                    </tr>
                `)

        }
        $removeBtn = $('.wbdv-remove')
        $removeBtn.click(deleteUser)

        $editBtn = $('.wbdv-edit')
        $editBtn.click(selectUser)

    }

    function deleteUser(event) {
        var button = $(event.target)
        var index = button.attr('id')
        var id = users[index]._id

        userService.deleteUser(id)
            .then(function (status) {
                users.splice(index, 1)
                renderUsers(users)
            })
    }

    var selectedUser = null
    function selectUser(event) {
        var id = $(event.target).attr('id')
        selectedUser = users.find(user => user._id === id)
        $usernameFld.val(selectedUser.userName)
        $passwordFld.val(selectedUser.password)
        $firstNameFld.val(selectedUser.firstName)
        $lastNameFld.val(selectedUser.lastName)
        $roleFld.val(selectedUser.role)
    }

    function updateUser() {
        selectedUser.userName = $usernameFld.val()
        selectedUser.password = $passwordFld.val()
        selectedUser.firstName = $firstNameFld.val()
        selectedUser.lastName = $lastNameFld.val()
        selectedUser.role = $roleFld.val()

        userService.updateUser(selectedUser._id, selectedUser)
            .then(status => {
                var index = users.findIndex(user => user._id === selectedUser._id)
                users[index] = selectedUser
                renderUsers(users)
            })

        clearInputs()
    }

    // helper function for clearing the input form after an action
    function clearInputs() {
        $usernameFld.val('')
        $passwordFld.val('')
        $firstNameFld.val('')
        $lastNameFld.val('')
        $roleFld.val('FACULTY')
    }


    function main() {
        $tbody = jQuery('.wbdv-tbody')

        $editBtn = $('.wbdv-update')
        $createBtn = $('.wbdv-create')

        $usernameFld = $('#usernameFld')
        $passwordFld = $('#passwordFld')
        $firstNameFld = $('#firstNameFld')
        $lastNameFld = $('#lastNameFld')
        $roleFld = $('#roleFld')

        $createBtn.click(createUser)
        $editBtn.click(updateUser)


        userService
            .findAllUsers()
            .then(function(actualUsers) {
                users = actualUsers
                renderUsers(users)
            })
    }


    $(main);



})();

