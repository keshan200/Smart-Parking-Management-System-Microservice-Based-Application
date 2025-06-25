package lk.ijse.userservice.service.impl;


import lk.ijse.userservice.dto.UserDTO;
import lk.ijse.userservice.entity.User;
import lk.ijse.userservice.repo.UserRepository;
import lk.ijse.userservice.service.UserService;
import lk.ijse.userservice.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService , UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;




    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
    }


    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
        return authorities;
    }

    public UserDTO loadUserByEmail(String email) throws UsernameNotFoundException {
        User byEmail = userRepository.findByEmail(email);
        return modelMapper.map(byEmail, UserDTO.class);
    }


    @Override
    public int saveUser(UserDTO userDTO) {
        if(userRepository.existsByEmail(userDTO.getEmail())){
            return VarList.Not_Acceptable;
        }else {
            BCryptPasswordEncoder bCryptPasswordEncoder =  new BCryptPasswordEncoder();
            userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));

            userRepository.save(modelMapper.map(userDTO, User.class));
            return VarList.Created;
        }
    }

    @Override
    public int updateUser(UserDTO userDTO) {
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
