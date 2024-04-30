@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

@template.layout.page(
content = @`
    <form action="${NamedRoutes.loginPath()}" method="post">
        <input type="text" placeholder="Name" name="name" />
        <input type="password" placeholder="Password" name="password" />
        <input type="submit" />
        @if(page != null)
             ${page.getError()}
        @endif
    </form>
`
)


