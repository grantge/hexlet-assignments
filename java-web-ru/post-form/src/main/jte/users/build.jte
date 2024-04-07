


@template.layout.page(content = @`
    <div class="container">
        <h2>Material Design Form Example</h2>
        <form action="/users" method="post">
            <!-- First Name input -->
            <div class="input-field">
                <input type="text" id="firstName" name="firstName" class="validate">
                <label for="firstName">First Name</label>
            </div>

            <!-- Last Name input -->
            <div class="input-field">
                <input type="text" id="lastName" name="lastName" class="validate">
                <label for="lastName">Last Name</label>
            </div>

            <!-- Email input -->
            <div class="input-field">
                <input type="email" id="email" name="email" class="validate">
                <label for="email">Email</label>
            </div>

            <!-- Password input -->
            <div class="input-field">
                <input type="password" id="password" name="password" class="validate">
                <label for="password">Password</label>
            </div>

            <!-- Button -->
            <button class="btn waves-effect waves-light" type="submit" name="action">Submit</button>
        </form>
    </div>
`)