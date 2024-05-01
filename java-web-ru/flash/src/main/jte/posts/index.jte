@import exercise.dto.posts.PostsPage
@param PostsPage page

<!-- BEGIN -->
@template.layout.page(
page = page,
content = @`
    <div class="alert alert-success" role="alert">
        ${page.getFlash()}
    </div>

    <div class="mx-auto p-4 py-md-5">
        <main>
            <table class="table table-dark">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Content</th>
                </tr>
                </thead>
                @for(var post : page.getPosts())
                    <tbody>
                    <tr>
<%--                        <th><a href="${user.getId()}">${user.getId()}</a></th>--%>
<%--                        <td>${user.getFirstName()} ${user.getLastName()}</td>--%>
                        <td>${post.getName()}</td>
                        <td>${post.getBody()}</td>
                    </tr>
                    </tbody>
                @endfor
            </table>
        </main>
    </div>
`


)