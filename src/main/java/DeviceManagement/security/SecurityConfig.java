package DeviceManagement.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//		disabilita CORS = Quando un browser fa una richiesta da un'origine (dominio, protocollo e porta) diversa rispetto a quella del server, 
//		il server può rispondere con determinati header CORS per specificare quali origini sono autorizzate a accedere alle risorse
		http.cors(c -> c.disable());
		
//		disabilita CSRF = CSRF è un attacco in cui un attaccante fa in modo che l'utente autenticato esegua azioni non intenzionali o dannose su un'applicazione web. 
		http.csrf(c -> c.disable());
		
//		configuro la gestione delle sessioni definendo la politica utilizzata, ovvero sessioni senza stato, cioè che l'applicazione potra operare senza sessioni
//		e tutte le richieste HTTP sono autorizzate (utilizzato spesso con JWT)
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
//		sto specificando una regola di autorizzazione che dice che tutte le richieste corrispondenti al pattern di URL "/home/**" sono consentite a tutti gli utenti, 
//		indipendentemente dall'autenticazione o dai ruoli.
		//http.authorizeHttpRequests(auth -> auth.requestMatchers("/home/**").permitAll());
		
		
		return http.build();
	}
}
