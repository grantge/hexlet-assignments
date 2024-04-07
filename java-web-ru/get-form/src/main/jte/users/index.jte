@import exercise.dto.users.UsersPage
@param exercise.dto.users.UsersPage page


@template.layout.page(content = @`
<!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Material Design Search Input Example</title>
        <!-- Material Design CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    </head>
    <body>
    <div class="container">
        <h2>Search Example</h2>
        <!-- Search input -->
        <form>
            <div class="input-field">
                <input type="search" id="searchInput" class="validate" name="term" value="${page.getTerm()}">
                <input type="submit" value="Search" />
                <label for="searchInput">Search</label>
            </div>
        </form>


        <!-- Display search results here -->
        <div id="searchResults">
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


        </div>
    </div>
`)




