@import gg.jte.Content
@param Content content

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Header and Footer Example</title>
    <!-- Link to Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<!-- Header -->
<header class="bg-dark text-white py-4">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1>My Website</h1>
            </div>
            <a href="/">Main Page</a>
            <a href="/users">Users</a>
            <div class="col-md-6 text-right">
                <nav>
                    <a href="#" class="text-white">Home</a>
                    <a href="#" class="text-white ml-3">About</a>
                    <a href="#" class="text-white ml-3">Contact</a>
                </nav>
            </div>
        </div>
    </div>
</header>



<!-- Main Content Area -->
    <div class="content">
         ${content}
    </div>


<!-- Footer -->
<footer class="bg-dark text-white py-3">

    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <p>&copy; 2024 My Website</p>
            </div>
            <div class="col-md-6 text-right">
                <p>Designed with <i class="fa fa-heart text-danger"></i> by Me</p>
            </div>
        </div>
    </div>
</footer>
<!-- Link to Bootstrap JS (Optional, for certain components) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
