public class Books {

    private Long id;
    private String title; 
    private String author;

    public Books(Long id, String title, String author){
        this.id = id; 
        this.title = title;
        this.author = author; 
    };

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    
}
