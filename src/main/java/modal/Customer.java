package modal;

public class Customer {
    private final String email;
    private final String password;
    private final String repeatPassword;
    private final String securityQuestion;
    private final String ans;

    public Customer(CustomerBuilder customerBuilder) {
        this.email = customerBuilder.email;
        this.password = customerBuilder.password;
        this.repeatPassword = customerBuilder.repeatPassword;
        this.securityQuestion = customerBuilder.securityQuestion;
        this.ans = customerBuilder.ans;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public String getAns() {
        return ans;
    }

    public static class CustomerBuilder {
        private String email;
        private String password;
        private String repeatPassword;
        private String securityQuestion;
        private String ans;

        public CustomerBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public CustomerBuilder setPassword(String pass) {
            this.password = pass;
            this.repeatPassword = pass;
            return this;
        }

        public CustomerBuilder setSecurityQuestion(String securityQuestion) {
            this.securityQuestion = securityQuestion;
            return this;
        }

        public CustomerBuilder setAns(String ans) {
            this.ans = ans;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
