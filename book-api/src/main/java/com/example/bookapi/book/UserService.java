package com.example.bookapi.book;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::from)
                .toList();
    }

    public UserResponse findById(Long id) {
        Users user = getName(id);
        return UserResponse.from(user);
    }

    @Transactional
    public UserResponse create(UserRequest request) {
        Users user = new Users(
                request.name(),
                request.passwd(),
                request.age(),
                request.birth()
        );

        Users savedUsers = userRepository.save(user);
        return UserResponse.from(savedUsers);
    }

    @Transactional
    public UserResponse update(Long id, UserRequest request) {
        Users user = getName(id);

        user.setName(request.name());
        user.setPasswd(request.passwd());
        user.setAge(request.age());
        user.setBirth(request.birth());

        Users saveduUsers = userRepository.save(user);
        return UserResponse.from(saveduUsers);
    }

    @Transactional
    public void delete(Long id) {
        Users users = getName(id);
        userRepository.delete(users);
    }

    private Users getName(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "User를 찾을 수 없습니다. id=" + id
                ));
    }
}
