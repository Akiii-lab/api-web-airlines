package ProgramacionWeb.security.jwt;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import ProgramacionWeb.database.entities.Cliente;
import ProgramacionWeb.database.repositories.ClienteRepository;

@Service
public class ClientUserDetailsService implements UserDetailsService {

    @Autowired
    private ClienteRepository clientRepository;

    public ClientUserDetailsService(ClienteRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente user = clientRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return new User(user.getCorreo(), user.getPassword(), mapRolesToAuthorities(user.getRole()));
    }
    private Collection<GrantedAuthority> mapRolesToAuthorities(String role) {
        return List.of(new SimpleGrantedAuthority(role));
    }
}
