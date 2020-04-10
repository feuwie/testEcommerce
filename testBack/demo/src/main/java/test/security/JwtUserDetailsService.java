// package test.security;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;

// import test.model.User;
// import test.service.UserService;

// public class JwtUserDetailsService implements UserDetailsService{
//     private final UserService userService;


//     @Autowired
//     public JwtUserDetailsService(UserService userService) {
//         this.userService = userService;
//     }

//     @Override
//     public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//         User user = userService.findByUsername(username);
//         if (user == null) {
//             throw new UsernameNotFoundException("User with username: " + username + " not found");
//         }


//         return null;
//     }
// }