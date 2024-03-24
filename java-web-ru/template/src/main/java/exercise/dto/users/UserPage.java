package exercise.dto.users;

import exercise.model.User;

public class UserPage {

        private final User user;

        public User getUser() {
                return user;
        }

        public UserPage(User user) {
            this.user = user;
    }
}
