package nesims.main;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//StandAlone Application to generate a hashed password for the users accounts using SpringBoot
//internal encoder(BCrypt)
public class passwordGen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		while (i < 10) {
			String password = "4321";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);

			System.out.println(hashedPassword);
			i++;
		}
	}

}
