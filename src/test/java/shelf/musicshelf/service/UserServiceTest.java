package shelf.musicshelf.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import shelf.musicshelf.domain.User;
import shelf.musicshelf.domain.UserRole;
import shelf.musicshelf.repository.UserRepository;

import java.util.Date;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;

    @Test()
    @DisplayName("이름 중복 시 예외 발생")
    void 이름_중복_체크() throws Exception {
        //given
        userRepository.save(user);

        //then
        assertThatThrownBy(
                () -> userService.usernameCheck("슬기"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test()
    @DisplayName("이름 중복 아닐 시 '확인'")
    void 이름_중복_체크_확인() throws Exception {
        //given
        userRepository.save(user);

        //then
        assertThat(userService.usernameCheck("안녕")).isEqualTo("확인");
    }

    @Test
    @DisplayName("회원가입 후 회원이름 반환")
    void 회원가입() throws Exception {
        //when
        String joinName = userService.join(user);

        //then
        assertThat(joinName).isEqualTo(user.getUsername());
    }

    @Test
    @DisplayName("잘못된 회원이름 입력 시 예외 발생")
    void 로그인_회원이름_예외() throws Exception {
        //given
        userService.join(user);

        //then
        assertThatThrownBy(
                () -> userService.login("안녕", "1234"))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("잘못된 비밀번호 입력 시 예외 발생")
    void 로그인_비밀번호_예외() throws Exception {
        //given
        userService.join(user);

        //then
        assertThatThrownBy(
                () -> userService.login("슬기", "1111"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정확한 회원정보 입력 시 회원이름 반환")
    void 로그인_성공() throws Exception {
        //given
        userService.join(user);

        //when
        String username = userService.login("슬기", "1234");

        //then
        assertThat(username).isEqualTo(user.getUsername());
    }
    User user = User.createUser("슬기", "1234", new Date(), UserRole.USER);

}