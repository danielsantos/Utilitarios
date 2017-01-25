import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeArquivo {

	public static void main(String[] args) {

		try {
			FileReader fileReader = new FileReader("/teste/arquivo.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String linha = bufferedReader.readLine();

			while (linha != null) {
				System.out.printf("%s\n", linha);
				linha = bufferedReader.readLine();
			}

			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
