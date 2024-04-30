@import exercise.util.NamedRoutes
@import exercise.dto.MainPage
@param MainPage page

@template.layout.page(
content = @`
    <h1>Привет, Хекслет!</h1>
    @if(page.getName() != null)
        Добро пожаловать, ${page.getName().toString()}.

        <form action="${NamedRoutes.logoutPath()}" method="post" name="OUT">
            <button type="submit">OUT</button>
        </form>
    @endif


    @if(page.getName() == null)
        <a href="${NamedRoutes.buildSessionPath()}" >IN</a>
    @endif
`
)
