@param exercise.dto.users.UserPage page

@template.layout.page(
    content = @`
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">First Name</th>
        <th scope="col">Last Name</th>
        <th scope="col">Email</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">${page.getUser().getId()}</th>
        <td>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</td>
        <td>${page.getUser().getLastName()}</td>
        <td>${page.getUser().getEmail()}</td>
    </tr>
    </tbody>
</table>
`)
