import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Arrays;

public class Drive { 
// adicione aqui o CLIENT_ID que nós criamos 
	private static String CLIENT_ID ="CLIENT_ID AQUI";
// adicione aqui o CLIENT_SECRET que nós criamos 
	private static String CLIENT_SECRET ="CLIENT_SECRET AQUI";
// a REDIRECT_URI vai ser a mesma sempre (provavelmente) 
	private static String REDIRECT_URI ="urn:ietf:wg:oauth:2.0:oob";
	public static void main(String[] args) throws IOException {
		HttpTransport httpTransport = new NetHttpTransport();
 		JsonFactory jsonFactory = new JacksonFactory();
	 //gera um código de autorização
	 	GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, jsonFactory, CLIENT_ID , CLIENT_SECRET ,Arrays. asList (DriveScopes.DRIVE)).setAccessType("online").setApprovalPrompt("auto").build();
		String urlAuthorization =flow.newAuthorizationUrl().setRedirectUri(REDIRECT_URI ).build();
//Optimizei para abrir a uri automaticamente 
		try {
			Desktop desktop = Desktop.getDesktop();
			URI uri = new URI(urlAuthorization);
			desktop.browse(uri);
		}catch(Exception ex){
			System.err.println("Erro ao abrir página");
			ex.printStackTrace();
		} 
		// aqui ele lê o código que retorna do site
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String code = br.readLine();
		GoogleTokenResponse response = flow.newTokenRequest(code).setRedirectUri(REDIRECT_URI).execute();
		GoogleCredential credential = new GoogleCredential().setFromTokenResponse(response);
	// Cria um nova autorização do API client
		Drive service = new Drive.Builder(httpTransport, jsonFactory,credential).build();
	// Insere um arquivo
		File body = new File();
		body.setTitle("My document");
	// descrição
		body.setDescription("A test document");
		body.setMimeType("text/plain");
	// local do arquivo, lembre-se de colocar um arquivo na pasta do projeto 
		java.io.File fileContent = new java.io.File("document.txt");
		FileContent mediaContent = new FileContent("text/plain", fileContent);
		File file = service.files().insert(body, mediaContent).execute();System.out.println("File ID: "+file.getId());
	}
}// fim da classe DriveCommandLine