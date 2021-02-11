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
            username: $usernameFld.val(),
            password: $passwordFld.val(),
            firstname: $firstNameFld.val(),
            lastname: $lastNameFld.val(),
            role: $roleFld.val()
        }

        $usernameFld.val('')
        $passwordFld.val('')
        $firstNameFld.val('')
        $lastNameFld.val('')
        $roleFld.val('')

        userService
            .createUser(newUser)
            .then(function(actualUser) {
                users.push(actualUser)
                renderUsers(users)
            })
    }

    function renderUsers(users) {
        console.log(users)
        $tbody.empty()
        for (var i=0; i < users.length; i++) {
            var user = users[i]
            $tbody
                .append(`
                    <tr class= "wbdv-user">
                        <td class="wbdv-username">${user.username}</td>
                        <td>&nbsp;</td>
                        <td class="wbdv-first-name">${user.firstname}</td>
                        <td class="wbdv-last-name">${user.lastname}</td>
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




    function main() {
        $tbody = jQuery('.wbdv-tbody')
        $removeBtn = $('.wbdv-remove')
        $editBtn = $('.wbdv-update')
        $createBtn = $('.wbdv-create')

        $usernameFld = $('#usernameFld')
        $passwordFld = $('#passwordFld')
        $firstNameFld = $('#firstNameFld')
        $lastNameFld = $('#lastNameFld')
        $roleFld = $('#roleFld')

        $createBtn.click(createUser)

        userService
            .findAllUsers()
            .then(function(actualUsers) {
                users = actualUsers
                renderUsers(users)
            })
    }


    $(main);



})();

