package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Backup {
	
		public static void fazBackup(){
			File arq = new File(System.getProperty("user.home"), "Desktop\\database.backup");
			if (arq.exists()){
				if (arq.length() > 0)
					arq.delete();
			}
			try {
				Process p = null;
				String linha = "";
				ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\PostgreSQL\\12\\bin\\"+"pg_dump.exe", "-h", "localhost", "-U", "postgres", "-F", "c", "-b", "-v", "-f", arq.getAbsolutePath(), "SisPagamento");
				pb.environment().put("PGPASSWORD", "123");
				pb.redirectErrorStream(true);
				p = pb.start();
				BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((linha = reader.readLine()) != null){
					System.out.println(linha);
				}
			}catch (Exception e) {
				System.out.println(e);
			}
		}
	}

