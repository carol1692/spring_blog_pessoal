package com.generation.blogpessoal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class BlogpessoalApplication {

	public static void main(String[] args) {
		 try {
	            // Tenta carregar o .env (para uso local)
	            Dotenv dotenv = Dotenv.configure()
	                                  .ignoreIfMissing()  // Evita erro se o arquivo não existir
	                                  .load();

	            // Carrega variáveis locais no System se existirem
	            dotenv.entries().forEach(entry -> {
	                if (System.getenv(entry.getKey()) == null) {
	                    System.setProperty(entry.getKey(), entry.getValue());
	                }
	            });

	            System.out.println("✅ Variáveis de ambiente carregadas com sucesso!");
	        } catch (Exception e) {
	            System.out.println("⚠️ Nenhum arquivo .env encontrado (modo produção)");
	        }
		
		SpringApplication.run(BlogpessoalApplication.class, args);
	}

}
