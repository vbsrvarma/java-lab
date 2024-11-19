//baseclass:book
public class Book {
    private int bookId;
    private String title;
    private String author;

public Book(int bookId, String title, String author) {
   this.bookId=bookId;
   this.title=title;
   this.author=author;
}
public int getbookId() {
return bookId;
}
public void setbookId(int bookId) {
this.bookId=bookId;
}
public String gettitle() {
return title;
}
public void settitle(String title) {
this.title=title;
}
public String getauthor() {
return author;
}
public void setauthor(String author) {
this.author=author;
}

//method for book information
public void displayBookInfo() {
   System.out.println("Book ID:" + bookId);
   System.out.println("title:" + title);
   System.out.println("author:" + author);
}
}

//derived class for reference book
public class ReferenceBook extends Book {
    private int edition;
public referenceBook(int bookId, String title, String author, int edition) {
    super(bookId,title,author);
    this.edition=edition;
}

public void displayBookInfo() {
   super.displayBookInfo();
   System.out.println("edition:" +edition);
}
}

//derived class for fiction book
public class FictionBook extends Book {
    private String genre;

public FictionBook(int bookId, String title, String author, String genre) {
    super(bookId, title, author);
    this.genre=genre;
}
public void displayBookInfo() {
   super.displayBookInfo();
   System.out.println("genre:" + genre);
}
}

//derived class for periodical
public class Periodical extends ReferenceBook {
    private String issueFrequency;

public Periodical(int bookId, String title, String author, int edition, String issueFrequency) {
    super(bookId, title, author, edition);
    this.issueFrequency=issueFrequency;
}
public void displayBookInfo() {
    super.displayBookInfo();
    System.out.println("IssueFrequency:"+issueFrequency);
    }
}


public class Book {
    public class book() {
    }
    }
    public void borrowBook() {
   System.out.println("Book borrowed");
}

public void returnBook() {
   System.out.println("Book returned");
}

public double calculateOverdueFine(Date returnedDate, Date dueDate) {
   long daysOverdue = (returnedDate.getTime() - dueDate.getTime()) / (24 * 60 * 60 * 1000);
   return daysOverdue * 2.0;
}

public int getTotalBooksAvailable() {
    return 0;
}

