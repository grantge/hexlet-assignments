@param exercise.dto.users.UsersPage page

@template.layout.page(
    content= @`
<div class="mx-auto p-4 py-md-5">
    <main>
        <table class="table table-dark">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Email</th>
            </tr>
            </thead>
            @for(var user : page.getUsers())
                <tbody>
                <tr>
                    <th><a href="${user.getId()}">${user.getId()}</a></th>
                    <td>${user.getFirstName()} ${user.getLastName()}</td>
                    <td>${user.getLastName()}</td>
                    <td>${user.getEmail()}</td>
                </tr>
                </tbody>
            @endfor
        </table>
    </main>
</div>
`)



