//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UserDetailsService userDetailsService;
//    // nezinau, del ko Autowired neveikia, tai galima per Bean tiesiai is konfiguracijos pakurti nauja objekta encoderio
//    @Bean
//    BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    };
//
//    // jei autorizacija nepatvirtinta, tai kur numesti (i pagridnini ar error, ar registruotis per naujo)
//    protected void configure(HttpSecurity http) throws Exception{
//        // kuriuos psl praleidziame (nes pirma login langa praleidziame neautorizavus, gali buti nepasijunges
//        // Taip pat ir JavaScript source ar pan)
//        // /resources/** < /** reiskia, kad viska
//        http.authorizeRequests().antMatchers("/resources/**", "/register").permitAll()
//                .anyRequest().authenticated()
//                // jei dar turim papildomu salygu, tai su and() pridedame
//                .and()
//                // login page, cia spring security
//                .formLogin().loginPage("/login").permitAll()
//                // cia nukreipiam, kai success
////                .defaultSuccessUrl("/welcomemainpage")  //< testuojam
//                // arba galima taip > nukreipia successHandler i objekta, kuriame apsirase redirect'a "/welcomemainpage"
//                .successHandler(new Successhandler())
////                // jei neveikia
////                .failureUrl("/login")
//                // ir tada issijungiam (?)
//                // logout() pagrazina i login langa arba gal galim apsirasyti savo logout langa?
//                .and().logout().permitAll()
//                // login ir logout yra spring main metodai, jei atsijungi su logout, tai pagrazina i login > kas yra mano loginMain.jsp
//                .logoutSuccessUrl("/")
//                .and().csrf().disable();
//        // praleidziame resourses visus, tada register langa, tada login ir tada nutraukiam viska
//    }