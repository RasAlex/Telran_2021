package telran.user.model;

public class User {
    private String email;
    private String password;


    public User(String email, String password) {
        setEmail(email);
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (validateEmail(email)) {
            this.email = email;
        } else {
            System.out.println(email + " is not valid");
        }

    }
    /*
    1) @ exists and only one
    2) '.' after @
    3) after last "." min 2 symbols
    4) ABC, digits, '-', '_', '.', '@'
     */

    private boolean validateEmail(String email) {
        int at = email.indexOf('@');
        if (at == -1 || email.lastIndexOf('@') != at) {
            return false;
        }
        if (email.indexOf('.', at) == -1) {
            return false;
        }
        if (email.length() - email.lastIndexOf('.') <= 2) {
            return false;
        }
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (!(Character.isDigit(c) || Character.isAlphabetic(c) || c == '@' || c == '.' || c == '_')) {
                return false;
            }

        }
        return true;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (validatePassword(password)) {
            this.password = password;
        } else {
            System.out.println("password incorrect");
        }
    }

    /*
     * 1) length >= 8
     * 2) min one char in uppercase
     * 3) min one char in lowercase
     * 4) min one char is digit
     * 5) min one char is special symbol (!, &, %, *, #, $)
     */
    private boolean validatePassword(String password) {
//        boolean[] res = new boolean[5];
//        if (password.length() >= 8) {
//            res[0] = true;
//        }
//        for (int i = 0; i < password.length(); i++) {
//            char c = password.charAt(i);
//            if (Character.isUpperCase(c)) {
//                res[1] = true;
//            }
//            if (Character.isLowerCase(c)) {
//                res[2] = true;
//            }
//            if (Character.isDigit(c)) {
//                res[3] = true;
//            }
//            if (isSpecialSymbol(c)) {
//                res[4] = true;
//            }
//        }
//
//        for (int i = 0; i < res.length; i++) {
//                if (!res[i]) {
//                    return false;
//                }
//            }
//            return true;
        return passwordCode(password) == 31;
        }

private boolean isSpecialSymbol ( char c){
    return "!&%*#$".indexOf(c) >= 0;
        }

private byte passwordCode(String password){
        byte res = 0;
    if (password.length() >= 8) {
        res |= 1 ; // res = res | 1;
    }
    for (int i = 0; i < password.length(); i++) {
        char c = password.charAt(i);
        if (Character.isUpperCase(c)) {
            res |= 2;
        }
        if (Character.isLowerCase(c)) {
            res |= 4;
        }
        if (Character.isDigit(c)) {
            res |= 8;
        }
        if (isSpecialSymbol(c)) {
            res |= 16;
        }
    }
    return res;
}
        @Override
        public String toString () {
            return "User [email = " + email + ", password='" + password + ']';
        }
    }

