(function () {
    var userService = new UserService();
    var rowTemplate;
    var tbody;

    jQuery(main);

    function main() {
        rowTemplate = jQuery('.wbdv-template');
        tbody = jQuery('tbody');
        userService
            .findAllUsers()
            .then(renderUsers)
    }

    function renderUsers(users) {
        for(var u in users) {
            const user = users[u]
            const rowClone = rowTemplate.clone();
            rowClone.removeClass('wbdv-hidden');
            rowClone.find('.wbdv-username').html(user.username);
            rowClone.find('.wbdv-first-name').html(user.firstName);
            rowClone.find('.wbdv-last-name').html(user.lastName);

            tbody.append(rowClone);
        }
    }
})();
