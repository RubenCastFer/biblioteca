package clases;

public class Libro {
	
	private String titulo;
	private static String isbn;
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
	
	public static String getIsbn() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paginas == null) ? 0 : paginas.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (paginas == null) {
			if (other.paginas != null)
				return false;
		} else if (!paginas.equals(other.paginas))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equalsIgnoreCase(other.titulo))
			return false;
		return true;
	}

	
	
	//m equal y cadena.equalsignorecase()
}
