package com.alten.product_trial.presentation.auth;

import static com.alten.product_trial.infra.security.JwtService.generateToken;

import com.alten.product_trial.domain.entity.User;
import com.alten.product_trial.domain.repository.UserRepository;
import com.alten.product_trial.infra.security.JwtService;
import com.alten.product_trial.presentation.auth.model.LoginDto;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @PostMapping("/account")
    public ResponseEntity<?> createAccount(@RequestBody User dto) {
        if(userRepository.existsByEmail(dto.getEmail()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email déjà utilisé");

        User user = User.builder()
            .email(dto.getEmail())
            .username(dto.getUsername())
            .firstname(dto.getFirstname())
            .password(passwordEncoder.encode(dto.getPassword()))
            .build();
        userRepository.save(user);
        return ResponseEntity.ok("Compte créé");
    }

    @PostMapping("/token")
    public ResponseEntity<?> login(@RequestBody LoginDto dto) {
        User user = userRepository.findByEmail(dto.getEmail())
            .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));

        if(!passwordEncoder.matches(dto.getPassword(), user.getPassword()))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Mot de passe incorrect");

        String token = generateToken(user);
        return ResponseEntity.ok(Map.of("token", token));
    }
}

