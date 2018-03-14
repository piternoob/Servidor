package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManipularArchivosServlet
 */
@WebServlet("/ManipularArchivos")
public class ManipularArchivosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManipularArchivosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext contexto = getServletContext();
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='UTF-8'/></head><body>");
		
		out.println(contexto.getRealPath("/files/modulos.txt"));
		
		/*String ruta = contexto.getRealPath("/files/modulos.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(
		        new FileInputStream(ruta), "UTF-8"));
		String linea;
		while((linea = br.readLine()) != null)
			out.println("<p>"+linea +"</p>");
		br.close();*/

		/*String ruta = contexto.getRealPath("/files/modulos.txt");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(ruta), "UTF-8"));
		bw.write("Lenguajes de marcas\n");
		bw.write("Entornos de desarrollo\n");
		bw.close();*/
		
		/*String ruta = contexto.getRealPath("/files/modulos.txt");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(ruta), "UTF-8"));
		bw.append("Lenguajes de marcas\n");
		bw.append("Entornos de desarrollo\n");
		bw.close();*/
		
		/*String ruta = contexto.getRealPath("/files/modulos.txt");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
		      new FileOutputStream(ruta,true), "UTF-8"));
		bw.write("¿He podido añadir esta línea? Contiene UTF-8\n");
		bw.close();*/

		/*String ruta = contexto.getRealPath("/files/nuevo.txt");
		File archivo = new File(ruta);
		archivo.createNewFile();*/

		/*String ruta = contexto.getRealPath("/files/nuevo.txt");
		File archivo = new File(ruta);
		archivo.delete();*/

		/*ArrayList<String> nombres = new ArrayList<String>();
		nombres.add("Julia");
		nombres.add("Ana");
		nombres.add("Sergio");
		nombres.add("Alberto");

		nombres.stream()
			.filter(s -> s.startsWith("A"))
			.map(String::toUpperCase)
			.sorted()
			.forEach(out::println);
		*/

		/*Path path = Paths.get(contexto.getRealPath("/files/modulos.txt"));
		try (Stream<String> stream = Files.lines(path)) {
	        stream.forEach(out::println);
		} catch (Exception e) {
	        out.println(e.toString());
		}*/
		
		Path path = Paths.get(contexto.getRealPath("/files/modulos.txt"));
		/*try (Stream<String> stream = Files.lines(path)) {
		  stream.forEach(s -> {
		    out.println(s);
		  });
		} catch (Exception e) {
		  out.println(e.toString());
		}*/
		
		/*try (Stream<String> stream = Files.lines(path)) {
			  stream.forEach(s -> {
			        out.println(s + "<br/>");
			});
			} catch (Exception e) {
			    out.println(e.toString());
			}*/
		
		/*try (Stream<String> stream = Files.lines(path)) {
			stream.forEach(s -> {
				if (s.startsWith("L"))
					out.println(s + "<br/>");
			});
		} catch (Exception e) {
			out.println(e.toString());
		}*/

		/*try (Stream<String> stream = Files.lines(path)) {
			stream
			.filter(s -> s.startsWith("L"))
			.forEach(s -> out.println(s + "<br/>"));
		} catch (Exception e) {
			out.println(e.toString());
		}*/

		/*try (Stream<String> stream = Files.lines(path)) {
			stream
			.filter(s -> s.startsWith("L"))
			.map(String::toUpperCase)
			.sorted()
			.forEach(s -> out.println(s + "<br/>"));
		}catch (Exception e) {
			out.println(e.toString());
		}*/		
		
		Path rutaArchivoEscritura = Paths.get(contexto.getRealPath("/files/modulos.txt"));        
		/*try (BufferedWriter writer = Files.newBufferedWriter(rutaArchivoEscritura, StandardCharsets.UTF_8)) {
		  writer.write("Desarrollo web en entorno servidor\n");
		  writer.write("Inglés técnico\n");   
		}*/

		/*try (BufferedWriter writer = Files.newBufferedWriter(rutaArchivoEscritura, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
		  writer.write("Lenguajes de Marcas\n");
		  writer.write("Entornos de desarrollo\n");
		}*/

		Path rutaArchivoSecreto = Paths.get(contexto.getRealPath("/WEB-INF/secreto.txt"));      
		try (BufferedWriter writer = Files.newBufferedWriter(rutaArchivoSecreto, StandardCharsets.UTF_8)) {
			writer.write("Información no visible por los usuarios\n");  
		}
		
		out.println("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
