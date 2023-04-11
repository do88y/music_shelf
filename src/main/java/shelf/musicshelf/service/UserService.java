package shelf.musicshelf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shelf.musicshelf.domain.User;
import shelf.musicshelf.repository.UserRepository;

import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * 이름 중복 체크
     */
    public String usernameCheck(String username) {
        boolean exists = userRepository.existsByUsername(username);

        if (exists) throw  new IllegalArgumentException("존재하는 이름입니다.");
        else        return "확인";

    }

    /**
     * 회원가입
     */
    @Transactional
    public String join(User user) {
        userRepository.save(user);
        return user.getUsername();
    }

    /**
     * 로그인
     */
    public String login(String username, String password) {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new NoSuchElementException("가입되지 않은 이름입니다."));
        if (!password.equals(user.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        return username;
    }
}
