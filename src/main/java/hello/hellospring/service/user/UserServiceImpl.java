package hello.hellospring.service.user;




//@RequiredArgsConstructor
//@Service
public class UserServiceImpl {/*pimplements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User login(User user) {
        return userRepository.findByUserIdAndUserPw(user.getUserId(), user.getUserPw());
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User signup(final SignUpDTO signUpDTO) {
        final User user = User.builder()
                .userId(signUpDTO.getUserId())
                .userPw(passwordEncoder.encode(signUpDTO.getUserPw()))
                .userRole(UserRole.USER)
                .build();

        return userRepository.save(user);
    }


    @Override
    public Optional<User> findByUserId(final String userId){
        return userRepository.findByUserId(userId);
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }
*/
}