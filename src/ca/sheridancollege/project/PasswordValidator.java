package ca.sheridancollege.project;

public class PasswordValidator {

    /**
     *
     * @param pass
     */
    public Boolean checkLength(String pass) {
        // TODO - implement PasswordValidator.checkLength
        if (pass.length() >= 8) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param pass
     */
    public Boolean checkStrong(String pass) {
        // TODO - implement PasswordValidator.checkStrong
        throw new UnsupportedOperationException();
    }

}
