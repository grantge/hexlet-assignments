@import exercise.dto.users.UsersPage
@param exercise.dto.users.UsersPage page

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Hello Hexlet!</title>
</head>
<body style="background-color: #797373">
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
                    <td>${user.getFirstName()}</td>
                    <td>${user.getLastName()}</td>
                    <td>${user.getEmail()}</td>
                </tr>
                </tbody>
        @endfor
        </table>
    </main>
</div>
</body>
</html>



