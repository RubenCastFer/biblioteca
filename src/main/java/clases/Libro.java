package clases;

public class Libro {
	
	private String titulo;
	private String isbn;
	private Genero genero;
	private String autor;
	private Integer paginas;
	
	public Libro() {
		
	}
	
	public Libro(String titulo, String isbn, Genero genero, String autor, Integer paginas) {
		this.titulo=titulo;
		this.isbn=isbn;
		this.genero=genero;
		this.autor=autor;
		this.paginas=paginas;
	}
	
	public void setTitulo(String titulo) {
		this.titulo=titulo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setIsbn(String isbn) {
		this.isbn=isbn;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void genero(Genero genero) {
		this.genero=genero;
	}
	
	public Genero getGenero() {
		return genero;
	}
	
	public void setAutor (String autor) {
		this.autor=autor;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setPaginas(Integer paginas) {
		this.paginas = null;
		if (paginas>0)
			this.paginas=paginas;
	}
	
	public Integer getPaginas() {
		return paginas;
	}

	@Override
	public String toString() {
		return "Datos del libro [titulo: " + titulo + ", isbn: " + isbn + ", genero: " + genero + ", autor: " + autor + ", paginas: "
				+ paginas + "]";
	}
	
	//m equal y cadena.equalsignorecase()
}
