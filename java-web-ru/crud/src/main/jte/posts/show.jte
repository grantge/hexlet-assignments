@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes;
@param PostPage page


@template.layout.page(
content = @`
    <h1>${page.getPost().getName()}</h1>
    <h2>${page.getPost().getBody()}</h2>
    <a href="${NamedRoutes.postsPath()}">Все посты</a>
`
)
