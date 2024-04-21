@import exercise.dto.posts.PostsPage
@param PostsPage page


@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <table class="table table-dark">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Post Name</th>
                    <th scope="col">Post Body</th>
                </tr>
                </thead>
                @for(var post : page.getPosts())
                    <tbody>
                    <tr>
                        <th><a href="posts/${post.getId()}">${post.getId()}</a></th>
                        <td>${post.getName()}</td>
                        <td>${post.getBody()}</td>
                    </tr>
                    </tbody>
                @endfor
                <nav aria-label="Page navigation example">
                    <ul class="pagination">
                        <li class="page-item">
                            <a class="page-link" href="" aria-label="Previous" rel="prev">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li class="page-item"><a class="page-link" href="posts?page=1">1</a></li>
                        <li class="page-item"><a class="page-link" href="posts?page=2">2</a></li>
                        <li class="page-item"><a class="page-link" href="posts?page=3">3</a></li>
                        <li class="page-item"><a class="page-link" href="posts?page=4">4</a></li>
                        <li class="page-item"><a class="page-link" href="posts?page=5">5</a></li>
                        <li class="page-item"><a class="page-link" href="posts?page=6">6</a></li>
                        <li class="page-item">
                            <a class="page-link" href="" aria-label="Next" rel="next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </table>
        </main>
    </div>


`
)
