package iut.sae.Model;

public enum Role {
    ROLE_USER {
        @Override
        public String toString() {
            return "ROLE_USER";
        }
    },
    ROLE_ADMIN {
        @Override
        public String toString() {
            return "ROLE_ADMIN";
        }
    }
}