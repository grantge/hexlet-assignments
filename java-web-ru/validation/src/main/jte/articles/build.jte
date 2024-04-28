@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
content = @`
    <form action="/articles" method="post">
        <div>
            <label>Title</label>
            <input type="text" name="title" value="@if(page.getErrors() != null)${page.getTitle()} @endif">
            @if(page.getErrors() != null)
                @if (page.getErrors().get("title") != null)
                    <div>
                        ${page.getErrors().get("title").get(0).getMessage()}
                    </div>
                @endif
            @endif
        </div>

        <div>
            <label for="validationServer03" class="form-label">Content</label>
            <input type="text" name="content" class="form-control" value="@if(page.getErrors() != null)${page.getContent()} @endif">
            @if(page.getErrors() != null)
                @if (page.getErrors().get("content") != null)
                    <div>
                        <p>${page.getErrors().get("content").get(0).getMessage()}</p>
                    </div>
                @endif
            @endif
        </div>
        <div class="col-12">
            <button class="btn btn-primary" type="submit">Submit form</button>
        </div>
    </form>
`
)
