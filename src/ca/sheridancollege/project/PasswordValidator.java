package ca.sheridancollege.project;
/*
*
*/

public class PasswordValidator {

    /**
     *The purpose of the class is to validate the password from the user input
     *Password must have the 8 character length
     *Password must contain at least one uppercase,one lower case,
     *at least one number and one special character
     *@modifiers: Fausto Correa, Kamaksh Dave, Ruchita Soni, Alpa Gandhi
     *Date: 19 August 2021
     * @param pass
     */
    
    /*
    *This method check the length of the password
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
    
     /*
    *This method check the strength of the password
    */
    public Boolean checkStrong(String pass) {
        // TODO - implement PasswordValidator.checkStrong
        throw new UnsupportedOperationException();
    }

}
