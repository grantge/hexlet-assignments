@import gg.jte.Content
@param Content content

<html lang="en">
  <head>
    <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
      <meta charset="UTF-8">
      <!-- Material Design CSS -->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <title>Hello Hexlet!</title>
    </head>
    <body>
        <div class="mx-auto p-4 py-md-5">
        <main>
          ${content}
        </main>
        </div>
        <!-- Material Design JS and jQuery (optional, required for Material Design components) -->
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    </body>
</html>
