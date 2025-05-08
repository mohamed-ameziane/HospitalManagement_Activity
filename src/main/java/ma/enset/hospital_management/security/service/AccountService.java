package ma.enset.hospital_management.security.service;

import ma.enset.hospital_management.security.entities.AppRole;
import ma.enset.hospital_management.security.entities.AppUser;

public interface AccountService {
    AppUser addNewUser(String username, String password, String confirmPassword, String email);
    AppRole addNewRole(String role);
    void affectRole(String username, String role);
    void removeRole(String username, String role);
    AppUser loadUserByUsername(String username);

}
