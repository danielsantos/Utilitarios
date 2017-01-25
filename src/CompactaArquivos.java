import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompactaArquivos {

	static final int TAMANHO_BUFFER = 4096; // 4kb
	
	public static void main(String[] args) {
		
		List<String> nomesArquivos = new ArrayList<String>();
		nomesArquivos.add("/teste/arq1.txt");
		nomesArquivos.add("/teste/arq2.txt");

		int cont;
		byte[] dados = new byte[TAMANHO_BUFFER];
		
		BufferedInputStream origem = null;
		FileInputStream streamDeEntrada = null;
		FileOutputStream destino = null;
		ZipOutputStream saida = null;
		ZipEntry entry = null;
				
		try {
			destino = new FileOutputStream(new File("/teste/arquivosCompactados.zip"));
			saida = new ZipOutputStream(new BufferedOutputStream(destino));
			
			for (String nome : nomesArquivos) {
			
				File file = new File(nome);
				streamDeEntrada = new FileInputStream(file);
				origem = new BufferedInputStream(streamDeEntrada, TAMANHO_BUFFER);
				entry = new ZipEntry(file.getName());
				
				saida.putNextEntry(entry);
				
				while ((cont = origem.read(dados, 0, TAMANHO_BUFFER)) != -1) {
					saida.write(dados, 0, cont);
				}
			
			}
			
			origem.close();
			saida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
