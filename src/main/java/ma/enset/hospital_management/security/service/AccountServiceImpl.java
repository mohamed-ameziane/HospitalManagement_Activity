package ma.enset.hospital_management.security.service;

import jakarta.transaction.Transactional;
import ma.enset.hospital_management.security.entities.AppRole;
import ma.enset.hospital_management.security.entities.AppUser;
import ma.enset.hospital_management.security.repo.AppRoleRepository;
import ma.enset.hospital_management.security.repo.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private AppRoleRepository appRoleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AppUser addNewUser(String username, String password, String confirmPassword, String email) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser != null) {
            throw new RuntimeException("User already exists");
        }
        if(!password.equals(confirmPassword)) {
            throw new RuntimeException("Passwords do not match");
        }
        appUser = AppUser.builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole addNewRole(String role) {
        AppRole appRole = appRoleRepository.findById(role).orElse(null);
        if(appRole != null) {
            throw new RuntimeException("Role already exists");
        }
        appRole = AppRole.builder().role(role).build();
        return appRoleRepository.save(appRole);
    }

    @Override
    public void affectRole(String username, String role) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findById(role).orElse(null);
        appUser.getRoles().add(appRole);
//        appUserRepository.save(appUser);
    }

    @Override
    public void removeRole(String username, String role) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findById(role).orElse(null);
        appUser.getRoles().remove(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}
